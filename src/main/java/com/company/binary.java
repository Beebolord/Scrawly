package com.company;

import java.util.Scanner;

import static com.google.common.math.IntMath.pow;

public class binary {
    public static int remainder;
    public static String binaryNumber = "";
    public static int coolDecimals;
    public static Double decimal = 0.00;
    public static StringBuilder stringBuilder = new StringBuilder(100);

    public static void main(String[] args) {
        System.out.println("gimme a number ");
        Scanner scanner = new Scanner(System.in);
        int coolDecimals = scanner.nextInt();
        while (coolDecimals >= 1) {
            //System.out.print(coolDecimals % 2);
            stringBuilder.append(coolDecimals % 2);
            coolDecimals = coolDecimals / 2;

        }
        reverse(stringBuilder.toString());
        translate("1010010001010101");

    }


    public static void reverse(String versed) {
        StringBuilder reversed = new StringBuilder(100);
        for (int i = 1; i < versed.length() + 1; i++) {
            reversed.append(versed.charAt(versed.length() - i));
        }
        System.out.println(reversed.toString());
    }

    public static void translate(String binary) {
        for(int i = 1; i< binary.length() + 1 ; i++) {
            if (binary.charAt(binary.length() - i) == '1') {
                decimal = decimal + Math.pow(2, i-1);
            }
        }
        System.out.println(decimal);
    }
}
