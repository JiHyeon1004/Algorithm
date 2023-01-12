package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2750_수정렬하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 숫자의 개수
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N]; // 숫자배열

		// 숫자 입력받아서 배열 채운다.
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// 오름차순 정렬
		Arrays.sort(arr);

		// 순서대로 출력
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}
}
