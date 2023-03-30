package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] bank = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bank[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(bank);

        int time = 0;

        for (int i = 0; i < N; i++) {
            time += bank[i] * (N-i);
        }

        System.out.println(time);
    }
}
