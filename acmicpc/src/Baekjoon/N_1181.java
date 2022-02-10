/*
https://st-lab.tistory.com/112?category=857114
 */

package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class N_1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = new String[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }


        Arrays.sort(arr, (e1, e2) -> {
            if(e1.length() > e2.length()) {
                return e1.length() - e2.length();
            } else if(e1.length() == e2.length()) {
                return e1.compareTo(e2);
            } else {
                return -1;
            }
        });

        System.out.println(arr[0]);
        for(int i = 1; i < n; i++) {
            if(!arr[i].equals(arr[i - 1])) {
                System.out.println(arr[i]);
            }
        }
    }
}
