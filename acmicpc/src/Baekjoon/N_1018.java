package Baekjoon;

import java.util.Scanner;

public class N_1018 {
    public static boolean[][] board;
    public static int min = 64;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        board = new boolean[n][m];

        // W = true  B = false
        for(int i = 0; i < n; i++) {
            String st = sc.next();
            for(int j = 0; j < m; j++) {
                if(st.charAt(j) == 'W') {
                    board[i][j] = true;
                } else {
                    board[i][j] = false;
                }
            }
        }


        int n_row = n - 7;
        int m_col = m - 7;

        for(int i = 0; i < n_row; i++) {
            for(int j = 0; j < m_col; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }

    public static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        boolean TF = board[x][y];

        for(int i = x; i < end_x; i++) {
            for(int j = y; j < end_y; j++) {
                if(board[i][j] != TF) {
                    count++;
                }

                TF = (!TF);  // 다음 칸으로 색이 바뀌므로 값을 바꿔 줌.
            }
            /*
                다음 줄에도 색이 반대가 되므로 바꿔 줌.
                ex) WBWBWB
                    BWBWBW
             */
            TF = !TF;
        }

        /*
            첫 번째 칸을 기준으로 할 때의 색칠 할 개수(count)와
            첫 번째 칸의 색의 반대되는 색을 기준으로 할 때의
            색칠 할 개수(64 - count) 중 최솟값을 count에 저장

            1. 첫 번째 칸 만 잘못된 경우 = count = 1
            2. 첫 번째 칸을 제외한 모든 칸이 잘못되 있을 경우 = count = 63
            여기서 최소를 골라야 하기 때문에 min(count, 64 - count)를 해 줌.
         */
        count = Math.min(count, 64 - count);

        /*
            입력받은 판이 8*8을 넘어가면 다음 경우의 수가 발생
            위에서 계산된 최소로 칠해야 하는 경우의 수 중에서
            가장 작은 경우의 수를 골라야 하기 때문에
            이전까지의 경우 중 최소값 보다 현재
            칠해야 하는 경우의 수(count)가 더 작을 경우 최소값 갱신
         */
        min = Math.min(min, count);

    }
}
