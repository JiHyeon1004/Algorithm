package boj.bronze1;

import java.util.Scanner;

public class Boj2563_색종이 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] c = new int[n];
		int[] r = new int[n];
		int[][] paper = new int[100][100]; //도화지를 배열로. 기본값 0
		int sum = 0; //넓이

		//n만큼 c, r 입력받음
		for (int i = 0; i < n; i++) {
			c[i] = sc.nextInt(); //가로
			r[i] = sc.nextInt(); //세로
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					paper[c[i] + k][90 - r[i] + j]++; // 색종이가 차지 하는 공간의 배열값을 플러스해준다.
				}
			}
		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (paper[i][j] != 0) { //배열값이 0이 아니면~ 즉, 색종이에 덮여있으면~
					sum++; //넓이에 +1
				}
			}
		}
		System.out.println(sum);
	}
}
