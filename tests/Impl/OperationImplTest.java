package Impl;

import Utils.OperationType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OperationImplTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    OperationImpl op;
    SimpleDateFormat formatDate;
    String date;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        formatDate = new SimpleDateFormat("dd/MM/yyyy");
        date = formatDate.format(new Date());
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void getDescriptionVersementTest() {
        op = new OperationImpl(25.0, "Test note", OperationType.VERSEMENT);
        assertEquals("Versement de 25.0 euros le " + date + ". Note : Test note", op.getDescription());
    }

    @Test
    void getDescriptionRetraitTest() {
        op = new OperationImpl(10.0, "Test note", OperationType.RETRAIT);
        assertEquals("Retrait de 10.0 euros le " + date + ". Note : Test note", op.getDescription());
    }

    @Test
    void getDescriptionOperationMontantNulTest() {
        op = new OperationImpl(0.0, "Test note", OperationType.RETRAIT);
        assertEquals("Retrait de 0.0 euro le " + date + ". Note : Test note", op.getDescription());
    }
}