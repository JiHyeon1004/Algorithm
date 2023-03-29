package silver3;

import java.util.Scanner;

public class Boj15651_N과M3_dfs {

    static int N;
    static int M;
    static int[] seqArr;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        seqArr = new int[N];

        sb = new StringBuilder();

        dfs(0);

        System.out.println(sb.toString());
    }

    public static void dfs(int n) {
        if (n == M) {
            for (int j = 0; j < M; j++) {
                sb.append(seqArr[j] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            seqArr[n] = i;
            dfs(n+1);
        }
    }
}
