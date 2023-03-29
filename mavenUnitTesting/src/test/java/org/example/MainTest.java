package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    public static List<String> paramSource() {
        return  List.of("C:/Users/USER/Documents/CSV/data_sekolah.csv", "D:/Users/USER/Documents/CSV/data_sekolah.csv", "C:/Users/USER/Documents/CSVdata_sekolah.csv");
    }

    @Test
    @DisplayName("test check file exists or not")
    @ParameterizedTest(name = "{displayName} save in {0}")
    @MethodSource(value = {"paramSource"})
    void checkFileExists(String value) {
        Assertions.assertTrue(Main.checkFileExists(value));
    }
}