/*
https://devmoony.tistory.com/95
https://st-lab.tistory.com/113?category=857114
*/

package Baekjoon;

import java.util.Map.Entry;
import java.util.*;

public class N_10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        String[][] list = new String[n][2];

        for(int i = 0; i < n; i++) {
            list[i][0] = sc.next();
            list[i][1] = sc.next();
        }

        Arrays.sort(list, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        for(int i = 0; i < n; i++) {
            System.out.println(list[i][0] + " " + list[i][1]);
        }
    }
}
