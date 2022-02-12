package Baekjoon;

import java.util.Scanner;

public class N_1193 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();

                // 대각선의 개수     // 대각선의 누적 합?
            int cross_count = 1, prev_count_sum = 0;

            while (true) {
                if(x <= cross_count + prev_count_sum) {

                    if(cross_count % 2 == 1) {
                        // 분모가 큰 수부터 시작
                        // 분모는 대각선의 개수 - (X 번째 - 직전 대각까지의 누적합 - 1)
                        // 분자는 X 번째 - 직전 대각선까지의 누적합
                        System.out.println((cross_count - (x - prev_count_sum - 1)) + "/" + (x - prev_count_sum));
                    } else {
                        System.out.println((x - prev_count_sum) + "/" + (cross_count - (x - prev_count_sum - 1)));
                    }
                    break;
                } else {
                    prev_count_sum += cross_count;
                    cross_count++;
                }
            }
    }
}
