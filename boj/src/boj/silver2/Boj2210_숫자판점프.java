package boj.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj2210_숫자판점프 {

    //DFS를 이용해 탐색하고
    //완성된 여섯 자리의 수를 HashSet에 넣은 후
    //Set의 size를 출력


    static int[][] nums = new int[5][5];
    //상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    //숫자열을 저장할 해쉬셋
    static HashSet<Integer> saveSet = new HashSet<Integer>();


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        for (int i = 0; i < 5; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 5; j++) {
                nums[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, nums[i][j], 1);
            }
        }

        System.out.println(saveSet.size());

    }


    public static void dfs(int i, int j, int num, int digit) {

        //6자리 수 완성
        if (digit == 7) {
            saveSet.add(num);
            return;
        }
        //미완성
        else {
            int nr;
            int nc;

            for (int k = 0; k < 4; k++) {
                nr = i + dr[k];
                nc = j + dc[k];
                if (nr >= 0 && nc >= 0 && nr < 5 && nc < 5) {
                    dfs(nr, nc, num * 10 + nums[i][j], digit+1);
                }
            }

        }


    }

}
