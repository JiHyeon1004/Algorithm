package boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1389_케빈베이컨의6단계법칙_플로이드와샬 {

    static final int max = 999999999;

    public static void main(String[] args) throws IOException {
        //버퍼드리더로 입력받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //N입력받아서 필요한 것들 정의
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] friend = new int[N + 1][N + 1];

        //초기값을 크게 잡아야한다.
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                friend[i][j] = max;
            }
        }


        //관계의 수
        int M = Integer.parseInt(st.nextToken());
        //친구관계 작성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friend[a][b] = 1;
            friend[b][a] = 1;

        }


        //플로이드와샬
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    friend[i][j] = Math.min(friend[i][j], friend[i][k] + friend[k][j]);
                }
            }
        }


        //답 구하기
        int min = max;
        int person = -1;
        for (int i = N; i > 0; i--) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += friend[i][j];
            }

            if (sum <= min) {
                min = sum;
                person = i;
            }
        }

        System.out.println(person);
    }
}
