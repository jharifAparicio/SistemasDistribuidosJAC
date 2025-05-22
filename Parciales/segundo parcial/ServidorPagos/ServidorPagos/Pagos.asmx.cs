using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Net.Http.Json;
using GraphQL;
using GraphQL.Client.Http;
using GraphQL.Client.Serializer.Newtonsoft;
using System.Threading.Tasks;
using Newtonsoft.Json;
using System.Net.Http;
using System.Text;

namespace ServidorPagos
{
    /// <summary>
    /// Descripción breve de Pagos
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class Pagos : System.Web.Services.WebService
    {
        public class PersonaResponse
        {
            public Persona persona { get; set; }
        }
        private Persona ConsultarSegipSync(string CI)
        {
            var query = @"
        query ($ci: String!) {
            persona(CI: $ci) {
                CI
                Nombres
                PrimerApellido
                SegundoApellido
            }
        }
    ";

            var variables = new { ci = CI };

            var requestBody = new
            {
                query = query,
                variables = variables
            };

            string jsonRequest = JsonConvert.SerializeObject(requestBody);

            using (var client = new HttpClient())
            {
                client.Timeout = TimeSpan.FromSeconds(5);
                var httpContent = new StringContent(jsonRequest, Encoding.UTF8, "application/json");

                var response = client.PostAsync("http://localhost:4000/graphql", httpContent).Result;
                if (!response.IsSuccessStatusCode)
                    return null;

                string jsonResponse = response.Content.ReadAsStringAsync().Result;

                // Deserializar con estructura que tenga Data.persona
                var graphResponse = JsonConvert.DeserializeObject<GraphQLResponse>(jsonResponse);
                return graphResponse?.Data?.Persona;
            }
        }

        public class GraphQLResponse
        {
            [JsonProperty("data")]
            public DataWrapper Data { get; set; }
        }

        public class DataWrapper
        {
            [JsonProperty("persona")]
            public Persona Persona { get; set; }
        }

        [WebMethod]
        public Deuda[] VerDeuda(string CI, string Nombres, string PrimerApellido, string SegundoApellido)
        {
            Persona persona = ConsultarSegipSync(CI);

            if (persona == null ||
                !string.Equals(persona.Nombres, Nombres, StringComparison.OrdinalIgnoreCase) ||
                !string.Equals(persona.PrimerApellido, PrimerApellido, StringComparison.OrdinalIgnoreCase) ||
                !string.Equals(persona.SegundoApellido, SegundoApellido, StringComparison.OrdinalIgnoreCase))
            {
                return null;
            }
            else
            {
                // consultemos a una app externa mediante https get
                // y devolvamos las deudas
                // por ahora devolvamos una deuda de ejemplo
                string cessa = "http://127.0.0.1:8000/api/facturas";
                string elapas = "http://127.0.0.1:9000/api/facturas";

                var client = new HttpClient();

                var response = client.GetAsync(cessa).Result;

                string json = response.Content.ReadAsStringAsync().GetAwaiter().GetResult();



                List<Factura> facturas = JsonConvert.DeserializeObject<List<Factura>>(json);

                Deuda[] deudas = facturas
                    .Where(f => f.pagado == 0 && f.Ci == CI)
                    .Select(f => new Deuda
                    {
                        Id = f.id.ToString(),
                        CI = f.Ci,
                        Fecha = f.fechaFactura,
                        Monto = f.monto,
                        Empresa = "CESSA"
                    })
                    .ToArray();

                // consultaommos a la otra api y hacemos lo mismo pero esta vez con elapas
                response = client.GetAsync(elapas).Result;
                json = response.Content.ReadAsStringAsync().GetAwaiter().GetResult();
                facturas = JsonConvert.DeserializeObject<List<Factura>>(json);
                deudas = deudas.Concat(facturas
                    .Where(f => f.pagado == 0 && f.Ci == CI)
                    .Select(f => new Deuda
                    {
                        Id = f.id.ToString(),
                        CI = f.Ci,
                        Fecha = f.fechaFactura,
                        Monto = f.monto,
                        Empresa = "ELAPAS"
                    })
                    .ToArray()).ToArray();
                return deudas;
            }
        }

        [WebMethod]
        public void PagarDeuda(Deuda c)
        {

        }
    }
}
