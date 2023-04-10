package boj.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Boj14425_문자열집합_hashSet {
    public static void main(String[] args) throws IOException {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = brd.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int ans = 0;

        HashSet<String> S = new HashSet<>(); //문자열 집합

        for(int i = 0; i < N; i++){
            S.add(brd.readLine());
        }

        for (int i = 0; i < M; i++) {
            if(S.contains(brd.readLine())){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
