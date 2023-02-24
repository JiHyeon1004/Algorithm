package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5215_햄버거다이어트_부분집합 {

    public static boolean sel[];
    public static int maxTaste;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        //테스트케이스만큼 돈다.
        for (int T = 1; T <= tc; T++) {
            sb.append("#" + T + " ");

            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()); //재료의 수
            int limitCal = Integer.parseInt(st.nextToken()); //제한칼로리
            int[][] ingredients = new int[num][2]; //0열은 맛의 점수, 1열은 칼로리
            sel = new boolean[num];

            //재료 입력
            for (int i = 0; i < num; i++) {
                st = new StringTokenizer(br.readLine());
                ingredients[i][0] = Integer.parseInt(st.nextToken());
                ingredients[i][1] = Integer.parseInt(st.nextToken());
            }

            maxTaste = 0;
            hamburger(num, limitCal, ingredients, 0);

            sb.append(maxTaste + "\n");
        }
        System.out.println(sb.toString());
    }

    //햄버거 조합
    public static void hamburger(int num, int limitCal, int[][] ingredients, int idx) {
        //기본 부분
        if (idx == num) {
            //칼로리 계산을 먼저 해본다.
            int cal = 0;
            int taste = 0;
            for (int i = 0; i < num; i++) {
                if (sel[i]) {
                    cal += ingredients[i][1];
                    taste += ingredients[i][0];
                }
                if (cal > limitCal) {
                    return;
                }
            }
            //칼로리 제한 안에 든다면
            //맛 점수 비교
            if (taste > maxTaste) {
                maxTaste = taste;
            }
            return;
        }

        //재귀부분
        sel[idx] = true;
        hamburger(num, limitCal, ingredients, idx + 1);
        sel[idx] = false;
        hamburger(num, limitCal, ingredients, idx + 1);
    }

}
