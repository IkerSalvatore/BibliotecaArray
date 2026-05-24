import java.time.LocalDate;

public class Libro {

    // Atributos: los datos que guarda cada libro
    String titulo;
    String autor;
    String isbn;
    boolean disponible;
    LocalDate fechaPrestamo;

    // Constructor: se ejecuta cuando haces  new Libro(...)
    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponible = true;   // cuando se crea, siempre está disponible
        this.fechaPrestamo = null; // null = no tiene fecha de préstamo todavía
    }

    // Getters: métodos para leer los atributos desde afuera
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    // Setters: métodos para cambiar los atributos desde afuera
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setFechaPrestamo(LocalDate fecha) {
        this.fechaPrestamo = fecha;
    }
}
