package Impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MenuAccueilImplTest {
    MenuAccueilImpl menu;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void afficheTest() {
        int test;
        System.setIn(new ByteArrayInputStream(String.format("1").getBytes()));
        menu = new MenuAccueilImpl();
        test=menu.affiche();
        assertTrue(test==1,"Choix 1");

        System.setIn(new ByteArrayInputStream(String.format("0").getBytes()));
        menu = new MenuAccueilImpl();
        test=menu.affiche();
        assertTrue(test==0,"Choix 0");

        System.setIn(new ByteArrayInputStream(String.format("3").getBytes()));
        menu = new MenuAccueilImpl();
        test=menu.affiche();
        assertTrue(test==0,"Choix 3");

    }
}