package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj2776_암기왕 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            HashSet<Integer> memo = new HashSet<>();

            int num1 = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < num1; i++) {
                memo.add(Integer.parseInt(st.nextToken()));
            }

            int num2 = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < num2; i++) {
                if (memo.contains(Integer.parseInt(st.nextToken()))) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
                if(tc != T-1 || i != num2-1){
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
