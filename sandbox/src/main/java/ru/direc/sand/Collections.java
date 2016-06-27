package ru.direc.sand;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Daria on 27.06.2016.
 */
public class Collections {
    public static void main(String[] args) {
      /*String[] langs = new String[4];
        langs[0] = "Java";
        langs[1] = "C#";
        langs[2] = "Python";
        langs[3] = "PHP";
        Так происходит обращение к элементам массива, то же самое что и: */

        String[] langs = {"Java", "C#", "Python", "PHP"};

        List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

        /*for (int i = 0; i < langs.length; i++) {
            System.out.println("Я хочу выучить " + langs[i]);
        }
         А для коллекций есть свой способ записи:
        */

        for (String l : languages) {
            System.out.println("Я хочу выучить " + l); //l последовательно указывает на все элементы этой коллекции
        }
    }
}
