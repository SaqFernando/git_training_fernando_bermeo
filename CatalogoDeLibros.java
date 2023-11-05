package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Te he roto el programa :) 

public class CatalogoDeLibros {
    public static void main(String[] args) {
        List<Libro> catalogo = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Cargar catálogo desde archivo (si existe)
        try {
            FileInputStream fileIn = new FileInputStream("catalogo.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            catalogo = (List<Libro>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se encontró un catálogo existente. Se creará uno nuevo.");
        }

        whil tem.out.println("1. Agregar libro");
            Systln("2. Eliminar libro por ISBN");
            System.out.println("3. Listar libros");
            System.out.println("4. Guardar catálogo");
            System.out.println("5. Salir");

            int opcion;
            try {
                opcion = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ingresa un número válido.");
                scanner.nextLine(); // Consumir la entrada inválida
                continue;
            }

            switch (opcion) {
                case 1:
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Año de Publicación: ");
                    int anoPublicacion = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    Libro libro = new Libro(titulo, autor, anoPublicacion, isbn);
                    catalogo.add(libro);
                    System.out.println("Libro agregado al catálogo.");
                    break;

                case 2:
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingresa el ISBN del libro a eliminar: ");
                    String isbnAEliminar = scanner.nextLine();
                    catalogo.removeIf(libroEnCatalogo -> libroEnCatalogo.isbn.equals(isbnAEliminar));
                    System.out.println("Libro eliminado del catálogo.");
                    break;

                case 3:
                    System.out.println("Catálogo de Libros:");
                    for (Libro libroEnCatalogo : catalogo) {
                        System.out.println(libroEnCatalogo);
                    }
                    break;
                case 4:
                    try {
                        FileOutputStream fileOut = new FileOutputStream("catalogo.txt");
                        ObjectOutputStream out = new ObjectOutputStream(fileOut);
                        out.writeObject(catalogo);
                        out.close();
                        fileOut.close();
                        System.out.println("Catálogo guardado en catalogo.txt");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
