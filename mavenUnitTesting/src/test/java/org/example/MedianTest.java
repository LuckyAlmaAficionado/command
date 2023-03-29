package org.example;

import org.example.solving.Mean;
import org.example.solving.Median;
import org.example.solving.Modus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

class MedianTest {

    List<Integer> dummy = List.of(7, 7, 7, 7, 7, 7, 7, 7, 9);
    List<Integer> sorting = Median.sorting(dummy);
    Median median = new Median();


    @DisplayName("testing data median")
    @Test
    void testGetMedian() {
        float expect;

        if (sorting.size() % 2 == 0) expect = (sorting.get(sorting.size() / 2) + sorting.get(sorting.size() / 2 - 1) % 2);
        expect = sorting.get(sorting.size() / 2);

        float result = median.getMedian(dummy);
        Assertions.assertEquals(expect, result);
    }

    @Test
    void testGetMean() {
        var result = Mean.getMean(dummy);
        Function<List<Integer>, Float> function = Mean::getMean;
        Assertions.assertEquals(function.apply(dummy), result);
    }

    @Test
    void testGetModus() {
        var result = Modus.getModus(dummy);
        Function<List<Integer>, Integer> solve = data -> {
            HashMap<Integer, Integer> tempData = new HashMap<>();

            for (int i = 0; i < data.size(); i++) {
                int temp = data.get(i), value = 0;

                for (int j = 0; j < data.size(); j++) {
                    if (temp == data.get(j)) {
                        value++;
                    }
                }
                tempData.put(temp, value);
            }

            int terbesar = 0;
            for (int x : tempData.keySet()) if (terbesar <= tempData.get(x)) terbesar = x;

            return terbesar;
        };
        var expect = solve.apply(dummy);
        Assertions.assertEquals(expect, result);
    }
}