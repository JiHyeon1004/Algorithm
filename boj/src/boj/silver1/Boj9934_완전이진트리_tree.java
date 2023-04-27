package boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9934_완전이진트리_tree {
    public static void main(String[] args) throws IOException {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sbd = new StringBuilder();
        int k = Integer.parseInt(brd.readLine());
        int[][] tree = new int[k+1][(int) Math.pow(2, k-1)];

        String[] visited = brd.readLine().split(" ");

        tree[0][0] = visited.length/2; //visited배열의 인덱스를 담는다.
        sbd.append(visited[tree[0][0]]);
        sbd.append("\n");
        int level = 1;
        int n = (tree[0][0] + 1) / 2;

        while (level < k) {

            for (int i = 0; i < Math.pow(2, level-1); i++) {
                tree[level][2*i] = tree[level-1][i] - n;
                sbd.append(visited[tree[level][2*i]] + " ");

                tree[level][(2*i)+1] = tree[level-1][i] + n;
                sbd.append(visited[tree[level][2*i+1]] + " ");
            }

            sbd.append("\n");
            level++;
            n /= 2;
        }

        System.out.println(sbd.toString());
    }
}
