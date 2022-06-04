package bronze2;

import java.util.Scanner;

public class Boj2231_분해합 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//N을 입력받는다.
		int N = sc.nextInt();
		int M = 0; //N의 생성자 M의 초기값은 0
		
		//작은 값부터 시작해서 생성자인지 확인하고
		//생성자라면 M에 담는다.
		for(int i = 1; i < N; i++) {
			int sum = i; //합을 i로 초기화
			int tempI = i; //i값을 originalI에 담아준다.
			//i의 각 자리수를 더해준다.
			while(tempI > 0) {
				sum += tempI % 10;
				tempI /= 10;
			}
			//합이 N과 같다면 생성자이므로
			if(sum == N) {
				M = i;
				break;
			}
		}
		//출력
		System.out.println(M);
	}
}
