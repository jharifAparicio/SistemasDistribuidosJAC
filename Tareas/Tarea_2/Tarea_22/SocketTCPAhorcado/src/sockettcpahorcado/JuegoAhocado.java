/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockettcpahorcado;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author jharif
 */
public class JuegoAhocado {
    private String palabraSecreta;
    private Set<Character> letrasAdivinadas;
    private int errores;
    private static final int MAX_ERRORES = 7;
    
    public JuegoAhocado(){
        this.palabraSecreta = Palabras.obtenerPalabraAleatoria();
        this.letrasAdivinadas = new HashSet<>();
        this.errores = 0;
    }
    
    // mostramos la palabra a adivinar oculto
    public String getPalabraOculta(){
        StringBuilder palabraOculta = new StringBuilder();
        for(char letra : palabraSecreta.toCharArray()){
            if(letrasAdivinadas.contains(letra)){
                palabraOculta.append(letra);
            }else{
                palabraOculta.append("_");
            }
        }
        return palabraOculta.toString().trim();
    }
    
    // intenta adivinar una letra
    public boolean adivinarLetra(char letra){
        letra = Character.toUpperCase(letra);
        if(palabraSecreta.contains(String.valueOf(letra))){
            letrasAdivinadas.add(letra);
            return true;
        }else{
            errores++;
            return false;
        }
    }
    
    // Verifica si el jugador ha ganado
    public boolean haGanado() {
        for (char letra : palabraSecreta.toCharArray()) {
            if (!letrasAdivinadas.contains(letra)) {
                return false;
            }
        }
        return true;
    }

    // Verifica si el jugador ha perdido
    public boolean haPerdido() {
        return errores >= MAX_ERRORES;
    }

    // Devuelve la cantidad de vidas restantes
    public int getVidasRestantes() {
        return MAX_ERRORES - errores;
    }

    // Devuelve la palabra secreta (para mostrar al final del juego)
    public String getPalabraSecreta() {
        return palabraSecreta;
    }
}
