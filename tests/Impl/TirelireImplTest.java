package Impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TirelireImplTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private TirelireImpl trl;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void construtorVideTest() {
        trl = new TirelireImpl();
        assertEquals("Dans la tirelire de Inconnu, il y a 0.0 euro", trl.description());
    }

    @Test
    void contrutorNomTest() {
        trl = new TirelireImpl("Toto");
        assertEquals("Dans la tirelire de Toto, il y a 0.0 euro", trl.description());
    }

    @Test
    void constructorNomAndValueTest() {
        trl = new TirelireImpl("Tata", 10);
        assertEquals("Dans la tirelire de Tata, il y a 10.0 euros", trl.description());
    }


    @Test
    void retirerSiMontantNegatifTest() {
        trl = new TirelireImpl("Toto", 5);
        trl.retirer(-10.0, "");
        assertEquals("Un retrait d'argent ne peut pas être négatif\n", outContent.toString().replace("\r\n", "\n"));
        assertEquals(5, trl.getSolde());
    }

    @Test
    void retirerSiMontantPositifTest() {
        trl = new TirelireImpl("Toto", 10.0);
        trl.retirer(3.0, "");
        assertEquals(7, trl.getSolde());
    }

    @Test
    void retirerSiMontantSuperieurASoldeTest() {
        trl = new TirelireImpl("Toto", 10);
        trl.retirer(11.0, "");
        assertEquals("Il n'y a pas assez d'argent dans la tirelire\n", outContent.toString().replace("\r\n", "\n"));
        assertEquals(10, trl.getSolde());
    }

    @Test
    void crediterMontantNegatifTest() {
        trl = new TirelireImpl();
        trl.crediter(-10, "");
        assertEquals("Impossible de verser un montant négatif\n", outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    void crediterMontantPositifTest() {
        trl = new TirelireImpl();
        trl.crediter(15, "");
        assertEquals(15, trl.getSolde());
    }

    @Test
    void descriptionSiSoldePositif() {
        trl = new TirelireImpl("Baba", 45.0);
        assertEquals("Dans la tirelire de Baba, il y a 45.0 euros", trl.description());
    }

    @Test
    void descriptionSiSoldeNullTest() {
        trl = new TirelireImpl("Bibi", 0.0);
        assertEquals("Dans la tirelire de Bibi, il y a 0.0 euro", trl.description());
    }

    @Test
    void getOperationsListTest() {
        trl = new TirelireImpl("MaTirelire", 50.0);
        trl.crediter(12.0, "Paie du mois");
        trl.retirer(2.0, "Glace au chocolat");
        trl.getOperationsList();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        String date = formatDate.format(new Date());
        String list = "1 - Versement de 12.0 euros le " + date + ". Note : Paie du mois\n2 - Retrait de 2.0 euros le " + date + ". Note : Glace au chocolat\n";
        assertEquals(list, outContent.toString().replace("\r\n", "\n"));
    }
}