/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clientecalculadora;

/**
 *
 * @author jharif
 */
public class ClienteCalculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("la suma de 2 numeros es:" + sumar(10,20));
    }

    private static int sumar(int a, int b) {
        servicios.WsCalculadora service = new servicios.WsCalculadora();
        servicios.WsCalculadoraSoap port = service.getWsCalculadoraSoap();
        return port.sumar(a, b);
    }
}
