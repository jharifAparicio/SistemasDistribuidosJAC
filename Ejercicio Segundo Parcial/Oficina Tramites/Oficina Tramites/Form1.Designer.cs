namespace Oficina_Tramites
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
            tbCi = new TextBox();
            label2 = new Label();
            label3 = new Label();
            tbNombres = new TextBox();
            label4 = new Label();
            tbPrimerApellido = new TextBox();
            label5 = new Label();
            tbSegundoApellido = new TextBox();
            label6 = new Label();
            tbTitulo = new TextBox();
            Emitir = new Button();
            txtError = new Label();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 20F, FontStyle.Bold);
            label1.Location = new Point(12, 9);
            label1.Name = "label1";
            label1.Size = new Size(455, 37);
            label1.TabIndex = 0;
            label1.Text = "Sistema para la emision de Titulos";
            // 
            // tbCi
            // 
            tbCi.Location = new Point(133, 65);
            tbCi.Name = "tbCi";
            tbCi.Size = new Size(320, 23);
            tbCi.TabIndex = 2;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(109, 68);
            label2.Name = "label2";
            label2.Size = new Size(18, 15);
            label2.TabIndex = 3;
            label2.Text = "CI";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(65, 97);
            label3.Name = "label3";
            label3.Size = new Size(62, 15);
            label3.TabIndex = 5;
            label3.Text = "NOMBRES";
            // 
            // tbNombres
            // 
            tbNombres.Location = new Point(133, 94);
            tbNombres.Name = "tbNombres";
            tbNombres.Size = new Size(320, 23);
            tbNombres.TabIndex = 4;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(23, 126);
            label4.Name = "label4";
            label4.Size = new Size(104, 15);
            label4.TabIndex = 7;
            label4.Text = "PRIMER APELLIDO";
            // 
            // tbPrimerApellido
            // 
            tbPrimerApellido.Location = new Point(133, 123);
            tbPrimerApellido.Name = "tbPrimerApellido";
            tbPrimerApellido.Size = new Size(320, 23);
            tbPrimerApellido.TabIndex = 6;
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(10, 155);
            label5.Name = "label5";
            label5.Size = new Size(117, 15);
            label5.TabIndex = 9;
            label5.Text = "SEGUNDO APELLIDO";
            // 
            // tbSegundoApellido
            // 
            tbSegundoApellido.Location = new Point(133, 152);
            tbSegundoApellido.Name = "tbSegundoApellido";
            tbSegundoApellido.Size = new Size(320, 23);
            tbSegundoApellido.TabIndex = 8;
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(82, 184);
            label6.Name = "label6";
            label6.Size = new Size(45, 15);
            label6.TabIndex = 11;
            label6.Text = "TITULO";
            // 
            // tbTitulo
            // 
            tbTitulo.Location = new Point(133, 181);
            tbTitulo.Name = "tbTitulo";
            tbTitulo.Size = new Size(320, 23);
            tbTitulo.TabIndex = 10;
            // 
            // Emitir
            // 
            Emitir.Location = new Point(378, 210);
            Emitir.Name = "Emitir";
            Emitir.Size = new Size(75, 40);
            Emitir.TabIndex = 12;
            Emitir.Text = "EMITIR TITULO";
            Emitir.UseVisualStyleBackColor = true;
            Emitir.Click += Emitir_Click;
            // 
            // txtError
            // 
            txtError.AutoSize = true;
            txtError.Location = new Point(134, 220);
            txtError.Name = "txtError";
            txtError.Size = new Size(0, 15);
            txtError.TabIndex = 13;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(475, 272);
            Controls.Add(txtError);
            Controls.Add(Emitir);
            Controls.Add(label6);
            Controls.Add(tbTitulo);
            Controls.Add(label5);
            Controls.Add(tbSegundoApellido);
            Controls.Add(label4);
            Controls.Add(tbPrimerApellido);
            Controls.Add(label3);
            Controls.Add(tbNombres);
            Controls.Add(label2);
            Controls.Add(tbCi);
            Controls.Add(label1);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private TextBox tbCi;
        private Label label2;
        private Label label3;
        private TextBox tbNombres;
        private Label label4;
        private TextBox tbPrimerApellido;
        private Label label5;
        private TextBox tbSegundoApellido;
        private Label label6;
        private TextBox tbTitulo;
        private Button Emitir;
        private Label txtError;
    }
}
