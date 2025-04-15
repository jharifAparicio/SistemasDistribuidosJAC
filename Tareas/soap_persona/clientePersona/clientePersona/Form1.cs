using System.Threading.Tasks;
using wsPersona;

namespace clientePersona
{
    public partial class Form1 : Form
    {
        wsPersona.wsPersonaSoapClient client = new wsPersona.wsPersonaSoapClient(wsPersona.wsPersonaSoapClient.EndpointConfiguration.wsPersonaSoap12);
        public Form1()
        {
            InitializeComponent();
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            listarPersonas();
        }

        public void listarPersonas()
        {
            ListaPersonas.Rows.Clear();
            List<Persona> personas = client.ListarPersonas().ToList();
            foreach (Persona persona in personas)
            {
                ListaPersonas.Rows.Add(persona.Ci, persona.Nombres, persona.PrimerApellido + " " + persona.SegundoApellido);
            }
        }

        public void borrarCuadros()
        {
            txtCi.Text = string.Empty;
            txtNombre.Text = string.Empty;
            txtPrimerApellido.Text = string.Empty;
            txtSegundoApellido.Text = string.Empty;
        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            Persona persona = client.ObtenerPersona(txtCi.Text);

            txtCi.Text = persona.Ci;
            txtNombre.Text = persona.Nombres;
            txtPrimerApellido.Text = persona.PrimerApellido;
            txtSegundoApellido.Text = persona.SegundoApellido;
        }

        private async void btnEditar_Click(object sender, EventArgs e)
        {
            var persona = new Persona
            {
                Ci = txtCi.Text,
                Nombres = txtNombre.Text,
                PrimerApellido = txtPrimerApellido.Text,
                SegundoApellido = txtSegundoApellido.Text,
            };

            String respuesta = client.ActualizarPersona(persona);
            String estado = respuesta.Split(':')[0];

            if (estado.Equals("Error"))
            {
                lblMensaje.Text = respuesta;
                lblMensaje.ForeColor = Color.Red;
                txtCi.Text = string.Empty;
            }
            else if (estado.Equals("Exito"))
            {
                lblMensaje.Text = respuesta;
                lblMensaje.ForeColor = Color.Green;
                borrarCuadros();
            }
            listarPersonas();
            await Task.Delay(1000);
            lblMensaje.Text = string.Empty;
        }

        private async void btnEliminar_Click(object sender, EventArgs e)
        {
            String respuesta = client.EliminarPersona(txtCi.Text);
            String estado = respuesta.Split(':')[0];

            if (estado.Equals("Error"))
            {
                lblMensaje.Text = respuesta;
                lblMensaje.ForeColor = Color.Red;
                txtCi.Text = string.Empty;
            }
            else if (estado.Equals("Exito"))
            {
                lblMensaje.Text = respuesta;
                lblMensaje.ForeColor = Color.Green;
                borrarCuadros();
            }
            listarPersonas();
            await Task.Delay(1000);
            lblMensaje.Text = string.Empty;
        }

        private void btnInsertar_Click(object sender, EventArgs e)
        {

        }
    }
}
