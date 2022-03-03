package boj.bronze1;

import java.util.Scanner;

public class Boj2839_설탕배달 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int five = N / 5;
		int three = 0;

		if ((N % 5) % 3 == 0) {
			three = (N % 5) / 3;
			System.out.println(five + three);
		}
		
		
		else if ( N % 3 == 0) {
			five = 0;
			three = N / 3;
			System.out.println(three);
		} else {
			System.out.println("-1");
		}

	}

}
