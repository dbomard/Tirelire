package Impl;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MenuListeTireliresTest {
    MenuListeTirelires menu;

    @Test
    void afficheTest() {
        int test;
        ArrayList<TirelireImpl> tirelires = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            tirelires.add(new TirelireImpl("Enfant numéro " + (i+1), (double) i * 36.78+50));


        System.setIn(new ByteArrayInputStream(String.format("0").getBytes()));
        menu = new MenuListeTirelires();
        test = menu.affiche(tirelires);
        assertTrue(test == 0, "Choix 0");

        System.setIn(new ByteArrayInputStream(String.format("1").getBytes()));
        menu = new MenuListeTirelires();
        test = menu.affiche(tirelires);
        assertTrue(test == 1, "Choix 1");

        System.setIn(new ByteArrayInputStream(String.format("5").getBytes()));
        menu = new MenuListeTirelires();
        test = menu.affiche(tirelires);
        assertTrue(test == 5, "Choix 5");

        System.setIn(new ByteArrayInputStream(String.format("6").getBytes()));
        menu = new MenuListeTirelires();
        test = menu.affiche(tirelires);
        assertTrue(test == 0, "Choix 6");

    }
}