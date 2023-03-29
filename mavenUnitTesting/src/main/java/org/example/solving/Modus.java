package org.example.solving;

import java.util.HashMap;
import java.util.List;

public class Modus {
    public static int getModus(List<Integer> data) {
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
    }
}
