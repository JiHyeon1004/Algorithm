package boj.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2579_계단오르기_dp {
    public static void main(String[] args) throws IOException {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(brd.readLine()); //계단 수
        int[] score = new int[N + 1]; //계단 별 점수 배열

        //score[0] 은 시작지점임 (점수 없음)
        //계단 점수 입력
        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(brd.readLine());
        }

        // dp
        // 0열 : 해당 idx의 계단에서 얻을 수 있는 최대 점수를 저장
        // 1열 : 몇 칸 연속인지
        int[] stair = new int[N + 1];
        //첫 계단 초기화
        stair[1] = score[1];

        //N이 2 이상이라면 두 번째 계단도 초기화
        //두 번째 계단이 타겟이라면 무조건 연속으로 오르는 것이 점수가 크다.
        if (N >= 2) {
            stair[2] = score[1] + score[2];
        }

        for (int i = 3; i <= N; i++) {
            // 이전 계단에서 한 칸 오른 경우와 (3칸 연속이라면 불가능하므로 0을 먹여버림)
            // 두 단계 전에서 두 칸 오르는 경우를 비교해 더 큰 점수를 찾는다.
            int oneStepScore = stair[i - 3] + score[i-1] + score[i];
            int twoStepScore = stair[i - 2] + score[i];
            stair[i] = Math.max(oneStepScore, twoStepScore);
        }

        System.out.println(stair[N]);

    }
}


//처음엔 dp배열을 이중배열로 해서 2열에 연속성 정보를 담으려고 했으나
//그런 식으로 진행할 경우 2,3번 을 밟는 경우가 잡히지 않아서 틀린 듯
// (2번이 무조건 1,2 두 개 밟는 경우라서)
