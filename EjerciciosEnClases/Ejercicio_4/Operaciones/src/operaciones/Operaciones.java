/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author jharif
 */
public class Operaciones extends UnicastRemoteObject implements IOperaciones {
    public int n;
    
    public Operaciones () throws RemoteException {
        super();
        this.n = 0;
    }

    @Override
    public void SetN(int n) throws RemoteException {
        this.n = n;
    }

    @Override
    public long Factorial() throws RemoteException {
        if (this.n == 0 || this.n == 1) {
            return 1;
        }
        long factorial = 1;
        for (int i = 2; i <= this.n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    @Override
    public String Fibonacci() throws RemoteException {
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
            Fibonacci += ", " + Integer.toString(c);
            a = b;
            b = Integer.toString(c);
        }
        return Fibonacci;
    }

    @Override
    public long Sumatoria() throws RemoteException {
        long Sumatoria = 0;
        for (int i = 0; i <= this.n; i++) {
            Sumatoria += i;
        }
        return Sumatoria;
    }
}
