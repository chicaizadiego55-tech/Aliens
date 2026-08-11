
package com.krakedev.aliens;

public class Alien {

    private int tamanio;
    private String color;
    private int numeroOjos;
    private int numeroBrazos;
    private int numeroPies;

    private double precioExtremidad;
    private double precioOjo;
    private double precioCuerpo;
    private double precioTotal;

    // Constructor
    public Alien(int tamanio, String color) {

        // Validar tamaño
        if (tamanio < 5) {
            this.tamanio = 5;
        } else if (tamanio > 30) {
            this.tamanio = 30;
        } else {
            this.tamanio = tamanio;
        }

        this.color = color;

        // Valores iniciales
        this.numeroOjos = 0;
        this.numeroBrazos = 0;
        this.numeroPies = 0;
        this.precioTotal = 0;

        // Cálculo de precios
        this.precioCuerpo = this.tamanio * 0.20;
        this.precioExtremidad = this.tamanio * 0.10;
        this.precioOjo = this.tamanio * 0.05;
    }

    // Getters

    public int getTamanio() {
        return tamanio;
    }

    public String getColor() {
        return color;
    }

    public int getNumeroOjos() {
        return numeroOjos;
    }

    public int getNumeroBrazos() {
        return numeroBrazos;
    }

    public int getNumeroPies() {
        return numeroPies;
    }

    public double getPrecioExtremidad() {
        return precioExtremidad;
    }

    public double getPrecioOjo() {
        return precioOjo;
    }

    public double getPrecioCuerpo() {
        return precioCuerpo;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    // Método para agregar brazos
    public boolean agregarBrazos(int cantidad) {

        int totalExtremidades = numeroBrazos + numeroPies;

        if (cantidad < 0) {
            return false;
        }

        if (totalExtremidades + cantidad > 10) {
            return false;
        }

        numeroBrazos += cantidad;

        calcularPrecioTotal();

        return true;
    }

    // Método para agregar piernas
    public boolean agregarPiernas(int cantidad) {

        int totalExtremidades = numeroBrazos + numeroPies;

        if (cantidad < 0) {
            return false;
        }

        if (totalExtremidades + cantidad > 10) {
            return false;
        }

        numeroPies += cantidad;

        calcularPrecioTotal();

        return true;
    }

    // Método para agregar ojos
    public boolean agregarOjos(int cantidad) {

        if (cantidad < 0) {
            return false;
        }

        int maximoOjos;

        if (tamanio <= 10) {
            maximoOjos = 3;
        } else if (tamanio <= 20) {
            maximoOjos = 5;
        } else {
            maximoOjos = 7;
        }

        if (numeroOjos + cantidad > maximoOjos) {
            return false;
        }

        numeroOjos += cantidad;

        calcularPrecioTotal();

        return true;
    }

    // Calcular precio total
    public void calcularPrecioTotal() {

        int totalExtremidades = numeroBrazos + numeroPies;

        precioTotal = precioCuerpo
                + (totalExtremidades * precioExtremidad)
                + (numeroOjos * precioOjo);
    }

    // Mostrar información
    public void imprimir() {

        System.out.println("===== ALIEN =====");
        System.out.println("Tamaño: " + tamanio + " cm");
        System.out.println("Color: " + color);
        System.out.println("Número de ojos: " + numeroOjos);
        System.out.println("Número de brazos: " + numeroBrazos);
        System.out.println("Número de piernas: " + numeroPies);
        System.out.println("Precio del cuerpo: $" + precioCuerpo);
        System.out.println("Precio por extremidad: $" + precioExtremidad);
        System.out.println("Precio por ojo: $" + precioOjo);
        System.out.println("Precio total: $" + precioTotal);
        System.out.println("================");
    }
}
