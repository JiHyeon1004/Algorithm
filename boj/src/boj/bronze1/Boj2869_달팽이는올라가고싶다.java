package boj.bronze1;

import java.io.*;
import java.util.StringTokenizer;

public class Boj2869_달팽이는올라가고싶다 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		int L = V - A;
		int day = 0;

		if (L % (A - B) == 0) {
			day = L / (A - B) + 1;
		} else {
			day = L / (A - B) + 2;
		}
		System.out.println(day);

	}

}
