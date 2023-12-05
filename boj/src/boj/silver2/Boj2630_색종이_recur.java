package boj.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2630_색종이_recur {

    // 0 : 하얀색, 1 : 파란색
    static int[][] paper;
    static int color, white, blue;

    public static void main(String[] args) throws IOException {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(brd.readLine());
        paper = new int[N][N];

        //종이 채우기
        for (int i = 0; i < N; i++) {
            StringTokenizer stn = new StringTokenizer(brd.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(stn.nextToken());
            }
        }

        //재귀
        recur(0, N, 0, N);

        System.out.println(white);
        System.out.println(blue);

    }

    //재귀
    public static void recur(int r1, int r2, int c1, int c2){
        //더 이상 자를 수 없는 경우 색종이의 수를 카운트한다.
        if(r2 - r1 == 1 || c2 - c1 == 1){
            colorCheck(paper[r1][c1]);
            return;
        }

        //자를 수 있는 경우

        //먼저 종이 내부 색이 모두 같은지 확인
        int color = paper[r1][c1]; // 첫 번째 색상
        for (int i = r1; i < r2; i++) {
            for (int j = c1; j < c2; j++) {
                //만약 색상이 다른 게 있다면
                //4개로 쪼개서 각각 재귀를 돌린다.
                if(paper[i][j] != color){
                    recur(r1, (r1 + r2)/2, c1, (c1 + c2)/2);
                    recur(r1, (r1 + r2)/2, (c1 + c2)/2, c2);
                    recur((r1 + r2)/2, r2, c1, (c1 + c2)/2);
                    recur((r1 + r2)/2, r2, (c1 + c2)/2, c2);
                    return;
                }
            }
        }
        //색상이 모두 같다면 색종이 수 카운트
        colorCheck(color);
        return;
    }

    //색종이 수 카운트하는 메소드
    public static void colorCheck(int color){
        if (color == 0) {
            white++;
        }
        else{
            blue++;
        }
    }

}
