using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Net.Http;
using System.Web.Services;
using Newtonsoft.Json;

namespace PlataformaPagosSOAP
{
    /// <summary>
    /// Descripción breve de pagos
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class pagos : System.Web.Services.WebService
    {
        // metodo para ver todas las facturas de las 3 empresas
        [WebMethod]
        public Factura[] VerDeuda(string CI)
        {
            var client = new HttpClient();

            string cessaUrl = $"http://127.0.0.1:8000/api/facturas/{CI}";
            string elapasUrl = $"http://localhost:3000/facturas/{CI}";
            string entelUrl = "http://localhost:4000/graphql";

            // CESSA
            var resCessa = client.GetAsync(cessaUrl).Result;
            var jsonCessa = resCessa.Content.ReadAsStringAsync().Result;
            var facturasCessa = JsonConvert.DeserializeObject<List<Factura>>(jsonCessa);
            foreach (var f in facturasCessa)
                f.empresa = "CESSA";

            // ELAPAS
            var resElapas = client.GetAsync(elapasUrl).Result;
            var jsonElapas = resElapas.Content.ReadAsStringAsync().Result;
            var facturasElapas = JsonConvert.DeserializeObject<List<Factura>>(jsonElapas);
            foreach (var f in facturasElapas)
                f.empresa = "ELAPAS";

            // ENTEL (GraphQL)
            string graphqlQuery = @"
                query ($ci: String!) {
                    facturasPorCI(ci: $ci) {
                        nroFactura
                        ci
                        nombreCompleto
                        periodo
                        monto
                        estado
                    }
                }
            ";

            var graphqlRequest = new
            {
                query = graphqlQuery,
                variables = new { ci = CI }
            };

            var content = new StringContent(
                JsonConvert.SerializeObject(graphqlRequest),
                Encoding.UTF8,
                "application/json"
            );

            var resEntel = client.PostAsync(entelUrl, content).Result;
            var jsonEntel = resEntel.Content.ReadAsStringAsync().Result;

            var entelResponse = JsonConvert.DeserializeObject<EntelResponse>(jsonEntel);
            foreach (var f in entelResponse.data.facturasPorCI)
                f.empresa = "ENTEL";

            // Combinar
            List<Factura> todasFacturas = new List<Factura>();
            todasFacturas.AddRange(facturasCessa);
            todasFacturas.AddRange(facturasElapas);
            todasFacturas.AddRange(entelResponse.data.facturasPorCI);

            return todasFacturas.ToArray();
        }

        // Clases auxiliares para GraphQL
        public class EntelResponse
        {
            public EntelData data { get; set; }
        }

        public class EntelData
        {
            public List<Factura> facturasPorCI { get; set; }
        }
        //pagamos las facturas
        [WebMethod]
        public void Pagar(Factura[] facturas)
        {
            var client = new HttpClient();
            var facturasPagadas = new List<Factura>();

            foreach (var factura in facturas)
            {
                try
                {
                    if (factura.empresa == "CESSA" || factura.empresa == "ELAPAS")
                    {
                        // Definir URL REST según empresa
                        string baseUrl = factura.empresa == "CESSA"
                            ? "http://127.0.0.1:8000/api/facturas/"
                            : "http://127.0.0.1:3000/facturas/";

                        string url = baseUrl + factura.nroFactura;

                        // Enviar PUT para actualizar estado a "Pagado"
                        var body = new StringContent("{\"estado\":\"Pagado\"}", Encoding.UTF8, "application/json");
                        var res = client.PutAsync(url, body).Result;

                        if (!res.IsSuccessStatusCode)
                            throw new Exception($"Error al pagar en {factura.empresa}: {res.StatusCode}");
                    }
                    else if (factura.empresa == "ENTEL")
                    {
                        string mutation = $@"
                    mutation {{
                        pagarFactura(nroFactura: ""{factura.nroFactura}"") {{
                            nroFactura
                            estado
                        }}
                    }}";

                        var request = new
                        {
                            query = mutation
                        };

                        var content = new StringContent(JsonConvert.SerializeObject(request), Encoding.UTF8, "application/json");
                        var response = client.PostAsync("http://localhost:4000/graphql", content).Result;

                        if (!response.IsSuccessStatusCode)
                            throw new Exception("Error al pagar en ENTEL");
                    }

                    // Marcar como pagada y agregar a lista de enviados
                    factura.estado = "Pagado";
                    facturasPagadas.Add(factura);

                }
                catch (Exception ex)
                {
                    Console.WriteLine($"Error al pagar factura {factura.nroFactura}: {ex.Message}");
                }
            }
            // Enviar todas las facturas pagadas a RabbitMQ
            if (facturasPagadas.Any())
            {
                var sender = new RabbitMQSender();
                sender.EnviarMensaje(facturasPagadas);
            }
        }
    }
}
