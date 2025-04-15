﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace Servicios
{
    /// <summary>
    /// Descripción breve de wsCalculadora
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class wsCalculadora : System.Web.Services.WebService
    {
        [WebMethod]
        public int Sumar(int a, int b)
        {
            return a + b;
        }

        [WebMethod]
        public int Restar(int a, int b)
        {
            return a - b;
        }

        [WebMethod]
        public int Multiplicar(int a, int b)
        {
            return a * b;
        }

        [WebMethod]
        public int Dividir(int a, int b)
        {
            return a / b;
        }
    }
}
