using System;
using System.Collections.Generic;
using System.Windows.Forms;
using plataformaPagos; // Importa la clase generada por la referencia al servicio

namespace Pago_Cliente
{
    public partial class Form1 : Form
    {
        private pagosSoapClient client;

        public Form1()
        {
            InitializeComponent();
            ConfigurarListView();
            client = new pagosSoapClient(pagosSoapClient.EndpointConfiguration.pagosSoap12);
        }

        private void BtnBuscar_Click(object sender, EventArgs e)
        {
            string ci = txtCi.Text.Trim();
            if (string.IsNullOrEmpty(ci))
            {
                MessageBox.Show("Ingrese un CI válido");
                return;
            }

            try
            {
                Factura[] facturas = client.VerDeuda(ci); // ← llamada al servicio

                if (facturas == null || facturas.Length == 0)
                {
                    MessageBox.Show("No hay facturas pendientes para este CI.");
                    lstFacturas.Items.Clear();
                    return;
                }

                CargarFacturasEnListView(facturas);
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al consultar deudas: " + ex.Message);
            }
        }

        private void btnPagar_Click(object sender, EventArgs e)
        {
            var facturasSeleccionadas = ObtenerFacturasSeleccionadas();

            if (facturasSeleccionadas.Count == 0)
            {
                MessageBox.Show("Seleccione al menos una factura para pagar.");
                return;
            }

            try
            {
                client.Pagar(facturasSeleccionadas.ToArray());

                MessageBox.Show("Pago realizado con éxito.");
                BtnBuscar_Click(null, null); // Vuelve a consultar las deudas
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al pagar facturas: " + ex.Message);
            }
        }


        private void btnSalir_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("¿Está seguro de que desea salir?", "Confirmar salida", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes)
            {
                Application.Exit();
            }
        }

        private void ConfigurarListView()
        {
            lstFacturas.View = View.Details;
            lstFacturas.FullRowSelect = true;
            lstFacturas.MultiSelect = true;

            lstFacturas.Columns.Clear();
            lstFacturas.Columns.Add("Empresa", 100);
            lstFacturas.Columns.Add("NroFactura", 100);
            lstFacturas.Columns.Add("CI", 100);
            lstFacturas.Columns.Add("Nombre", 150);
            lstFacturas.Columns.Add("Periodo", 100);
            lstFacturas.Columns.Add("Monto", 100);
            lstFacturas.Columns.Add("Estado", 100);
        }

        private void CargarFacturasEnListView(Factura[] facturas)
        {
            lstFacturas.Items.Clear();

            foreach (var f in facturas)
            {
                if (f == null || f.estado != "Pendiente")
                {
                    continue; // Solo carga facturas pendientes
                }
                ListViewItem item = new ListViewItem(f.empresa);
                item.SubItems.Add(f.nroFactura);
                item.SubItems.Add(f.ci);
                item.SubItems.Add(f.nombreCompleto);
                item.SubItems.Add(f.periodo);
                item.SubItems.Add(f.monto.ToString(".Bs")); // Formato moneda
                item.SubItems.Add(f.estado.ToString());   // ← Asegura conversión a string

                item.Tag = f; // Guarda la factura original

                lstFacturas.Items.Add(item);
            }
        }

        private List<Factura> ObtenerFacturasSeleccionadas()
        {
            List<Factura> seleccionadas = new List<Factura>();

            foreach (ListViewItem item in lstFacturas.SelectedItems)
            {
                if (item.Tag is Factura factura && factura.estado == "Pendiente")
                {
                    seleccionadas.Add(factura);
                }
            }

            return seleccionadas;
        }
    }
}
