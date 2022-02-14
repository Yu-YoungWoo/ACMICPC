package Baekjoon;

import java.util.Scanner;

public class N_2581 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        getPrimeNumbers(m, n);

    }

    public static void getPrimeNumbers(int m, int n) {
        int[] numbers = new int[n - m + 1];
        int sum = 0;
        int min = 0;

        numbers = initNumber(numbers, m);

        for(int i = 0; i < numbers.length; i++) {
            if (isPrimeNumber(numbers[i])) {
                sum += numbers[i];
                if(min == 0) {
                    min = numbers[i];
                }
            }
        }
        if(sum == 0 && min == 0 || sum == 1 && min == 1) {
            System.out.print(-1);
        } else {
            System.out.println(sum);
            System.out.print(min);
        }

    }

    public static int[] initNumber(int[] numbers, int m) {
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = m++;
        }

        return numbers;
    }

    public static boolean isPrimeNumber(int number) {
        if(number == 1) {
            return false;
        }
        for(int i = 2; i < number; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
