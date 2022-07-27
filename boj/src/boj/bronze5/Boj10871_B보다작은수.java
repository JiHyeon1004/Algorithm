package bronze5;

import java.util.Scanner;

public class Boj10871_B보다작은수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int X = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if(num < X) {
				sb.append(num + " ");
			}
		}
		
		System.out.println(sb);
	}

}
