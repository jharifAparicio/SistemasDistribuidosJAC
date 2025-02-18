/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea_1;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author jharif
 */
public class Tarea_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBConnection DBconection = new DBConnection();
        Connection connection = DBconection.getConnection();

        // instancias de el CRUD
        CreatePerson create = new CreatePerson();
        ReadPerson read = new ReadPerson();
        EditPerson Update = new EditPerson();
        DeletePerson Delete = new DeletePerson();

        try (Scanner scanner = new Scanner(System.in)) {
            int opcion;

            // Menú interactivo
            do {
                System.out.println("\n--- Menú ---");
                System.out.println("1. Añadir persona");
                System.out.println("2. Leer personas");
                System.out.println("3. Editar persona");
                System.out.println("4. Eliminar persona");
                System.out.println("5. Salir");
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea después de nextInt()

                switch (opcion) {
                    case 1:
                        // Añadir persona
                        System.out.print("Introduce el nombre de la persona: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Introduce la edad de la persona: ");
                        int edad = Integer.parseInt(scanner.nextLine());
                        System.out.print("Introduce el correo de la persona: ");
                        String correo = scanner.nextLine();
                        Person nuevaPersona = new Person(0, nombre, edad, correo);
                        create.CreatePerson(connection, nuevaPersona);
                        break;

                    case 2:
                        // Leer personas
                        System.out.println("Personas en la base de datos:");
                        read.ReadPerson(connection);
                        break;

                    case 3:
                        // Editar persona
                        System.out.print("Introduce el ID de la persona que deseas editar: ");
                        int idEditar = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea
                        System.out.print("Introduce el nuevo nombre: ");
                        String nuevoNombre = scanner.nextLine();
                        System.out.print("Introduce la nueva edad: ");
                        int nuevaEdad = Integer.parseInt(scanner.nextLine());
                        System.out.print("Introduce el nuevo correo: ");
                        String nuevoCorreo = scanner.nextLine();
                        Person personaEditada = new Person(idEditar, nuevoNombre, nuevaEdad, nuevoCorreo);
                        Update.UpdatePerson(connection, personaEditada);
                        break;

                    case 4:
                        // Eliminar persona
                        System.out.print("Introduce el ID de la persona que deseas eliminar: ");
                        int idEliminar = scanner.nextInt();
                        Delete.DeletePerson(connection, idEliminar);
                        break;

                    case 5:
                        // Salir
                        System.out.println("Saliendo...");
                        try {
                            // Hacer una pausa de 2 segundos
                            Thread.sleep(2000); // 2000 milisegundos = 2 segundos
                        } catch (InterruptedException e) {
                            System.err.println("El hilo fue interrumpido.");
                        }
                        break;
                                

                    default:
                        System.out.println("Opción no válida. Por favor, elige una opción correcta.");
                        break;
                }
            } while (opcion != 5);  // El bucle se repetirá hasta que el usuario elija salir (opción 5)

            // Cerrar la conexión
            DBconection.CerrarConexion();
            scanner.close();
        }
    }

}
