package boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14888_연산자끼워넣기_dfs {

    static int N, max, min;
    static int[] num, operator;

    public static void main(String[] args) throws IOException {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(brd.readLine());
        num = new int[N];
        operator = new int[4];
        max = -1000000000;
        min = 1000000000;

        //숫자 채우기
        StringTokenizer stn = new StringTokenizer(brd.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(stn.nextToken());
        }
        //연산자 채우기
        stn = new StringTokenizer(brd.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(stn.nextToken());
        }

        dfs(0, num[0]);

        System.out.println(max);
        System.out.println(min);

    }



    public static void dfs(int idx, int sum) {

        //끝까지 돌았다면 값을 갱신한다.
        if (idx == N-1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        //아직 안 돌았다면 계산 진행
        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                switch (i) {
                    //+
                    case 0:
                        dfs(idx + 1, sum + num[idx + 1]);
                        break;
                    //-
                    case 1:
                        dfs(idx + 1, sum - num[idx + 1]);
                        break;
                    //*
                    case 2:
                        dfs(idx + 1, sum * num[idx + 1]);
                        break;
                    case 3:
                    //%
                        dfs(idx + 1, sum / num[idx + 1]);
                        break;
                }
                operator[i]++;
            }
        }
    }
}

