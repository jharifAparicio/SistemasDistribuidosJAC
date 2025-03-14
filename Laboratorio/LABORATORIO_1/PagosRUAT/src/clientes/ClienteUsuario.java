/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientes;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Scanner;

import clases.Deuda;
import Interfaces.IBanco;

public class ClienteUsuario {

    public static void main(String[] args) {
        try {
            // Conectar con el servidor del Banco
            IBanco banco = (IBanco) Naming.lookup("banco");
            Scanner scanner = new Scanner(System.in);
            
                System.out.print("Ingrese su CI: ");
                String CI = scanner.nextLine();
                
                // Obtener deudas
                ArrayList<Deuda> deudas = banco.obtenerDeuda(CI);

                if (deudas.isEmpty()) {
                    System.out.println("No tiene deudas registradas.");
                } else {
                    System.out.println("Deudas encontradas:");
                    for (int i = 0; i < deudas.size(); i++) {
                        Deuda d = deudas.get(i);
                        System.out.println((i + 1) + ". " + d.getImpuesto() + " - " + d.getMonto() + " Bs");
                    }
                    int opcion;

                        // Preguntar si desea pagar una deuda
                        System.out.print("Ingrese el número de la deuda que desea pagar (0 para salir): ");
                        opcion = scanner.nextInt();
                        if (opcion > 0 && opcion <= deudas.size()) {
                            Deuda deudaSeleccionada = deudas.get(opcion - 1);
                            boolean pagoExitoso = banco.Pagar(deudaSeleccionada);
                            if (pagoExitoso) {
                                System.out.println("✅ Pago realizado con éxito.");
                            } else {
                                System.out.println("❌ No se pudo realizar el pago (CI observado o error).");
                            }
                        }
                }

            scanner.close();
        } catch (Exception e) {
            System.err.println("Error en ClienteUsuario: " + e.getMessage());
        }
    }
}
