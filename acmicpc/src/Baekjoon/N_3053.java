package Baekjoon;

import java.util.Scanner;

public class N_3053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double r = sc.nextInt();

        System.out.println(r * r * Math.PI);
        System.out.println( 2 * r * r);
    }
}
