package Baekjoon;/*
규칙 1
max의 값은 distance의 루트값에서 소수점을 버린 정수값

규칙 2
max가 변하는 지점과 다음 지점 사이에는 항상 count가 두 번씩 변한다.

규칙 3
max 값이 변할 때의 count는 다음 수식을 따른다
count = 2 * max - 1
 */
import java.util.Scanner;

public class N_1011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            int distance = y - x;
            int max = (int) Math.sqrt(distance);

//            System.out.println(max + " " + Math.sqrt(distance));

            if(max == Math.sqrt(distance)) {   // 정수 == 제곱근이 정수로 딱 떨어질 경우
                System.out.println(2 * max - 1);
            } else if(distance <= max * max + max) {   // 거리 == 거리(distance)에 따른 최소 count
                System.out.println(2 * max);
            } else {  //
                System.out.println(2 * max + 1);
            }
        }
    }
}
