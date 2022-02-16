package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class N_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());  // up
        int b = Integer.parseInt(st.nextToken());  // down
        int v = Integer.parseInt(st.nextToken());  // length

        // (length - down) / (a - b) => down을 빼고 up만 했을때의 최소한의 일(day) 수
        int day = (v - b) / (a - b);

        //최소한의 day를 구했는데 올라가야 길이(length)가 남아 있다면 하루 더 올라가고 끝난다.
        //문제에서 정상까지 올라갔다면 미끄러지지 않아야 하므로 down은 고려해주지 않는다.
        if((v - b) % (a - b) != 0) {
            day++;
        }
        System.out.println(day);
    }
}
