package Baekjoon;

import java.util.Scanner;

public class N_2163 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        //(n - 1) * n + (m - 1)
        //n * m - 1
        System.out.println((n * m) - 1);
    }
}
