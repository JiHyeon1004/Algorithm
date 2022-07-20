package language_coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LC188_문자열1_형성평가7 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int cnt = 1;
		while (st.hasMoreTokens()) {
			sb.append(cnt + ". " + st.nextToken() + '\n');
			cnt++;
		}
		System.out.println(sb);
	}
}
