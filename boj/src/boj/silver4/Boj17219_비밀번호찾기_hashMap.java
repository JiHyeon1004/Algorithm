package boj.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj17219_비밀번호찾기_hashMap {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sbr = new StringBuilder();

        StringTokenizer stz = new StringTokenizer(bfr.readLine());
        int N = Integer.parseInt(stz.nextToken());
        int M = Integer.parseInt(stz.nextToken());

        HashMap<String, String> password = new HashMap<>();

        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(bfr.readLine());
            password.put(stz.nextToken(), stz.nextToken());
        }

        for (int i = 0; i < M; i++) {
            sbr.append(password.get(bfr.readLine())).append("\n");
        }

        System.out.println(sbr.toString());
    }
}
