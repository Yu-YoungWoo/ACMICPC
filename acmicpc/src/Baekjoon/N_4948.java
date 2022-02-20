package Baekjoon;

import java.util.Scanner;

public class N_4948 {
    public static boolean[] prime = new boolean[246913];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int n = sc.nextInt();
            int count = 0;
            if(n == 0) {
                break;
            }
            make_prime();

            for(int i = n + 1; i <= n*2; i++) {
                if(prime[i] == false) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static void make_prime() {

        prime[0] = prime[1] = false;


//      시간초과 X  O(NlogN) 시간이 걸림
        for(int i = 2; i <= Math.sqrt(prime.length); i++) {
            if(prime[i] == true) {
                continue;
            }
            for(int j = i*i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}
