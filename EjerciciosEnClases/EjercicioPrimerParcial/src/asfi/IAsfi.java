package asfi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author jharif
 */
public interface IAsfi extends Remote{
    public ArrayList<Cuenta> consultarCuenta(String ci, String nombre, String apellido) throws RemoteException;
    public boolean retenerMonto(Cuenta cuenta,double monto, String glosa) throws RemoteException;
}
