package Baekjoon;

import java.util.Scanner;

public class N_10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int h = sc.nextInt();  // 층
            int w = sc.nextInt();  // 방 길이?
            int n = sc.nextInt();  // n번째 손님

            System.out.println(getRoomNumber(h, n));
        }
    }

    public static int getRoomNumber(int h, int n) {

        int y;
        int x;

        if(n % h == 0) {
            y = h * 100;
            x = n / h;
        } else {
            y = (n % h) * 100;
            x = (n / h) + 1;
        }

        return y + x;
    }

}
