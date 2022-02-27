/*
https://st-lab.tistory.com/111?category=857114
 */

package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[][] arr = new int[n][2];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {

            st = new StringTokenizer(bf.readLine());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][0] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (e1, e2) -> {
            if(e1[0] == e2[0]) {
                return e1[1] - e2[1];
            } else {
                return e1[0] - e2[0];
            }
        });

        for(int i = 0; i < n; i++) {
            System.out.println(arr[i][1] + " " + arr[i][0]);
        }

    }
}
