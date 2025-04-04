/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juez;

import asfi.Cuenta;
import java.util.ArrayList;

/**
 *
 * @author jharif
 */
public class Procesar {
    public static String procesar(String recibido, ArrayList<Cuenta> cuentas){
        String[] dividido = recibido.split(":");
        String comando = dividido[0];
        String datos = dividido[1];

        switch (comando) {
            case "Buscar":
                String[] p = datos.split("-");
                String ci = p[0];
                StringBuilder sb = new StringBuilder();

                for (Cuenta c : cuentas) {
                    if (c.getCi().equals(ci)) {
                        sb.append(c.getNrocuenta()).append("-").append(c.getSaldo()).append(":");
                    }
                }
                return sb.toString();

            case "Congelar":
                String[] p1 = datos.split("-");
                String nro = p1[0];
                for (Cuenta c : cuentas) {
                    if (c.getNrocuenta().equals(nro)) {
                        return "SI-" + nro;
                    }
                }
                return "NO-no  encontrado";
        }
        return "ERROR";
    }
}
