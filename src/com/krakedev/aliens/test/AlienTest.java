package com.krakedev.aliens.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.aliens.Alien;

public class AlienTest {

    @Test
    public void testConstructor() {

        Alien alien = new Alien(15, "Verde");

        assertEquals(15, alien.getTamanio());
        assertEquals("Verde", alien.getColor());

        assertEquals(0, alien.getNumeroOjos());
        assertEquals(0, alien.getNumeroBrazos());
        assertEquals(0, alien.getNumeroPies());
    }


    @Test
    public void testTamanioMinimo() {

        Alien alien = new Alien(2, "Azul");

        assertEquals(5, alien.getTamanio());
    }

    @Test
    public void testTamanioMaximo() {

        Alien alien = new Alien(50, "Rojo");

        assertEquals(30, alien.getTamanio());
    }

    @Test
    public void testPrecioCuerpo() {

        Alien alien = new Alien(20, "Verde");

        assertEquals(4.0, alien.getPrecioCuerpo());
    }

    @Test
    public void testPrecioExtremidad() {

        Alien alien = new Alien(20, "Verde");

        assertEquals(2.0, alien.getPrecioExtremidad());
    }

    @Test
    public void testPrecioOjo() {

        Alien alien = new Alien(20, "Verde");

        assertEquals(1.0, alien.getPrecioOjo());
    }

    @Test
    public void testAgregarBrazos() {

        Alien alien = new Alien(20, "Verde");

        assertTrue(alien.agregarBrazos(4));

        assertEquals(4, alien.getNumeroBrazos());
    }

    @Test
    public void testLimiteExtremidades() {

        Alien alien = new Alien(20, "Verde");

        assertTrue(alien.agregarBrazos(6));

        assertFalse(alien.agregarPiernas(5));

        assertEquals(6, alien.getNumeroBrazos());
        assertEquals(0, alien.getNumeroPies());
    }

    @Test
    public void testExtremidadesCombinadas() {

        Alien alien = new Alien(20, "Verde");

        assertTrue(alien.agregarBrazos(4));
        assertTrue(alien.agregarPiernas(6));

        assertEquals(4, alien.getNumeroBrazos());
        assertEquals(6, alien.getNumeroPies());

        assertFalse(alien.agregarBrazos(1));
    }

    @Test
    public void testAgregarOjos() {

        Alien alien = new Alien(10, "Verde");

        assertTrue(alien.agregarOjos(3));

        assertEquals(3, alien.getNumeroOjos());
    }

    @Test
    public void testLimiteOjos() {

        Alien alien = new Alien(10, "Verde");

        assertTrue(alien.agregarOjos(3));

        assertFalse(alien.agregarOjos(1));

        assertEquals(3, alien.getNumeroOjos());
    }

    @Test
    public void testLimiteOjosTamanioMedio() {

        Alien alien = new Alien(20, "Azul");

        assertTrue(alien.agregarOjos(5));

        assertFalse(alien.agregarOjos(1));

        assertEquals(5, alien.getNumeroOjos());
    }

    @Test
    public void testLimiteOjosTamanioGrande() {

        Alien alien = new Alien(30, "Rojo");

        assertTrue(alien.agregarOjos(7));

        assertFalse(alien.agregarOjos(1));

        assertEquals(7, alien.getNumeroOjos());
    }

    @Test
    public void testPrecioTotal() {

        Alien alien = new Alien(20, "Verde");

        alien.agregarBrazos(2);
        alien.agregarPiernas(2);
        alien.agregarOjos(3);

        /*
         * Precio cuerpo = 20 * 0.20 = 4
         * Extremidades = 4 * 2 = 8
         * Ojos = 3 * 1 = 3
         *
         * Total = 4 + 8 + 3 = 15
         */

        assertEquals(15.0, alien.getPrecioTotal());
    }

    @Test
    public void testNoAgregaSiExcedeExtremidades() {

        Alien alien = new Alien(20, "Verde");

        assertTrue(alien.agregarBrazos(8));

        assertFalse(alien.agregarPiernas(3));

        assertEquals(8, alien.getNumeroBrazos());
        assertEquals(0, alien.getNumeroPies());
    }

    @Test
    public void testNoAgregaSiCantidadNegativa() {

        Alien alien = new Alien(20, "Verde");

        assertFalse(alien.agregarBrazos(-1));
        assertFalse(alien.agregarPiernas(-2));
        assertFalse(alien.agregarOjos(-1));

        assertEquals(0, alien.getNumeroBrazos());
        assertEquals(0, alien.getNumeroPies());
        assertEquals(0, alien.getNumeroOjos());
    }
}

