package boj.silver3;

import java.util.Arrays;
import java.util.Scanner;

public class Boj15654_N과M5_순열 {

    static int N, M;
    static int[] num;
    static int[] sel;
    static boolean[] check;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        N = sc.nextInt();
        M = sc.nextInt();
        num = new int[N];
        sel = new int[N];
        check = new boolean[N];
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }

        Arrays.sort(num);


        seq(0,0);

        System.out.println(sb.toString());

    }

    private static void seq(int idx, int sidx) {
        if(sidx == M){
            for (int i = 0; i < M; i++) {
                sb.append(sel[i]+" ");
            }
            sb.append("\n");
            return;
        }
        else{
            for (int i = 0; i < N; i++) {
                if(!check[i]){
                    check[i] = true;
                    sel[sidx] = num[i];;
                    seq(idx+1, sidx+1);
                    check[i] = false;
                }
            }
        }
    }


}
