namespace cliente
{
    public partial class Form1 : Form
    {
        wsCotizacion.wsCotizacionSoapClient client = new wsCotizacion.wsCotizacionSoapClient(wsCotizacion.wsCotizacionSoapClient.EndpointConfiguration.wsCotizacionSoap12);
        public Form1()
        {
            InitializeComponent();
        }

        private void btnSalir_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void btnConsultar_Click(object sender, EventArgs e)
        {
            DateTime fecha = dtpFecha.Value.Date;
            // lblDebug.Text = fecha.ToString();
            wsCotizacion.Cotizacion cotizacion = client.obtenerCotizacion(fecha);

            txtCotizacion.Text = cotizacion.cotizacion.ToString();
            txtCotizacionOficial.Text = cotizacion.cotizacionOficial.ToString();
        }

        private void btnGuardar_Click(object sender, EventArgs e)
        {
            DateTime fecha = dtpFecha.Value.Date;
            string cotizacion = txtCotizacion.Text;

            string respuesta = client.registrarCotizacion(fecha, cotizacion);

            lblDebug.Text = respuesta;
        }
    }
}
