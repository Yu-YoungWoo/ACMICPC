package Baekjoon.PrimeNumber;


import java.util.Scanner;
public class eratos_sieves {

    public static boolean[] prime;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        make_prime(n);

        for(int i = 1; i < prime.length; i++) {
            if(prime[i] == false) {
                System.out.println(i);
            }
        }
    }

    public static void make_prime(int n) {
        prime  = new boolean[n + 1];

        if(n < 2) {
            return;
        }

        prime[0] = prime[1] = false;

        for(int i = 2; i <= Math.sqrt(n); i++) {

            // 이미 체크된 배열이면 다음 반복문으로 skip
            if(prime[i] == true) {
                continue;
            }

            for(int j = i * i; j < prime.length; j = j + i) {
                prime[j] = true;
            }
        }

    }

}
