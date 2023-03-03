package silver3;

import java.util.Scanner;

public class Boj15650_N과M2_조합 {
    static int N, M;
    static int[] sel; //선택한 숫자를 담을 배열
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        sb = new StringBuilder();

        sel = new int[M];

        comb(0,1);
        System.out.println(sb);
    }

    static void comb(int sidx, int idx){
        if (sidx == M) {
            for (int i : sel) {
                sb.append(sel[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        if (idx > N){
            return;
        }
        sel[sidx] = idx;
        comb(sidx+1, idx+1);
        comb(sidx, idx+1);


        //이렇게 해도 된다. (과거의 나는 이렇게 했었음)
//        for (int i = idx; i <= N; i++) {
//            sel[sidx] = i;
//            comb(i+1, sidx+1);
//        }
    }
}
