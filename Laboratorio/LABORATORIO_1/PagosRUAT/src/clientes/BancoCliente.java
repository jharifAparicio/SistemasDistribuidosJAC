/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientes;

import Interfaces.IBanco;
import clases.Deuda;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jharif
 */
public class BancoCliente {
    public static void main(String[] arg){
        try {
            // conectamos al servidor del banco
            IBanco banco = (IBanco) Naming.lookup("banco");
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("Ingresar su CI: ");
            String CI = scanner.nextLine();
            
            // obtener las deudas del usuario
            ArrayList<Deuda> deudas = banco.obtenerDeuda(CI);
            
            if(deudas.isEmpty()) {
                System.out.println("No tiene deudas registradas");
            }else{
                System.out.println("Deudas encontradas: ");
                for(int i = 0; i < deudas.size(); i++){
                    Deuda deuda = deudas.get(i);
                    System.out.println((i + 1) + ". " + deuda.getImpuesto() + " - " + deuda.getMonto() + " Bs");
                }
                // Preguntar si desea pagar
                System.out.print("Ingrese el número de la deuda que desea pagar (0 para salir): ");
                int opcion = scanner.nextInt();
                if (opcion > 0 && opcion <= deudas.size()) {
                    Deuda deudaSeleccionada = deudas.get(opcion - 1);
                    boolean pagoExitoso = banco.Pagar(deudaSeleccionada);
                    if (pagoExitoso) {
                        System.out.println("✅Pago realizado con éxito.");
                    } else {
                        System.out.println("No se pudo realizar el pago (CI observado).");
                    }
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.err.println("Error en ClienteBanco: " + e.getMessage());
        }
    }
    
}
