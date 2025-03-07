/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacionesudp;

/**
 *
 * @author jharif
 */
public class Operaciones {

    private int n;
    
    public int getN() {
        return n;
    }

    public void setN(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El numero es negativo");
        }
        this.n = n;
    }

    public boolean setNFromInput(String input) {
        try {
            int numero = Integer.parseInt(input);
            if (numero >= 0) {
                this.n = numero;
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public long calcularFactorial() {
        if (this.n == 0 || this.n == 1) {
            return 1;
        }
        long factorial = 1;
        for (int i = 2; i <= this.n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public String calcularFibonacci() {
        if (this.n == 0) {
            return "0";
        }

        String a = "0";
        String b = "1";

        String Fibonacci = "";
        Fibonacci += a;
        Fibonacci += ", " + b;
        for (int i = 2; i < this.n; i++) {
            int c = Integer.parseInt(a) + Integer.parseInt(b);
            Fibonacci+= ", " + Integer.toString(c);
            a = b;
            b = Integer.toString(c);
        }
        return Fibonacci;
    }
    
    public long calcularSumatoria(){
        long Sumatoria = 0;
        for(int i = 0; i <= this.n; i++){
            Sumatoria += i;
        }
        return Sumatoria;
    }
}
