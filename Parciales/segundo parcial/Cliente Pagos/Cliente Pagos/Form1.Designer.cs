namespace Cliente_Pagos
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
            txtCI = new TextBox();
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            txtNombres = new TextBox();
            label4 = new Label();
            txtPApellido = new TextBox();
            label5 = new Label();
            txtSApellido = new TextBox();
            BtnObtener = new Button();
            BtnPagar = new Button();
            BtnSalir = new Button();
            LtDeudas = new ListView();
            Id = new ColumnHeader();
            Ci = new ColumnHeader();
            Fecha = new ColumnHeader();
            Monto = new ColumnHeader();
            Empresa = new ColumnHeader();
            SuspendLayout();
            // 
            // txtCI
            // 
            txtCI.Location = new Point(114, 45);
            txtCI.Name = "txtCI";
            txtCI.Size = new Size(265, 23);
            txtCI.TabIndex = 0;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(114, 9);
            label1.Name = "label1";
            label1.Size = new Size(105, 15);
            label1.TabIndex = 1;
            label1.Text = "Pagos De Servicios";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(90, 49);
            label2.Name = "label2";
            label2.Size = new Size(18, 15);
            label2.TabIndex = 2;
            label2.Text = "CI";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(52, 78);
            label3.Name = "label3";
            label3.Size = new Size(56, 15);
            label3.TabIndex = 4;
            label3.Text = "Nombres";
            // 
            // txtNombres
            // 
            txtNombres.Location = new Point(114, 74);
            txtNombres.Name = "txtNombres";
            txtNombres.Size = new Size(265, 23);
            txtNombres.TabIndex = 3;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(19, 107);
            label4.Name = "label4";
            label4.Size = new Size(89, 15);
            label4.TabIndex = 6;
            label4.Text = "Primer Apellido";
            // 
            // txtPApellido
            // 
            txtPApellido.Location = new Point(114, 103);
            txtPApellido.Name = "txtPApellido";
            txtPApellido.Size = new Size(265, 23);
            txtPApellido.TabIndex = 5;
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(7, 136);
            label5.Name = "label5";
            label5.Size = new Size(101, 15);
            label5.TabIndex = 8;
            label5.Text = "Segundo Apellido";
            // 
            // txtSApellido
            // 
            txtSApellido.Location = new Point(114, 132);
            txtSApellido.Name = "txtSApellido";
            txtSApellido.Size = new Size(265, 23);
            txtSApellido.TabIndex = 7;
            // 
            // BtnObtener
            // 
            BtnObtener.Location = new Point(107, 309);
            BtnObtener.Name = "BtnObtener";
            BtnObtener.Size = new Size(75, 44);
            BtnObtener.TabIndex = 9;
            BtnObtener.Text = "Obtener Deudas";
            BtnObtener.UseVisualStyleBackColor = true;
            BtnObtener.Click += BtnObtener_Click;
            // 
            // BtnPagar
            // 
            BtnPagar.Location = new Point(188, 309);
            BtnPagar.Name = "BtnPagar";
            BtnPagar.Size = new Size(75, 44);
            BtnPagar.TabIndex = 10;
            BtnPagar.Text = "Pagar Deuda";
            BtnPagar.UseVisualStyleBackColor = true;
            BtnPagar.Click += BtnPagar_Click;
            // 
            // BtnSalir
            // 
            BtnSalir.Location = new Point(337, 330);
            BtnSalir.Name = "BtnSalir";
            BtnSalir.Size = new Size(75, 23);
            BtnSalir.TabIndex = 11;
            BtnSalir.Text = "Salir";
            BtnSalir.UseVisualStyleBackColor = true;
            BtnSalir.Click += BtnSalir_Click;
            // 
            // LtDeudas
            // 
            LtDeudas.Columns.AddRange(new ColumnHeader[] { Id, Ci, Fecha, Monto, Empresa });
            LtDeudas.Location = new Point(5, 161);
            LtDeudas.Name = "LtDeudas";
            LtDeudas.Size = new Size(470, 142);
            LtDeudas.TabIndex = 12;
            LtDeudas.UseCompatibleStateImageBehavior = false;
            LtDeudas.View = View.Details;
            // 
            // Id
            // 
            Id.Text = "Id";
            // 
            // Ci
            // 
            Ci.Text = "CI";
            Ci.Width = 100;
            // 
            // Fecha
            // 
            Fecha.Text = "Fecha";
            Fecha.Width = 100;
            // 
            // Monto
            // 
            Monto.Text = "Monto";
            Monto.Width = 100;
            // 
            // Empresa
            // 
            Empresa.Text = "Empresa";
            Empresa.Width = 100;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(482, 364);
            Controls.Add(LtDeudas);
            Controls.Add(BtnSalir);
            Controls.Add(BtnPagar);
            Controls.Add(BtnObtener);
            Controls.Add(label5);
            Controls.Add(txtSApellido);
            Controls.Add(label4);
            Controls.Add(txtPApellido);
            Controls.Add(label3);
            Controls.Add(txtNombres);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(txtCI);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TextBox txtCI;
        private Label label1;
        private Label label2;
        private Label label3;
        private TextBox txtNombres;
        private Label label4;
        private TextBox txtPApellido;
        private Label label5;
        private TextBox txtSApellido;
        private Button BtnObtener;
        private Button BtnPagar;
        private Button BtnSalir;
        private ListView LtDeudas;
        private ColumnHeader Fecha;
        private ColumnHeader Monto;
        private ColumnHeader Empresa;
        private ColumnHeader Id;
        private ColumnHeader Ci;
    }
}
