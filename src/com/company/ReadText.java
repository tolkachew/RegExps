package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadText {
    public static void main(String[] args) {
        //Задаем имя файла
        String fileName = "src/com/company/data/data1.txt";
        StringBuilder sb = null;
        //Try with resources (новый синтаксис try, начиная с Java 7)
        try (FileReader fr = new FileReader(fileName)) {
            System.out.println("Character encoding: " + fr.getEncoding());
            sb = new StringBuilder();
            int i;
            while ((i =
                    fr.read
                            ()) != -1) {
                sb.append((char) i);
            }
            fr.close();
            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String s = sb.toString();
        s = s.replaceAll("[^-\\+\\.0-9]", "");
        double x = Double.parseDouble(s);
        System.out.println(x);
    }
}
