package boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14889_스타트와링크_조합 {

    static int N, gap;
    static int[][] power;
    static boolean[] team;
    static int[] sel;


    public static void main(String[] args) throws IOException {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(brd.readLine());
        power = new int[N][N];
        team = new boolean[N];
        sel = new int[N / 2];
        gap = 9999999;

        //능력치 채우기
        for (int i = 0; i < N; i++) {
            StringTokenizer stn = new StringTokenizer(brd.readLine());
            for (int j = 0; j < N; j++) {
                power[i][j] = Integer.parseInt(stn.nextToken());
            }
        }

        makeTeam(0, 0);

        System.out.println(gap);
    }

    public static void makeTeam(int idx, int sidx) {

        //사람 수 다 채워졌으면 계산
        if (sidx == N / 2) {

            int start = 0;
            int link = 0;
            for (int i = 0; i < N-1; i++) {
                for (int j = i+1; j < N; j++) {
                    if(team[i] && team[j]){
                        start += power[i][j] + power[j][i];
                    }
                    else if (!team[i] && !team[j]){
                        link += power[i][j] + power[j][i];
                    }
                }
            }

            //gap 갱신
            gap = Math.min(gap, Math.abs(start - link));
            if(gap == 0){
                System.out.println(0);
                System.exit(0);
            }
            return;
        }

        //안채워졌으면 버려
        if (idx == N) {

            return;
        }


        if(!team[idx]){
            //팀정하기
            makeTeam(idx + 1, sidx);
            sel[sidx] = idx;
            team[idx] = true;
            makeTeam(idx + 1, sidx+1);
            team[idx] = false;
        }


    }
}
