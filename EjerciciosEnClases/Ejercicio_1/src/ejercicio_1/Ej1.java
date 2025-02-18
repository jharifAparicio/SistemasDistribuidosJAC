/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_1;

import java.util.Scanner;

/**
 *
 * @author jharif
 */
public class Ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op = 0;
        int n = 0;
        Scanner sc = new Scanner(System.in);
        
        while(op != 5){
            System.out.println("1. introducir un numero:");
            System.out.println("2. fibonacci:");
            System.out.println("3. factorial:");
            System.out.println("4. Sumatoria:");
            System.out.println("5. Salir");
            System.out.println("Introducir una opcion:");
            op = sc.nextInt();
            
            switch (op) {
                case 1:
                    System.out.println("Introducir un numero:");
                    n = sc.nextInt();
                    break;
                case 2:
                    System.out.println("El fibonacci es: "+ fibonacci(n));
                    break;
                case 3:
                    System.out.println("El factorial es: "+ factorial(n));
                    break;
                case 4:
                    System.out.println("La sumatoria es: "+ sumatoria(n));
                    break;
            }
        }
    }

    private static int fibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    private static int factorial(int n) {
        if(n == 0 || n == 1) return 1;
        
        int resultado = 1;
        
        for(int i=1;i < n; i++){
            resultado = resultado * i;
        }
        return resultado;
    }

    private static int sumatoria(int n) {
        int resultado = 0;
        
        for(int i = 1 ;i <= n; i++){
            resultado += i;
        }
        return resultado;
    }
    
}
