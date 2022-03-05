package boj.silver2;

import java.util.Scanner;

public class Boj18111_마인크래프트 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int B = sc.nextInt();
		int[][] map = new int[N-1][M-1];
		
		for(int i = 0; i < N-1; i++) {
			for(int j = 0; j < M-1; j++) {
				map[i][j] = sc.nextInt();
			}
		}
	}

}
