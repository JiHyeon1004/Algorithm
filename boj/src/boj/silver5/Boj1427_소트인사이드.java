package silver5;

import java.util.Arrays;
import java.util.Scanner;

public class Boj1427_소트인사이드 {
	public static void main(String[] args) {
		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(); // 출력을 위한 스트링빌더

		// 숫자입력받음
		int N = sc.nextInt();

		// 숫자를 문자배열로
		String num = String.valueOf(N);
		char[] arr = num.toCharArray();

		// 오름차순 정렬
		Arrays.sort(arr);

		// 뒤에서부터 스트링빌더에 넣는다.
		for (int i = arr.length - 1; i >= 0; i--) {
			sb.append(arr[i]);
		}

		// 출력
		System.out.println(sb);
	}
}
