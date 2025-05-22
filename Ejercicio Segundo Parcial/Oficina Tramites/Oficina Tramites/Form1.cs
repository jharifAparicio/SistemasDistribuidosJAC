using System.Net.Http.Json;
using GraphQL;
using GraphQL.Client.Http;
using GraphQL.Client.Serializer.Newtonsoft;

namespace Oficina_Tramites
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        public class Person
        {
            public string CI { get; set; }
            public string Nombres { get; set; }
            public string PrimerApellido { get; set; }
            public string SegundoApellido { get; set; }
            public string Titulo { get; set; }
        }

        private async void Emitir_Click(object sender, EventArgs e)
        {
            Segip.SegipSoapClient client = new Segip.SegipSoapClient(Segip.SegipSoapClient.EndpointConfiguration.SegipSoap12);
            Segip.Persona p = new Segip.Persona();

            // tomamos los datos de los textbox para poder hacer la consulta
            p.CI = tbCi.Text;
            p.Nombres = tbNombres.Text;
            p.PrimerApellido = tbPrimerApellido.Text;
            p.SegundoApellido = tbSegundoApellido.Text;

            // creamos una perosna para registrar en ACADEMICO
            Person persona = new Person();
            persona.CI = p.CI;
            persona.Nombres = p.Nombres;
            persona.PrimerApellido = p.PrimerApellido;
            persona.SegundoApellido = p.SegundoApellido;
            persona.Titulo = tbTitulo.Text;

            // validamos si existe la persona
            bool validacion = client.VerificarDatos(p.CI);

            // tomamos acciones dependiendo de la validacion
            if (validacion)
            {
                Segip.Persona personaTitulo = client.ObtenerDatos(p.CI);
                // hacemos la consulta a la API de SEDUCA
                var server = new GraphQLHttpClient("http://localhost:4000/graphql", new NewtonsoftJsonSerializer());

                var request = new GraphQLRequest
                {
                    Query = @"
                query ($ci: String!) {
                    persona(CI: $ci) {
                        CI
                        Nombres
                        PrimerApellido
                        SegundoApellido
                        EsBachiller
                    }
                }
            ",
                    Variables = new
                    {
                        ci = p.CI
                    }
                };

                var response = await server.SendQueryAsync<dynamic>(request);

                var bachiller = response.Data.persona;
                if(bachiller.EsBachiller == true)
                {
                    var http = new HttpClient();
                    var getResponse = await http.GetAsync($"http://localhost:8000/api/titulos/{p.CI}");
                    if (getResponse.IsSuccessStatusCode)
                    {
                        var responseString = await getResponse.Content.ReadAsStringAsync();
                        txtError.BackColor = Color.Green;
                        txtError.Text = "estudiante registrado con anterioridad";
                    }
                    else
                    {
                        // registramos al estudiante en ACADEMICO
                        var postResponse = await http.PostAsJsonAsync("http://localhost:8000/api/titulos", persona);
                        if (postResponse.IsSuccessStatusCode)
                        {
                            txtError.BackColor = Color.Green;
                            txtError.Text = "estudiante registrado con exito";
                        }
                        else
                        {
                            txtError.BackColor = Color.Red;
                            // muestra el error
                            var errorString = await postResponse.Content.ReadAsStringAsync();
                            txtError.Text = errorString;
                        }
                    }
                }
                else
                {
                    txtError.BackColor = Color.Red;
                    txtError.Text = "No es bachiller";
                }
            }
            else
            {
                txtError.BackColor = Color.Red;
                txtError.Text = "No existe la persona";
            }
        }
    }
}
