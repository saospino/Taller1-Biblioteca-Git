package com.mycompany.biblioteca;

/**
 * Clase hija de Material. Agrega autor y disponibilidad,
 * y representa un libro de la biblioteca.
 */
public class Book extends Material {

    private String author;
    private boolean available;

    public Book(String code, String title, String publicationYear, String author) {
        super(code, title, publicationYear);
        this.author = author;
        this.available = true; // todo libro nuevo entra disponible
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return super.toString() + ", autor=" + author
                + ", disponible=" + (available ? "Si" : "No");
    }
}