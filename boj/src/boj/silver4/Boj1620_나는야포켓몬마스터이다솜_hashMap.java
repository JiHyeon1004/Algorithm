package boj.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj1620_나는야포켓몬마스터이다솜_hashMap {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        HashMap<Integer, String> pocketmon = new HashMap<>();
        HashMap<String, Integer> pocketmon2 = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = bufferedReader.readLine();
            pocketmon.put(i, name);
            pocketmon2.put(name, i);
        }

        for (int i = 1; i <= M; i++) {
            String input = bufferedReader.readLine();
            if(input.charAt(0) >= '0' && input.charAt(0) <= '9' ) {
                System.out.println(pocketmon.get(Integer.parseInt(input)));
            }
            else{
                System.out.println(pocketmon2.get(input));
            }
        }

    }
}
