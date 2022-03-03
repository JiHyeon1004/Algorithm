package boj.silver5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj1316_그룹단어체커 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			String word = sc.next();
			char[] alphabet = word.toCharArray();

			for (int j = 0; j < alphabet.length - 1; j++) {
				if (alphabet[i] > alphabet[i + 1]) {
					char tmp = '0';
					tmp = alphabet[i];
					alphabet[i] = alphabet[i + 1];
					alphabet[i + 1] = tmp;
				}

			}
		}
	}

}
