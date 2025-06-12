namespace Pago_Cliente
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            lstFacturas = new ListView();
            BtnBuscar = new Button();
            btnPagar = new Button();
            btnSalir = new Button();
            label1 = new Label();
            label2 = new Label();
            txtCi = new TextBox();
            SuspendLayout();
            // 
            // lstFacturas
            // 
            lstFacturas.Location = new Point(12, 83);
            lstFacturas.Name = "lstFacturas";
            lstFacturas.Size = new Size(656, 260);
            lstFacturas.TabIndex = 0;
            lstFacturas.UseCompatibleStateImageBehavior = false;
            // 
            // BtnBuscar
            // 
            BtnBuscar.Location = new Point(591, 54);
            BtnBuscar.Name = "BtnBuscar";
            BtnBuscar.Size = new Size(75, 23);
            BtnBuscar.TabIndex = 1;
            BtnBuscar.Text = "BUSCAR";
            BtnBuscar.UseVisualStyleBackColor = true;
            BtnBuscar.Click += BtnBuscar_Click;
            // 
            // btnPagar
            // 
            btnPagar.Location = new Point(12, 349);
            btnPagar.Name = "btnPagar";
            btnPagar.Size = new Size(75, 23);
            btnPagar.TabIndex = 2;
            btnPagar.Text = "PAGAR";
            btnPagar.UseVisualStyleBackColor = true;
            btnPagar.Click += btnPagar_Click;
            // 
            // btnSalir
            // 
            btnSalir.Location = new Point(593, 349);
            btnSalir.Name = "btnSalir";
            btnSalir.Size = new Size(75, 23);
            btnSalir.TabIndex = 3;
            btnSalir.Text = "SALIR";
            btnSalir.UseVisualStyleBackColor = true;
            btnSalir.Click += btnSalir_Click;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 15.75F, FontStyle.Regular, GraphicsUnit.Point, 0);
            label1.Location = new Point(123, 9);
            label1.Name = "label1";
            label1.Size = new Size(284, 30);
            label1.TabIndex = 4;
            label1.Text = "SISTEMA DE PAGOS CLIENTE";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(12, 57);
            label2.Name = "label2";
            label2.Size = new Size(92, 15);
            label2.TabIndex = 5;
            label2.Text = "INGRESE SU C.I.:";
            // 
            // txtCi
            // 
            txtCi.Location = new Point(110, 54);
            txtCi.Name = "txtCi";
            txtCi.Size = new Size(203, 23);
            txtCi.TabIndex = 6;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(678, 391);
            Controls.Add(txtCi);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(btnSalir);
            Controls.Add(btnPagar);
            Controls.Add(BtnBuscar);
            Controls.Add(lstFacturas);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private ListView lstFacturas;
        private Button BtnBuscar;
        private Button btnPagar;
        private Button btnSalir;
        private Label label1;
        private Label label2;
        private TextBox txtCi;
    }
}
