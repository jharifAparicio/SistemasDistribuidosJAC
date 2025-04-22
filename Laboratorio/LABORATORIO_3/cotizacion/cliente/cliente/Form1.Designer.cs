namespace cliente
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
            dtpFecha = new DateTimePicker();
            label1 = new Label();
            txtCotizacion = new TextBox();
            txtCotizacionOficial = new TextBox();
            label2 = new Label();
            label3 = new Label();
            btnGuardar = new Button();
            btnConsultar = new Button();
            btnSalir = new Button();
            lblDebug = new Label();
            SuspendLayout();
            // 
            // dtpFecha
            // 
            dtpFecha.Format = DateTimePickerFormat.Short;
            dtpFecha.Location = new Point(37, 54);
            dtpFecha.Name = "dtpFecha";
            dtpFecha.Size = new Size(227, 23);
            dtpFecha.TabIndex = 1;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(40, 37);
            label1.Name = "label1";
            label1.Size = new Size(36, 15);
            label1.TabIndex = 2;
            label1.Text = "fecha";
            // 
            // txtCotizacion
            // 
            txtCotizacion.Location = new Point(37, 129);
            txtCotizacion.Name = "txtCotizacion";
            txtCotizacion.Size = new Size(227, 23);
            txtCotizacion.TabIndex = 3;
            // 
            // txtCotizacionOficial
            // 
            txtCotizacionOficial.Location = new Point(37, 214);
            txtCotizacionOficial.Name = "txtCotizacionOficial";
            txtCotizacionOficial.Size = new Size(227, 23);
            txtCotizacionOficial.TabIndex = 4;
            txtCotizacionOficial.Text = "6.97";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(40, 111);
            label2.Name = "label2";
            label2.Size = new Size(63, 15);
            label2.TabIndex = 5;
            label2.Text = "Cotizacion";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(39, 196);
            label3.Name = "label3";
            label3.Size = new Size(100, 15);
            label3.TabIndex = 6;
            label3.Text = "Cotizacion Oficial";
            // 
            // btnGuardar
            // 
            btnGuardar.Location = new Point(315, 54);
            btnGuardar.Name = "btnGuardar";
            btnGuardar.Size = new Size(75, 23);
            btnGuardar.TabIndex = 7;
            btnGuardar.Text = "Guardar";
            btnGuardar.UseVisualStyleBackColor = true;
            btnGuardar.Click += btnGuardar_Click;
            // 
            // btnConsultar
            // 
            btnConsultar.Location = new Point(315, 129);
            btnConsultar.Name = "btnConsultar";
            btnConsultar.Size = new Size(75, 23);
            btnConsultar.TabIndex = 8;
            btnConsultar.Text = "Consultar";
            btnConsultar.UseVisualStyleBackColor = true;
            btnConsultar.Click += btnConsultar_Click;
            // 
            // btnSalir
            // 
            btnSalir.Location = new Point(315, 214);
            btnSalir.Name = "btnSalir";
            btnSalir.Size = new Size(75, 23);
            btnSalir.TabIndex = 9;
            btnSalir.Text = "Salir";
            btnSalir.UseVisualStyleBackColor = true;
            btnSalir.Click += btnSalir_Click;
            // 
            // lblDebug
            // 
            lblDebug.AutoSize = true;
            lblDebug.Location = new Point(35, 249);
            lblDebug.Name = "lblDebug";
            lblDebug.Size = new Size(0, 15);
            lblDebug.TabIndex = 10;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(430, 275);
            Controls.Add(lblDebug);
            Controls.Add(btnSalir);
            Controls.Add(btnConsultar);
            Controls.Add(btnGuardar);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(txtCotizacionOficial);
            Controls.Add(txtCotizacion);
            Controls.Add(label1);
            Controls.Add(dtpFecha);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion
        private DateTimePicker dtpFecha;
        private Label label1;
        private TextBox txtCotizacion;
        private TextBox txtCotizacionOficial;
        private Label label2;
        private Label label3;
        private Button btnGuardar;
        private Button btnConsultar;
        private Button btnSalir;
        private Label lblDebug;
    }
}
