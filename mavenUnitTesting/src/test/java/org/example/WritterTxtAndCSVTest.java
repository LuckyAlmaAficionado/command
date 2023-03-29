package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class WritterTxtAndCSVTest {

    public static final String save = "D:/Users/USER/Documents/CSV/testing/test.txt";
    List<String> dummy = List.of("testing", "ini", "tulisan", "keluar", "apa", "Engga");
    WritterTxtAndCSV wtc = new WritterTxtAndCSV();

    @Test
    void writterTxtAndCsv() {
        wtc.writterTxtAndCsv(save, dummy);
    }

    @Test
    void testWritterTxtAndCsvFailed() {
        assertThrows(IllegalArgumentException.class, () -> {
            wtc.writterTxtAndCsv(save, dummy);
        });
    }

}