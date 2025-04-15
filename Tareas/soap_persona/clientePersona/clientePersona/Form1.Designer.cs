namespace clientePersona
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
            ListaPersonas = new DataGridView();
            ci = new DataGridViewTextBoxColumn();
            Nombres = new DataGridViewTextBoxColumn();
            Apellidos = new DataGridViewTextBoxColumn();
            btnBuscar = new Button();
            btnExit = new Button();
            btnEditar = new Button();
            btnEliminar = new Button();
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            txtCi = new TextBox();
            txtNombre = new TextBox();
            txtPrimerApellido = new TextBox();
            txtSegundoApellido = new TextBox();
            btnInsertar = new Button();
            lblMensaje = new Label();
            ((System.ComponentModel.ISupportInitialize)ListaPersonas).BeginInit();
            SuspendLayout();
            // 
            // ListaPersonas
            // 
            ListaPersonas.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            ListaPersonas.Columns.AddRange(new DataGridViewColumn[] { ci, Nombres, Apellidos });
            ListaPersonas.Location = new Point(426, 32);
            ListaPersonas.Name = "ListaPersonas";
            ListaPersonas.Size = new Size(362, 371);
            ListaPersonas.TabIndex = 0;
            // 
            // ci
            // 
            ci.AutoSizeMode = DataGridViewAutoSizeColumnMode.AllCells;
            ci.HeaderText = "cedula de identidad";
            ci.Name = "ci";
            ci.ReadOnly = true;
            ci.Width = 124;
            // 
            // Nombres
            // 
            Nombres.AutoSizeMode = DataGridViewAutoSizeColumnMode.AllCells;
            Nombres.HeaderText = "Nombres";
            Nombres.Name = "Nombres";
            Nombres.ReadOnly = true;
            Nombres.Width = 81;
            // 
            // Apellidos
            // 
            Apellidos.AutoSizeMode = DataGridViewAutoSizeColumnMode.AllCells;
            Apellidos.HeaderText = "Apellidos";
            Apellidos.Name = "Apellidos";
            Apellidos.ReadOnly = true;
            Apellidos.Width = 81;
            // 
            // btnBuscar
            // 
            btnBuscar.Font = new Font("Times New Roman", 11.25F, FontStyle.Bold, GraphicsUnit.Point, 0);
            btnBuscar.Location = new Point(345, 82);
            btnBuscar.Name = "btnBuscar";
            btnBuscar.Size = new Size(75, 29);
            btnBuscar.TabIndex = 3;
            btnBuscar.Text = "Buscar";
            btnBuscar.UseVisualStyleBackColor = true;
            btnBuscar.Click += btnBuscar_Click;
            // 
            // btnExit
            // 
            btnExit.Font = new Font("Times New Roman", 11.25F, FontStyle.Bold, GraphicsUnit.Point, 0);
            btnExit.Location = new Point(713, 409);
            btnExit.Name = "btnExit";
            btnExit.Size = new Size(75, 29);
            btnExit.TabIndex = 4;
            btnExit.Text = "Salir";
            btnExit.UseVisualStyleBackColor = true;
            btnExit.Click += btnExit_Click;
            // 
            // btnEditar
            // 
            btnEditar.Font = new Font("Times New Roman", 11.25F, FontStyle.Bold);
            btnEditar.Location = new Point(345, 136);
            btnEditar.Name = "btnEditar";
            btnEditar.Size = new Size(75, 29);
            btnEditar.TabIndex = 2;
            btnEditar.Text = "Editar";
            btnEditar.UseVisualStyleBackColor = true;
            btnEditar.Click += btnEditar_Click;
            // 
            // btnEliminar
            // 
            btnEliminar.Font = new Font("Times New Roman", 11.25F, FontStyle.Bold);
            btnEliminar.Location = new Point(345, 192);
            btnEliminar.Name = "btnEliminar";
            btnEliminar.Size = new Size(75, 23);
            btnEliminar.TabIndex = 16;
            btnEliminar.Text = "Eliminar";
            btnEliminar.Click += this.btnEliminar_Click;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(12, 40);
            label1.Name = "label1";
            label1.Size = new Size(111, 15);
            label1.TabIndex = 5;
            label1.Text = "cedula de identidad";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(67, 91);
            label2.Name = "label2";
            label2.Size = new Size(56, 15);
            label2.TabIndex = 6;
            label2.Text = "Nombres";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(34, 143);
            label3.Name = "label3";
            label3.Size = new Size(89, 15);
            label3.TabIndex = 7;
            label3.Text = "Primer Apellido";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(22, 192);
            label4.Name = "label4";
            label4.Size = new Size(101, 15);
            label4.TabIndex = 8;
            label4.Text = "Segundo Apellido";
            // 
            // txtCi
            // 
            txtCi.Location = new Point(129, 36);
            txtCi.Name = "txtCi";
            txtCi.Size = new Size(210, 23);
            txtCi.TabIndex = 9;
            // 
            // txtNombre
            // 
            txtNombre.Location = new Point(129, 87);
            txtNombre.Name = "txtNombre";
            txtNombre.Size = new Size(210, 23);
            txtNombre.TabIndex = 10;
            // 
            // txtPrimerApellido
            // 
            txtPrimerApellido.Location = new Point(129, 139);
            txtPrimerApellido.Name = "txtPrimerApellido";
            txtPrimerApellido.Size = new Size(210, 23);
            txtPrimerApellido.TabIndex = 11;
            // 
            // txtSegundoApellido
            // 
            txtSegundoApellido.Location = new Point(129, 188);
            txtSegundoApellido.Name = "txtSegundoApellido";
            txtSegundoApellido.Size = new Size(210, 23);
            txtSegundoApellido.TabIndex = 12;
            // 
            // btnInsertar
            // 
            btnInsertar.Font = new Font("Times New Roman", 11.25F, FontStyle.Bold);
            btnInsertar.Location = new Point(345, 36);
            btnInsertar.Name = "btnInsertar";
            btnInsertar.Size = new Size(75, 23);
            btnInsertar.TabIndex = 15;
            btnInsertar.Text = "Insertar";
            btnInsertar.Click += btnInsertar_Click;
            // 
            // lblMensaje
            // 
            lblMensaje.AutoSize = true;
            lblMensaje.Location = new Point(12, 246);
            lblMensaje.Name = "lblMensaje";
            lblMensaje.Size = new Size(0, 15);
            lblMensaje.TabIndex = 14;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(lblMensaje);
            Controls.Add(btnInsertar);
            Controls.Add(txtSegundoApellido);
            Controls.Add(txtPrimerApellido);
            Controls.Add(txtNombre);
            Controls.Add(txtCi);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(btnExit);
            Controls.Add(btnEliminar);
            Controls.Add(btnEditar);
            Controls.Add(btnBuscar);
            Controls.Add(ListaPersonas);
            Name = "Form1";
            Text = "formulario";
            Load += Form1_Load;
            ((System.ComponentModel.ISupportInitialize)ListaPersonas).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private DataGridView ListaPersonas;
        private DataGridViewTextBoxColumn ci;
        private DataGridViewTextBoxColumn Nombres;
        private DataGridViewTextBoxColumn Apellidos;
        private Button btnBuscar;
        private Button btnExit;
        private Button btnEditar;
        private Button btnEliminar;
        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private TextBox txtCi;
        private TextBox txtNombre;
        private TextBox txtPrimerApellido;
        private TextBox txtSegundoApellido;
        private Button btnInsertar;
        private Label lblMensaje;
    }
}
