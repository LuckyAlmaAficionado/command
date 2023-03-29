package org.example.solving;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Median {

    public static List<Integer> sorting(List<Integer> data) {
        return data.stream().sorted().collect(Collectors.toList());
    }
     public static float getMedian(List<Integer> data) {
        List<Integer> sortData = sorting(data);
        // 3, 10, 2, 4, 5, 6, 7, 8, 2
        // 2, 2, 3, 4, 5, 6, 7, 8, 10
        if (sortData.size() % 2 != 0) return sortData.get(data.size()/2);
        return (sortData.get(sortData.size()/2) + sortData.get(sortData.size()/2-1)) / 2;
    }

}
