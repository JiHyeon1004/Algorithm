package bronze3;

import java.util.Scanner;

public class Boj1085_직사각형에서탈출 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt(); // 한수의 x위치
		int y = sc.nextInt(); // 한수의 y위치
		int w = sc.nextInt(); // 직사각형의 가로
		int h = sc.nextInt(); // 직사각형의 세로

		// 직사각형의 경계선에 도달하는 방법은 상 하 좌 우 네 가지
		int up = h - y;
		int down = y;
		int left = x;
		int right = w - x;

		// 최솟값 구한다.
		int min = Math.min(up, Math.min(down, Math.min(left, right)));

		System.out.println(min);
	}
}
