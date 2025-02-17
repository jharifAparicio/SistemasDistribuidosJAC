/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holamundo;

import java.util.Scanner;

/**
 *
 * @author jharif
 */
public class HolaMundo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("hola mundo");
        Scanner sc = new Scanner(System.in);
        
        System.out.print("introducir el primer numero: ");
        int numero = sc.nextInt();
        System.out.print("introducir el segundo numero: ");
        int numero2 = sc.nextInt();
        int c = numero + numero2;
        
        System.out.println("El resultado es: " + c);
    }
    
}
