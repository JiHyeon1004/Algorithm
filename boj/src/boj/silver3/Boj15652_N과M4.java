package boj.silver3;

import java.util.Scanner;

public class Boj15652_N과M4 {

    static int N, M;
    static boolean[][] check;
    static int[] sel;
    static StringBuilder stringBuilder;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        check = new boolean[N][N];
        sel = new int[M];

        stringBuilder = new StringBuilder();

        sequence(0);

        System.out.println(stringBuilder.toString());
    }

    public static void sequence(int idx) {
        if (idx == M) {
            for (int i = 0; i < M; i++) {
                stringBuilder.append((sel[i] + 1) + " ");
            }
            stringBuilder.append("\n");
            return;
        } else if (idx == 0) {
            for (int i = 0; i < N; i++) {
                sel[idx] = i;
                sequence(idx + 1);
            }
        }
        else{
            for (int i = sel[idx-1]; i < N; i++) {
                sel[idx] = i;
                sequence(idx + 1);
            }
        }
    }


}
