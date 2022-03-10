package boj.bronze1;

import java.util.Scanner;

public class Boj11050_이항계수1 {
	public static void main(String[] args) {
		//스캐너로 입력 받아줌
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //N
		int K = sc.nextInt(); //K
		int up = 1; //분모
		int down = 1; //분자
		sc.close(); //스캐너 닫아줌
		
		//분모는 K번째까지 N!
		for(int i = 0; i < K; i++) {
			up *= (N-i);
		}
		//분자는 K!
		for(int i = 0; i < K; i++) {
			down *= (K-i);
		}
		//분모를 분자로 나눈 것이 답
		int ans = up / down;
		
		System.out.println(ans); 
	}

}
