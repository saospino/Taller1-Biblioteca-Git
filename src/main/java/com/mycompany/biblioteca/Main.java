package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
 static ArrayList<Cliente> clientes = new ArrayList<>();
 static ArrayList<Book> books = new ArrayList<>();
 static ArrayList<Loan> loans = new ArrayList<>();

 static Scanner sc = new Scanner(System.in);
 
 public static void main(String[] args) {
 // Aquí irá el menú (Fase 8)
 }
 
    static void createClient() {
        System.out.print("Id: ");
        String id = sc.nextLine();
        System.out.print("Nombre: ");
        String name = sc.nextLine();
        System.out.print("Telefono: ");
        String phone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        clients.add(new Client(id, name, phone, email));
        System.out.println("Cliente creado con exito.");
    }
    
    static void listClients() {
        if (clients.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        for (Client c : clients) {
            System.out.println(c);
        }
    }
    

   static Client findClientById(String id) {
        for (Client c : clients) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }
 
    static void searchClient() {
        System.out.print("Id del cliente a buscar: ");
        String id = sc.nextLine();
        Client c = findClientById(id);
        System.out.println(c != null ? c : "Cliente no encontrado.");
    }
    
    static void updateClient() {
        System.out.print("Id del cliente a actualizar: ");
        String id = sc.nextLine();
        Client c = findClientById(id);
        if (c == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        System.out.print("Nuevo nombre (" + c.getName() + "): ");
        c.setName(sc.nextLine());
        System.out.print("Nuevo telefono (" + c.getPhone() + "): ");
        c.setPhone(sc.nextLine());
        System.out.print("Nuevo email (" + c.getEmail() + "): ");
        c.setEmail(sc.nextLine());
        System.out.println("Cliente actualizado.");
    }
    
    static void deleteClient() {
        System.out.print("Id del cliente a eliminar: ");
        String id = sc.nextLine();
        Client c = findClientById(id);
        if (c == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        clients.remove(c);
        System.out.println("Cliente eliminado.");
    }
    
    static void createBook() {
        System.out.print("Codigo: ");
        String code = sc.nextLine();
        System.out.print("Titulo: ");
        String title = sc.nextLine();
        System.out.print("Anio de publicacion: ");
        String year = sc.nextLine();
        System.out.print("Autor: ");
        String author = sc.nextLine();
        books.add(new Book(code, title, year, author));
        System.out.println("Libro creado con exito.");
    }
    
    static void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }
 
    static Book findBookByCode(String code) {
        for (Book b : books) {
            if (b.getCode().equals(code)) {
                return b;
            }
        }
        return null;
    }
    


    static void searchBook() {
        System.out.print("Codigo del libro a buscar: ");
        String code = sc.nextLine();
        Book b = findBookByCode(code);
        System.out.println(b != null ? b : "Libro no encontrado.");
    }
 
    static void updateBook() {
        System.out.print("Codigo del libro a actualizar: ");
        String code = sc.nextLine();
        Book b = findBookByCode(code);
        if (b == null) {
            System.out.println("Libro no encontrado.");
            return;
        }
        System.out.print("Nuevo titulo (" + b.getTitle() + "): ");
        b.setTitle(sc.nextLine());
        System.out.print("Nuevo autor (" + b.getAuthor() + "): ");
        b.setAuthor(sc.nextLine());
        System.out.print("Nuevo anio (" + b.getPublicationYear() + "): ");
        b.setPublicationYear(sc.nextLine());
        System.out.println("Libro actualizado.");
    }
    
        System.out.print("Codigo del libro a eliminar: ");
        String code = sc.nextLine();
        Book b = findBookByCode(code);
        if (b == null) {
            System.out.println("Libro no encontrado.");
            return;
        }
        books.remove(b);
        System.out.println("Libro eliminado.");
    }
 
    static void registerLoan() {
        System.out.print("Id del cliente: ");
        String clientId = sc.nextLine();
        Client client = findClientById(clientId);
        if (client == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
 
        System.out.print("Codigo del libro: ");
        String bookCode = sc.nextLine();
        Book book = findBookByCode(bookCode);
        if (book == null) {
            System.out.println("Libro no encontrado.");
            return;
        }
        if (!book.isAvailable()) {
            System.out.println("El libro no esta disponible.");
            return;
        }
 
        System.out.print("Id del prestamo: ");
        String loanId = sc.nextLine();
 
        Loan loan = new Loan(loanId, client, book, LocalDate.now());
        book.setAvailable(false);
        loans.add(loan);
        System.out.println("Prestamo registrado con exito.");
    }
     static Loan findActiveLoan(String loanId) {
        for (Loan l : loans) {
            if (l.getLoanId().equals(loanId) && l.getStatus().equals("ACTIVO")) {
                return l;
            }
        }
        return null;
    }
 
    static void returnLoan() {
        System.out.print("Id del prestamo a devolver: ");
        String loanId = sc.nextLine();
        Loan loan = findActiveLoan(loanId);
        if (loan == null) {
            System.out.println("No existe un prestamo activo con ese id.");
            return;
        }
        loan.setStatus("DEVUELTO");
        loan.getBook().setAvailable(true);
        System.out.println("Devolucion registrada con exito.");
    }

    static void listActiveLoans() {
        boolean found = false;
        for (Loan l : loans) {
            if (l.getStatus().equals("ACTIVO")) {
                System.out.println(l);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No hay prestamos activos.");
        }
    }
}
 
 