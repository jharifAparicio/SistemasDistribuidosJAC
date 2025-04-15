namespace clienteInscripcion
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
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            btnRegistrar = new Button();
            txtCi = new TextBox();
            txtNombres = new TextBox();
            txtPrApellido = new TextBox();
            txtSeApellidos = new TextBox();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(147, 38);
            label1.Name = "label1";
            label1.Size = new Size(24, 15);
            label1.TabIndex = 0;
            label1.Text = "CI: ";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(109, 96);
            label2.Name = "label2";
            label2.Size = new Size(62, 15);
            label2.TabIndex = 1;
            label2.Text = "Nombres: ";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(76, 157);
            label3.Name = "label3";
            label3.Size = new Size(95, 15);
            label3.TabIndex = 2;
            label3.Text = "Primer Apellido: ";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(73, 219);
            label4.Name = "label4";
            label4.Size = new Size(98, 15);
            label4.TabIndex = 3;
            label4.Text = "SegundoApellido";
            // 
            // btnRegistrar
            // 
            btnRegistrar.Location = new Point(556, 124);
            btnRegistrar.Name = "btnRegistrar";
            btnRegistrar.Size = new Size(75, 23);
            btnRegistrar.TabIndex = 4;
            btnRegistrar.Text = "Registrar";
            btnRegistrar.UseVisualStyleBackColor = true;
            btnRegistrar.Click += btnRegistrar_Click;
            // 
            // txtCi
            // 
            txtCi.Location = new Point(181, 35);
            txtCi.Name = "txtCi";
            txtCi.Size = new Size(100, 23);
            txtCi.TabIndex = 5;
            // 
            // txtNombres
            // 
            txtNombres.Location = new Point(181, 93);
            txtNombres.Name = "txtNombres";
            txtNombres.Size = new Size(100, 23);
            txtNombres.TabIndex = 6;
            // 
            // txtPrApellido
            // 
            txtPrApellido.Location = new Point(181, 154);
            txtPrApellido.Name = "txtPrApellido";
            txtPrApellido.Size = new Size(100, 23);
            txtPrApellido.TabIndex = 7;
            // 
            // txtSeApellidos
            // 
            txtSeApellidos.Location = new Point(181, 216);
            txtSeApellidos.Name = "txtSeApellidos";
            txtSeApellidos.Size = new Size(100, 23);
            txtSeApellidos.TabIndex = 8;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(txtSeApellidos);
            Controls.Add(txtPrApellido);
            Controls.Add(txtNombres);
            Controls.Add(txtCi);
            Controls.Add(btnRegistrar);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private Button btnRegistrar;
        private TextBox txtCi;
        private TextBox txtNombres;
        private TextBox txtPrApellido;
        private TextBox txtSeApellidos;
    }
}
