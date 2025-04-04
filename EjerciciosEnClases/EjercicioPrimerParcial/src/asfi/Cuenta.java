package asfi;

import java.io.Serializable;

/**
 *
 * @author jharif
 */
public class Cuenta implements Serializable{
    private Banco banco;
    private String nroCuenta;
    private String ci;
    private String nombre;
    private String apellido;
    private Double saldo;

    public Cuenta(Banco banco, String nroCuenta, String ci, String nombre, String apellido, Double saldo) {
        this.banco = banco;
        this.nroCuenta = nroCuenta;
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.saldo = saldo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public String getNrocuenta() {
        return nroCuenta;
    }

    public void setNrocuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "banco=" + banco + ", nrocuenta=" + nroCuenta + ", ci=" + ci + ", nombre=" + nombre + ", apellido=" + apellido + ", saldo=" + saldo + '}';
    }
}
