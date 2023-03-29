package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ReaderCsvTest {

    public static final String path = "C:/Users/USER/Documents/CSV/data_sekolah.csv";

    public static List<String> parameterSource() {
        return List.of("C:/Users/USER/Documents/CSV/data_sekolah.csv", "D:/Users/USER/Documents/CSV/data_sekolah.csv", "C:/Users/USER/Documents/CSVdata_sekolah.csv");
    }

    @Test
    void readerCsv() {
        ReaderCsv readerCsv = new ReaderCsv();
        List<String> result = readerCsv.readerCsv(path, 1);

        try {

            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = "";
            String[] tempArr;
            int lenghtOfNum = 0;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}