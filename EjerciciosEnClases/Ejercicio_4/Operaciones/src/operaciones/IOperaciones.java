/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package operaciones;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author jharif
 */
public interface IOperaciones extends Remote {
    public void SetN(int n) throws RemoteException;
    public long Factorial() throws RemoteException; // 123235365456456
    public String Fibonacci() throws RemoteException; // 1,1,2,3,5,.......,etc
    public long Sumatoria() throws RemoteException; // 2553654567578678435
}
