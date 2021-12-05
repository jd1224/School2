using System;
using System.Windows.Forms;
using System.Drawing;

namespace First
{
    public class MyForm : Form
    {
        public MyForm()
        {
            InitComponents();
        }

        private void InitComponents()
        {
            Text = "Simple Login Window";
            ClientSize = new Size(800, 450);
            CenterToScreen();
        }

        [STAThread]
        static void Main()
        {
            Application.SetHighDpiMode(HighDpiMode.SystemAware);
            Application.EnableVisualStyles();
            Application.Run(new MyForm());
        }
    }
}