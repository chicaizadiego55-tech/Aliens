package com.krakedev.aliens.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.aliens.Alien;

public class AlienTestIA {

    @Test
    public void tamanioExactamenteCinco() {

        Alien alien = new Alien(5, "Verde");

        assertEquals(5, alien.getTamanio());
    }

    @Test
    public void tamanioExactamenteTreinta() {

        Alien alien = new Alien(30, "Azul");

        assertEquals(30, alien.getTamanio());
    }

    @Test
    public void ojosSegunTamanioPequeno() {

        Alien alien = new Alien(5, "Verde");

        assertTrue(alien.agregarOjos(3));
        assertFalse(alien.agregarOjos(1));

        assertEquals(3, alien.getNumeroOjos());
    }

    @Test
    public void ojosSegunTamanioMediano() {

        Alien alien = new Alien(15, "Azul");

        assertTrue(alien.agregarOjos(5));
        assertFalse(alien.agregarOjos(1));

        assertEquals(5, alien.getNumeroOjos());
    }

    @Test
    public void ojosSegunTamanioGrande() {

        Alien alien = new Alien(25, "Rojo");

        assertTrue(alien.agregarOjos(7));
        assertFalse(alien.agregarOjos(1));

        assertEquals(7, alien.getNumeroOjos());
    }

    @Test
    public void diezExtremidadesExactas() {

        Alien alien = new Alien(20, "Verde");

        assertTrue(alien.agregarBrazos(5));
        assertTrue(alien.agregarPiernas(5));

        assertEquals(5, alien.getNumeroBrazos());
        assertEquals(5, alien.getNumeroPies());
    }

    @Test
    public void onceExtremidadesNoPermitidas() {

        Alien alien = new Alien(20, "Verde");

        assertTrue(alien.agregarBrazos(5));
        assertFalse(alien.agregarPiernas(6));

        assertEquals(5, alien.getNumeroBrazos());
        assertEquals(0, alien.getNumeroPies());
    }
    
    @Test
    public void precioTotalDespuesDeAgregarElementos() {

        Alien alien = new Alien(10, "Amarillo");

        alien.agregarBrazos(2);
        alien.agregarPiernas(2);
        alien.agregarOjos(3);

        /*
         * Cuerpo = 10 * 0.20 = 2
         * Extremidades = 4 * 1 = 4
         * Ojos = 3 * 0.5 = 1.5
         *
         * Total = 2 + 4 + 1.5 = 7.5
         */

        assertEquals(7.5, alien.getPrecioTotal());
    }


}

