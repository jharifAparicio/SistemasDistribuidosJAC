namespace clienteInscripcion
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnRegistrar_Click(object sender, EventArgs e)
        {
            srPersona.wsPersonaSoapClient client = new srPersona.wsPersonaSoapClient(srPersona.wsPersonaSoapClient.EndpointConfiguration.wsPersonaSoap12);
            srPersona.Persona p = new srPersona.Persona();

        }
    }
}
