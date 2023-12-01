package boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11403_경로찾기_플로이드와샬 {

    static int N;
    static int[][] graph;


    public static void main(String[] args) throws IOException {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(brd.readLine());
        graph = new int[N][N];


        //그래프를 주어진 대로 채운다.
        for (int i = 0; i < N; i++) {
            StringTokenizer std = new StringTokenizer(brd.readLine());
            for (int j = 0; j < N; j++) {
                int token = Integer.parseInt(std.nextToken());
                graph[i][j] = token;
            }
        }

        //플로이드 와샬
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(graph[i][k] == 1 && graph[k][j] == 1){
                        graph[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }


    }



}
