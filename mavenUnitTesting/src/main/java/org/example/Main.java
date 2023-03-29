package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        System.out.println("pilih menu: ");
        System.out.println("1. Generate txt untuk menampilkan modus");
        System.out.println("2. Generate txt untuk menampilkan nilai rata-rata, median");
        System.out.println("3. Generate kedua file");
        System.out.println("0. exit");
    }

    public static boolean checkFileExists(String path) {

        Predicate<String> predicate = result -> {
            File file = new File(result);
            return file.exists();
        };

        return predicate.test(path);
    }

    public static void main(String[] args) {

        int opsi = 0;

        String path = "C:/Users/USER/Documents/CSV/data_sekolah.csv";

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

        /*
            Deklarasi class untuk eksekusi
         */
        ReaderCsv rc = new ReaderCsv();
        WritterTxtAndCSV wtc = new WritterTxtAndCSV();

        if (!checkFileExists(path)) throw new IllegalArgumentException("File not exists");

        do {
            String save = "C:/Users/USER/Documents/CSV/";
            menu();
            System.out.print("masukan pilihan: ");
            opsi = scanner.nextInt();
            switch (opsi) {
                case 1:
                    save += "modus_" + dtf.format(now) + ".txt";
                    wtc.writterTxtAndCsv(save, rc.readerCsv(path, 1));
                    break;
                case 2:
                    save += "mean&median_" + dtf.format(now) + ".txt";
                    wtc.writterTxtAndCsv(save, rc.readerCsv(path, 2));
                    break;
                case 3:
                    save += "modus&mean&median_" + dtf.format(now) + ".txt";
                    wtc.writterTxtAndCsv(save, rc.readerCsv(path, 3));
                    break;
                default:
                    break;
            }

            System.out.println("\nFile telah di generate di " + save);
            System.out.println("Silahkan cek\n");
            System.out.println("0. Exit");
            System.out.println("1. Kembali ke menu utama");
            opsi = scanner.nextInt();

        } while (opsi != 0);

        System.out.println("thanks for today see you");

    }
}