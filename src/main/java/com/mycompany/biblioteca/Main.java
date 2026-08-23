package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
 static ArrayList<Cliente> clientes = new ArrayList<>();
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
    