package main;

import java.io.Serializable;

class Libro implements Serializable {
    private String titulo;
    private String autor;
    private int anoPublicacion;
    public String isbn;

    public Libro(String titulo, String autor, int anoPublicacion, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacion = anoPublicacion;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + "\nAutor: " + autor + "\nAño de Publicación: " + anoPublicacion + "\nISBN: " + isbn + "\n";
    }
}
