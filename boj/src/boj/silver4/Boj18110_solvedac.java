package boj.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj18110_solvedac {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        int[] level = new int[n];

        for (int i = 0; i < n; i++) {
            level[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(level);

        int cut = (int) Math.round((n * 0.15));

        int sum = 0;
        for (int i = cut; i < n - cut; i++) {
            sum += level[i];
        }

        int avg = (int)  Math.round((double)sum / (n-2*cut));
        System.out.println(avg);
    }
}
