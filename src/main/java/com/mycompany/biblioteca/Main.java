package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
 static ArrayList<Cliente> clientes = new ArrayList<>();
 static ArrayList<Book> books = new ArrayList<>();
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
    


 