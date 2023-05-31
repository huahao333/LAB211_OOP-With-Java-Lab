
package Manage;

import java.util.Scanner;

import java.util.*;

public class Validation {

    public static Scanner sc = new Scanner(System.in);

    public static float inputFloat(String msg, float min, float max) {
        if (min > max) {
            float t = min;
            min = max;
            max = t;
        }
        float data;
        do {
            System.out.println(msg);
            data = sc.nextFloat();
        } while (data < min || data > max);
        return data;
    }

    public static String inputStr(String msg) {
        String data;
        do {
            System.out.println(msg);

            data = sc.nextLine().trim();

        } while (data.contains(" ") && data.isEmpty());
        return data;

    }

    public static String inputNonBankStr(String msg) {
        String data;
        do {

            System.out.println(msg);
            data = sc.nextLine().trim();
        } while (data.length() == 0);
        return data;
    }

    public static String inputPattern(String msg) {
        String data;
        String pattern = "R\\d{3}";
        do {
            System.out.println(msg);
            data = sc.nextLine().trim().toUpperCase();

        } while (!data.matches(pattern));
        return data;

    }
    public static String inputPatternForId(String msg) {
        String data;
        String pattern = "D\\d{3}";
        do {
            System.out.println(msg);
            data = sc.nextLine().trim().toUpperCase();

        } while (!data.matches(pattern));
        return data;

    }
    public static String inputPatternForPhone(String msg) {
        String data;
        String pattern = "'+'\\{11}";
        do {
            System.out.println(msg);
            data ="+"+ sc.nextLine().trim().toUpperCase();

        } while (!data.matches(pattern));
        return data;

    }

    public static int getChoice(Object[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + "-" + options[i]);
        }
        System.out.println("Choose 1.." + options.length + ": ");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine().trim());
    }
    

}
