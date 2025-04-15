namespace ClienteCalculadora
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
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
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            label1 = new Label();
            label2 = new Label();
            txtA = new TextBox();
            txtB = new TextBox();
            btnCalcular = new Button();
            lblResultado = new Label();
            cbOperacion = new ComboBox();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(139, 60);
            label1.Name = "label1";
            label1.Size = new Size(21, 15);
            label1.TabIndex = 0;
            label1.Text = "A: ";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(353, 60);
            label2.Name = "label2";
            label2.Size = new Size(20, 15);
            label2.TabIndex = 1;
            label2.Text = "B: ";
            // 
            // txtA
            // 
            txtA.Location = new Point(166, 57);
            txtA.Name = "txtA";
            txtA.Size = new Size(100, 23);
            txtA.TabIndex = 2;
            // 
            // txtB
            // 
            txtB.Location = new Point(379, 57);
            txtB.Name = "txtB";
            txtB.Size = new Size(100, 23);
            txtB.TabIndex = 3;
            // 
            // btnCalcular
            // 
            btnCalcular.Location = new Point(271, 187);
            btnCalcular.Name = "btnCalcular";
            btnCalcular.Size = new Size(75, 23);
            btnCalcular.TabIndex = 5;
            btnCalcular.Text = "CALCULAR";
            btnCalcular.UseVisualStyleBackColor = true;
            btnCalcular.Click += btnCalcular_Click;
            // 
            // lblResultado
            // 
            lblResultado.AutoSize = true;
            lblResultado.Font = new Font("Segoe UI Black", 18F, FontStyle.Bold, GraphicsUnit.Point, 0);
            lblResultado.Location = new Point(263, 243);
            lblResultado.Name = "lblResultado";
            lblResultado.Size = new Size(157, 32);
            lblResultado.TabIndex = 6;
            lblResultado.Text = "RESULTADO";
            // 
            // cbOperacion
            // 
            cbOperacion.FormattingEnabled = true;
            cbOperacion.Items.AddRange(new object[] { "SUMAR", "RESTAR", "MULTIPLICAR", "DIVIDIR" });
            cbOperacion.Location = new Point(252, 116);
            cbOperacion.Name = "cbOperacion";
            cbOperacion.Size = new Size(121, 23);
            cbOperacion.TabIndex = 7;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(cbOperacion);
            Controls.Add(lblResultado);
            Controls.Add(btnCalcular);
            Controls.Add(txtB);
            Controls.Add(txtA);
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
        private TextBox txtA;
        private TextBox txtB;
        private Button btnCalcular;
        private Label lblResultado;
        private ComboBox cbOperacion;
    }
}