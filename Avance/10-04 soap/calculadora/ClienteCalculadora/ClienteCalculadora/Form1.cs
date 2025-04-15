using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using srCalculadora;
using static srCalculadora.wsCalculadoraSoapClient;

namespace ClienteCalculadora
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnCalcular_Click(object sender, EventArgs e)
        {
            wsCalculadoraSoapClient client = new wsCalculadoraSoapClient(EndpointConfiguration.wsCalculadoraSoap12); 
            
            int a = int.Parse(txtA.Text);
            int b = int.Parse(txtB.Text);
            int resultado = 0;

            switch (cbOperacion.SelectedIndex)
            {
                case 0:
                    resultado = client.Sumar(a, b);
                    lblResultado.Text = resultado.ToString();
                    break;
                case 1:
                    resultado = client.Restar(a, b);
                    lblResultado.Text = resultado.ToString();
                    break;
                case 2:
                    resultado = client.Multiplicar(a, b);
                    lblResultado.Text = resultado.ToString();
                    break;
                case 3:
                    if (b <= 0)
                    {
                        lblResultado.Text = "no se puede divider entre 0";
                    }
                    else
                    {
                        resultado = client.Dividir(a, b);
                        lblResultado.Text = resultado.ToString();
                    }
                    break;
                default:
                    lblResultado.Text = "debes insertar numeros en los cuadros de texto";
                    break;
            }
        }
    }
}
