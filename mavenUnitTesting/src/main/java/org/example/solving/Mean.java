package org.example.solving;

import java.util.List;

public class Mean {
    public static float getMean(List<Integer> data) {
        float result = 0;
        float solve = 0;
        for (Integer x : data) result += x;
        try {
            solve = result / data.size();
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        return solve;
    }
}
