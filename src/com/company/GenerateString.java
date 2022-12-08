package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class GenerateString {

    public static void main(String[] args) {
        // ArrayList of LinkedList
        ArrayList<LinkedList<String>> bigBox = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            LinkedList<String> smallBox = new LinkedList<>();
            for (int j = 0; j < 5; j++)
                smallBox.add(generateString(3,6));
            bigBox.add(smallBox);
        }

        //Изменение элементов
        bigBox.get(2).set(3,"elem");

        LinkedList<String>box = new LinkedList<>();
        for (int i = 0;i < 5;i++)
            box.add("s");

        bigBox.set(2,box);


        for (LinkedList<String> smallBox:bigBox) {
            for (String s : smallBox)
                System.out.print(s + " ");
            System.out.println();
        }

    }

    //Сгенерировать случайную строку
    public static String generateString(int minCount, int maxCount) {
        Random random = new Random();
        int count = random.nextInt(maxCount - minCount) + minCount;
        //Получить случайное число от minCount до maxCount
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            char c = (char) (random.nextInt((int) 'z' - (int) 'a') + 'a');
            sb.append(c);
        }
        int c1 =(random.nextInt(9)+1);
        sb.append(c1);
        return sb.toString();
    }
}