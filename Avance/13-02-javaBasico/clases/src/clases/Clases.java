/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clases;

import comunes.Color;
import java.util.ArrayList;


/**
 *
 * @author jharif
 */
public class Clases {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona juan = new Persona("juan", "perez",30, Sexo.Masculino,Color.Rojo);
        System.out.println(juan);
        
        Materia SIS258 = new Materia("SIS-258","sistemas distribuidos","Lunes 2-4, Jueves 4-6");
        Materia SIS256 = new Materia("SIS-256","desarrollo web","Lunes 2-4, Miercoles 4-6");
        
        IPublicacion cienAnios = new Libro("Cien Años de soledad", "gabriel garcia marquez", 1974, "La joya");
        IPublicacion nina = new Libro("la niña de mis ojos", "Antonio paredes",2010, "La joya");
        
        IPublicacion Correo30225 = new Periodico("Correo del sur","2025-02-13");
        IPublicacion Correo101223 = new Periodico("Correo del sur","2023-12-10");
        IPublicacion Correo101219 = new Periodico("La Razon","2025-02-13");
        
        IPublicacion[] publicacion_pedro = new IPublicacion[5];
        publicacion_pedro[0] = cienAnios;
        publicacion_pedro[1] = nina;
        publicacion_pedro[2] = Correo101219;
        publicacion_pedro[3] = Correo101223;
        publicacion_pedro[4] = Correo30225;
        
        ArrayList<Materia> materias_pedro =  new ArrayList<Materia>();
        materias_pedro.add(SIS256);
        materias_pedro.add(SIS258);
        
        Alumno pedro = new Alumno("123123", Carrera.Sistemas, publicacion_pedro, materias_pedro, "pedro", "alvares", 0, Sexo.Femenino, Color.Rojo);
        System.out.println("datos alumno");
        
    }
}
