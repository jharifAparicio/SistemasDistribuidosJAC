package juez;

import asfi.Banco;
import asfi.IAsfi;
import asfi.Cuenta;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jharif
 */
public class Juez {
    public static void main(String[] args) {
        try {
            IAsfi asfi = (IAsfi) Naming.lookup("rmi://localhost/Asfi");
            Scanner sc = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\n--- MENÚ JUEZ ---");
                System.out.println("1. Buscar cuentas");
                System.out.println("2. Congelar cuenta");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("CI: ");
                        String ci = sc.nextLine();
                        System.out.print("Nombres: ");
                        String nombres = sc.nextLine();
                        System.out.print("Apellidos: ");
                        String apellidos = sc.nextLine();

                        ArrayList<Cuenta> cuentas = asfi.consultarCuenta(ci, nombres, apellidos);

                        if (cuentas.isEmpty()) {
                            System.out.println("No se encontraron cuentas.");
                        } else {
                            System.out.println("Cuentas encontradas:");
                            for (Cuenta c : cuentas) {
                                System.out.println("- " + c.getBanco() + " | " + c.getNrocuenta()+ " | " + c.getSaldo());
                            }
                        }
                        break;

                    case 2:
                        System.out.print("CI: ");
                        String ci2 = sc.nextLine();
                        System.out.print("Nombres: ");
                        String nombres2 = sc.nextLine();
                        System.out.print("Apellidos: ");
                        String apellidos2 = sc.nextLine();

                        ArrayList<Cuenta> cuentas2 = asfi.consultarCuenta(ci2, nombres2, apellidos2);

                        if (cuentas2.isEmpty()) {
                            System.out.println("No se encontraron cuentas.");
                        } else {
                            System.out.println("Cuentas encontradas:");
                            for (int i = 0; i < cuentas2.size(); i++) {
                                Cuenta c = cuentas2.get(i);
                                System.out.printf("%d. %s | %s | %.2f\n", i + 1, c.getBanco(), c.getNrocuenta(), c.getSaldo());
                            }

                            System.out.print("Seleccione el número de cuenta a congelar: ");
                            int seleccion = Integer.parseInt(sc.nextLine()) - 1;

                            if (seleccion >= 0 && seleccion < cuentas2.size()) {
                                Cuenta seleccionada = cuentas2.get(seleccion);
                                
                                boolean exito = asfi.retenerMonto(seleccionada,0.0 ,"glosa");
                                System.out.println(exito ? "Cuenta congelada correctamente." : "No se pudo congelar la cuenta.");
                            } else {
                                System.out.println("Selección inválida.");
                            }
                        }
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                        break;
                }

            } while (opcion != 0);

            sc.close();

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Juez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
