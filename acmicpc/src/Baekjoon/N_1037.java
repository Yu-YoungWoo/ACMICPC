package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class N_1037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] arr = new int[num];
        int max;
        int min;

        for(int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        max = Arrays.stream(arr).max().getAsInt();
        min = Arrays.stream(arr).min().getAsInt();

        System.out.println(max * min);

    }
}
