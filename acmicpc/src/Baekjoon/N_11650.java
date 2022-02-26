package Baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class N_11650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (e1, e2) -> {
            if(e1[0] == e2[0]) {
                return e1[1] - e2[1];
            } else {
                return e1[0] - e2[0];
            }
        });


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2; j++) {
                System.out.print(arr[i][j] +  " ");
            }
            System.out.println();
        }
    }
}
