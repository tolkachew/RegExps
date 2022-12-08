package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExps {
    public static void main(String[] args) throws IOException {
        //Строка содержит только 1 символ
        String s1 = " ", s2 = "sb";
        Pattern pattern = Pattern.compile(".");
        Matcher matcher = pattern.matcher(s1);
        //System.out.println(matcher.matches());
        //Строка содержит только 1 символ
        check(".", " ", "ab");
        check(".{5}", "12345", "234");
        //Строка содержит одну или более букву "a", а за ней одну букву "b"
        check("a+b", "aab", "abb");
        //Строка содержит несколько или ни одной буквы "a", а за ней одну букву "b"
        check("a*b", "b", "abb");
        //Слово состоит из двух букв, первая из которых "a"
        check("a.", "ab", "abb");
        //Последняя буква в строке "а"
        check(".*a", "a", "abb");
        //Третья буква - а
        check(".{2}a.*", "cba", "abb");
        //Первая а и последняя буквы - а
        check("a.*a+", "cba", "abb");
        //Первая а и последняя буквы - одинаковы
        check("(.).*\\1", "acba", "abb");
        //Не должна начинаться с буквы - а или b
        check("[^ab].*", "cbb", "aabb");
        //check("(.a).*\\1", "bacbba", "aabba");
        //Четные символы - а
        check("(.a)+", "baba", "babc");
        //Первая и последняя буквы не одинаковы
        //check("(.).*[^\\1]", "baba", "babb");
        //Строка не содержит буквы - а
        check("[^a]+", "bcbc", "babb");
        //Слово содержит буквы - а
        check("[a-zA-Z]*a[a-zA-Z]*", "bacbc", "bcbb");
        //Строка содержит только цифры
        check("\\d+", "1", "b1cbb");
        //Строка содержит вещественным числом с фиксированной точкой
        check("[+-]?\\d+[.]?\\d*?", "-1.1", "b1cbb");
        //Проверит номер телефона в формате 8-023-123-45-67
        check("8\\(\\d{3}\\)-\\d{3}-\\d{2}-\\d{2}", "8(023)-123-45-67", "98(023)-123-45-67");


        TextFileReader textFileReader = new TextFileReader("src/com/company/data/vocab.txt");
        ArrayList list = (ArrayList) textFileReader.getList();
        System.out.println(list.toString());
            for(int i=0;i< list.size();i++)
                if(pattern.compile(("t.*")).matcher((String) list.get(i)).matches())
                    System.out.print(list.get(i)+" ");

    }

    public static void check(String pattern, String s1, String s2) {
        boolean b1 = Pattern.compile(pattern).matcher(s1).matches();
        boolean b2 = Pattern.compile(pattern).matcher(s2).matches();
        System.out.println(b1+" "+b2);

    }
    static class TextFileReader {
        String fileName;
        private List<String> list = new ArrayList<String>();

        TextFileReader(String fileName) throws IOException {
            this.fileName = fileName;
            StringBuilder sb;
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                sb = new StringBuilder();
                String line = br.readLine();
                while (line != null) {
                    if (!line.equals("i"))
                        list.add(line);
                    line = br.readLine();
                }
            }
        }
        public List<String> getList() {
            return list;
        }
    }
}
