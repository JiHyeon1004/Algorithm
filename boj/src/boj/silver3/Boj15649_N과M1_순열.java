package silver3;

import java.util.Scanner;

public class Boj15649_N과M1_순열 {

    static int N;
    static int M;
    static boolean[] checked; //숫자를 사용했는지 체크
    static int[] sel; //선택한 숫자를 담을 배열
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        sb = new StringBuilder();
        checked = new boolean[N+1];
        sel = new int[M];

        perm(0);

        System.out.println(sb.toString());

    }

    //sidx는 sel arr의 idx, 즉 몇 번째 숫자를 뽑고있는지
    public static void perm(int sidx){
        if (sidx == M){
            for (int i = 0; i < M; i++) {
                sb.append(sel[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(!checked[i]){
                sel[sidx] = i;
                checked[i] = true;
                perm(sidx+1);
                checked[i] = false;
            }
        }
    }
}
