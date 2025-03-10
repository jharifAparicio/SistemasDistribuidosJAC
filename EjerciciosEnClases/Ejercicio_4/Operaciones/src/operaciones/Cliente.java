/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jharif
 */
public class Cliente {

    public static void main(String[] args) {
        IOperaciones operaciones;

        try {
            operaciones = (IOperaciones) Naming.lookup("rmi://localhost/Operaciones");
            Scanner sc = new Scanner(System.in);
            int valor = 0;
            int op = 0;
            while (op != 5) {
                System.out.println("Seleccione la operación: ");
                System.out.println("1: Nuevo valor de N");
                System.out.println("2: Factorial");
                System.out.println("3: Fibonacci");
                System.out.println("4: Sumatoria");
                System.out.println("5: Salir");
                op = sc.nextInt();

                switch (op) {
                    case 1:
                        System.out.print("Introduzca un valor para N: ");
                        valor = sc.nextInt();
                        operaciones.SetN(valor);
                        break;
                    case 2:
                        System.out.println("El factorial es: " + operaciones.Factorial());
                        break;
                    case 3:
                        System.out.println("El Fibonacci es: " + operaciones.Fibonacci());
                        break;
                    case 4:
                        System.out.println("El Sumatoria es: " + operaciones.Sumatoria());
                        break;
                }
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
