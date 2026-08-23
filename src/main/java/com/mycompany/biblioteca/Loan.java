package com.mycompany.biblioteca;

import java.time.LocalDate;

/**
 * Relaciona un Client con un Book. Incluye la informacion
 * propia del prestamo: fecha y estado (ACTIVO / DEVUELTO).
 */
public class Loan {

    private String loanId;
    private Client client;
    private Book book;
    private LocalDate date;
    private String status; // "ACTIVO" o "DEVUELTO"

    public Loan(String loanId, Client client, Book book, LocalDate date) {
        this.loanId = loanId;
        this.client = client;
        this.book = book;
        this.date = date;
        this.status = "ACTIVO";
    }

    public String getLoanId() {
        return loanId;
    }

    public Client getClient() {
        return client;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "prestamo=" + loanId
                + ", cliente=" + client.getName()
                + ", libro=" + book.getTitle()
                + ", fecha=" + date
                + ", estado=" + status;
    }
}
