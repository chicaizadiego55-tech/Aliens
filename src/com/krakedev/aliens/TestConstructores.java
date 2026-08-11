package com.krakedev.aliens;

public class TestConstructores {

    public static void main(String[] args) {

        // Alien con tamaño válido
        Alien alien1 = new Alien(15, "Verde");

        // Alien con tamaño menor al mínimo
        Alien alien2 = new Alien(3, "Azul");

        // Alien con tamaño mayor al máximo
        Alien alien3 = new Alien(40, "Rojo");

        System.out.println("ALIEN 1");
        alien1.imprimir();

        System.out.println();

        System.out.println("ALIEN 2");
        alien2.imprimir();

        System.out.println();

        System.out.println("ALIEN 3");
        alien3.imprimir();
    }
}

