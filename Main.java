import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Creamos la biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca UTEZ");

        // Le agregamos algunos libros de ejemplo
        biblioteca.agregarLibro(new Libro("El Aleph",               "Jorge Luis Borges",        "ISBN-001"));
        biblioteca.agregarLibro(new Libro("Cien anos de soledad",   "Gabriel Garcia Marquez",   "ISBN-002"));
        biblioteca.agregarLibro(new Libro("Pedro Paramo",           "Juan Rulfo",               "ISBN-003"));

        int opcion = -1;

        // El while hace que el menú se repita hasta que el usuario escriba 0
        while (opcion != 0) {

            System.out.println("");
            System.out.println("====================================");
            System.out.println("    SISTEMA DE BIBLIOTECA UTEZ");
            System.out.println("====================================");
            System.out.println("1. Consultar libro");
            System.out.println("2. Prestar libro");
            System.out.println("3. Devolver libro");
            System.out.println("4. Verificar inventario");
            System.out.println("0. Salir");
            System.out.println("====================================");
            System.out.print("Elige una opcion: ");

            opcion = Integer.parseInt(scanner.nextLine());

            if (opcion == 1) {

                System.out.print("Escribe el ISBN del libro: ");
                String isbn = scanner.nextLine();
                biblioteca.consultarLibro(isbn);

            } else if (opcion == 2) {

                System.out.print("Escribe el ISBN del libro a prestar: ");
                String isbn = scanner.nextLine();
                biblioteca.prestarLibro(isbn);

            } else if (opcion == 3) {

                System.out.print("Escribe el ISBN del libro a devolver: ");
                String isbn = scanner.nextLine();

                System.out.print("Escribe la fecha limite (formato: 2025-05-20): ");
                String fechaTexto = scanner.nextLine();

                // Convertimos el texto que escribió el usuario a una fecha real
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate fechaLimite = LocalDate.parse(fechaTexto, formato);

                biblioteca.devolverLibro(isbn, fechaLimite);

            } else if (opcion == 4) {

                biblioteca.verificarInventario();

            } else if (opcion == 0) {

                System.out.println("Hasta luego.");

            } else {

                System.out.println("Opcion no valida, intenta de nuevo.");

            }
        }

        scanner.close();
    }
}
