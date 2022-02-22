package Baekjoon;

import java.util.Scanner;

public class N_9020 {

    static boolean[] prime = new boolean[10001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        make_prime();

        while(t-- > 0) {
            int n = sc.nextInt();
            int p = n / 2;
            int q = n / 2;

            while(true) {
                if(prime[p] == false && prime[q] == false) {
                    System.out.println(p + " " + q);
                    break;
                }
                p--;
                q++;
            }

        }

    }

    static void make_prime() {
        prime[0] = prime[1] = true;

        for(int i = 2; i < Math.sqrt(prime.length); i++) {

            if(prime[i] == true) {
                continue;
            }

            for(int j = i*i; j < prime.length; j+= i) {
                prime[j] = true;
            }
        }
    }
}
