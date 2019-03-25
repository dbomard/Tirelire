import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class TirelireTest {
    private Tirelire tirelire;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @Test
    void depot() {
        tirelire.depot(10f);
        assertEquals(20f, tirelire.getSolde());
    }

    @Test
    void retrait() {
        tirelire.retrait(10f);
        assertEquals(0f, tirelire.getSolde());
    }

    @Test
    void affiche() {
        tirelire.affiche();
        assertEquals("Dans la tirelire de David, il y a 10.0 euros\n", outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    void getSolde() {
        assertEquals(10f, tirelire.getSolde());
    }

    @Test
    void getNom() {
        assertEquals("David", tirelire.getNom());
    }

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        tirelire = new Tirelire("David");
        tirelire.depot(10f);
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
        tirelire.efface();
    }
}