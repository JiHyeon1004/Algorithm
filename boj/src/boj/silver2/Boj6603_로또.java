package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj6603_로또 {
    static int[] num;
    static boolean[] check;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            check = new boolean[k];
            if (k == 0) {
                break;
            } else {
                num = new int[k];
                for (int i = 0; i < k; i++) {
                    num[i] = Integer.parseInt(st.nextToken());
                }
                comb(0, 0);
                System.out.println();
            }
        }
    }

    private static void comb(int idx, int cnt) {
        if (cnt == 6) {
            for (int i = 0; i < k; i++) {
                if (check[i])
                    System.out.print(num[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = idx; i < k; i++) {
            check[i] = true;
            comb(i + 1, cnt + 1);
            check[i] = false;
        }

    }

}
