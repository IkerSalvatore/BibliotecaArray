import java.time.LocalDate;
import java.util.ArrayList;

public class Biblioteca {

    // Atributos
    String nombre;
    ArrayList<Libro> libros; // la lista donde guardamos todos los libros

    // Constructor
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>(); // iniciamos la lista vacía
    }

    // ─────────────────────────────────────────
    // MÉTODO 1: Agregar un libro a la lista
    // ─────────────────────────────────────────
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    // ─────────────────────────────────────────
    // MÉTODO 2: Consultar un libro por su ISBN
    // ─────────────────────────────────────────
    public void consultarLibro(String isbn) {

        // Recorremos la lista libro por libro
        for (int i = 0; i < libros.size(); i++) {

            Libro l = libros.get(i); // agarramos el libro en la posición i

            if (l.getIsbn().equals(isbn)) {
                // Lo encontramos, imprimimos su info
                System.out.println("---- Libro encontrado ----");
                System.out.println("Titulo : " + l.getTitulo());
                System.out.println("Autor  : " + l.getAutor());
                System.out.println("ISBN   : " + l.getIsbn());

                if (l.isDisponible()) {
                    System.out.println("Estado : Disponible");
                } else {
                    System.out.println("Estado : Prestado");
                }
                return; // ya lo encontramos, salimos del método
            }
        }

        // Si llegamos aquí es porque no lo encontramos
        System.out.println("No se encontro un libro con ISBN: " + isbn);
    }

    // ─────────────────────────────────────────
    // MÉTODO 3: Prestar un libro
    // ─────────────────────────────────────────
    public void prestarLibro(String isbn) {

        for (int i = 0; i < libros.size(); i++) {

            Libro l = libros.get(i);

            if (l.getIsbn().equals(isbn)) {

                if (l.isDisponible() == false) {
                    System.out.println("Ese libro ya esta prestado.");
                    return;
                }

                // Marcamos el libro como no disponible
                l.setDisponible(false);
                l.setFechaPrestamo(LocalDate.now()); // guardamos la fecha de hoy
                System.out.println("Prestamo registrado: " + l.getTitulo());
                return;
            }
        }

        System.out.println("No se encontro un libro con ISBN: " + isbn);
    }

    // ─────────────────────────────────────────
    // MÉTODO 4: Devolver un libro
    // ─────────────────────────────────────────
    public void devolverLibro(String isbn, LocalDate fechaLimite) {

        for (int i = 0; i < libros.size(); i++) {

            Libro l = libros.get(i);

            if (l.getIsbn().equals(isbn)) {

                if (l.isDisponible() == true) {
                    System.out.println("Ese libro no estaba prestado.");
                    return;
                }

                // Marcamos el libro como disponible otra vez
                l.setDisponible(true);
                l.setFechaPrestamo(null);

                // Comparamos la fecha límite con hoy
                // isBefore = "es anterior a"
                if (fechaLimite.isBefore(LocalDate.now())) {
                    // La fecha límite ya pasó → hay multa
                    System.out.println("MULTA: devolviste el libro despues de la fecha limite.");
                    System.out.println("Fecha limite era : " + fechaLimite);
                    System.out.println("Hoy es           : " + LocalDate.now());
                } else {
                    System.out.println("Devolucion registrada a tiempo: " + l.getTitulo());
                }

                return;
            }
        }

        System.out.println("No se encontro un libro con ISBN: " + isbn);
    }

    // ─────────────────────────────────────────
    // MÉTODO 5: Ver todos los libros
    // ─────────────────────────────────────────
    public void verificarInventario() {

        System.out.println("==== Inventario de " + nombre + " ====");

        if (libros.size() == 0) {
            System.out.println("No hay libros en el catalogo.");
            return;
        }

        for (int i = 0; i < libros.size(); i++) {

            Libro l = libros.get(i);

            String estado;
            if (l.isDisponible()) {
                estado = "Disponible";
            } else {
                estado = "Prestado";
            }

            System.out.println(l.getIsbn() + " | " + l.getTitulo() + " - " + l.getAutor() + " | " + estado);
        }
    }
}
