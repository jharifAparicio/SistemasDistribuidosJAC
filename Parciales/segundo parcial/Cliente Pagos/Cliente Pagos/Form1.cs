namespace Cliente_Pagos
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void BtnSalir_Click(object sender, EventArgs e)
        {
            // Cierra la aplicacion
            Application.Exit();
        }

        private void BtnObtener_Click(object sender, EventArgs e)
        {
            // creamos las variables
            string ci = txtCI.Text;
            string nombres = txtNombres.Text;
            string pApellido = txtPApellido.Text;
            string sApellido = txtSApellido.Text;

            WsPagos.PagosSoapClient client = new WsPagos.PagosSoapClient(WsPagos.PagosSoapClient.EndpointConfiguration.PagosSoap12);
            // obtenemos todas las deudas de cliente
            var deudas = client.VerDeuda(ci, nombres,pApellido,sApellido);

            // mostramos la deuda en el listview
            // Limpiar ítems actuales
            LtDeudas.Items.Clear();

            // Agregar ítems con un foreach
            foreach (var d in deudas)
            {
                var item = new ListViewItem(d.Id);
                item.SubItems.Add(d.CI);
                item.SubItems.Add(d.Fecha);
                item.SubItems.Add(d.Monto);

                LtDeudas.Items.Add(item);
            }
        }

        private void BtnPagar_Click(object sender, EventArgs e)
        {

        }
    }
}
