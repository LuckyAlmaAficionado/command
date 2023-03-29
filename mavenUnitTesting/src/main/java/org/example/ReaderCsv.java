package org.example;

import org.example.module.ModuleRead;
import org.example.solving.Mean;
import org.example.solving.Median;
import org.example.solving.Modus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class ReaderCsv implements ModuleRead {
    @Override
    public List<String> readerCsv(String path, int opsi) {

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        /*
            Deklarasi List
            berguna untuk menampung data yang diberikan oleh setiap fungsi
         */
        List<String> paketNilai = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        List<Integer> tempMod = new ArrayList<>();
        List<Integer> tempMed = new ArrayList<>();
        float value = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            String line = "";
            String[] tempArr;
            int lenghtOfNumbers = 0;


            while ((line = br.readLine()) != null) {

                temp.clear();

                tempArr = line.split(";");
                for (int i = 0; i < tempArr.length; i++) {

                    if (i >= 1) {
                        lenghtOfNumbers++;
                        value += Integer.parseInt(tempArr[i]);
                        tempMed.add(Integer.valueOf(tempArr[i]));
                        temp.add(Integer.valueOf(tempArr[i]));
                    } else paketNilai.add(tempArr[i]);
                }

                Function<List<Integer>, Integer> modus = result -> Modus.getModus(result);
                Function<List<Integer>, Float> meanLambda = data -> {
                    float result = 0;
                    for (Integer x : data) result += x;
                    return result / data.size();
                };
                Function<List<Integer>, Float> mean = Mean::getMean;
                Function<List<Integer>, Float> median = Median::getMedian;

                switch (opsi) {
                    case 1:
                        paketNilai.add("Modus   : " + modus.apply(temp) + "\n");
                        tempMod.add(Modus.getModus(temp));
                        break;
                    case 2:
                        paketNilai.add("Mean    : " + meanLambda.apply(temp));
                        paketNilai.add("Median  : " + median.apply(temp) + "\n");
                        break;
                    case 3:
                        paketNilai.add("Median  : " + median.apply(temp));
                        paketNilai.add("Mean    : " + mean.apply(temp));
                        paketNilai.add("Modus   : " + modus.apply(temp) + "\n");
                        tempMod.add(Modus.getModus(temp));
                        break;
                    default:
                        break;

                }
            }

            paketNilai.add("Berikut Hasil Pengolahan Nilai: ");
            paketNilai.add("Berikut hasil sebaran data nilai");

            if (opsi == 1) {
                paketNilai.add("Modus   : " + Modus.getModus(tempMod));
            } else if (opsi == 2) {
                paketNilai.add("Mean    : " + decimalFormat.format(value / lenghtOfNumbers));
                paketNilai.add("Median  : " + Median.getMedian(tempMed));
            } else if (opsi == 3) {
                paketNilai.add("Modus   : " + Modus.getModus(tempMod));
                paketNilai.add("Mean    : " + decimalFormat.format(value / lenghtOfNumbers));
                paketNilai.add("Median  : " + Median.getMedian(tempMed));
            }

            Collection<String> stringCollection = new ArrayList<>();

            br.close();
            return paketNilai;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
