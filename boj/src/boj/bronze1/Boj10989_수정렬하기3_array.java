package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj10989_수정렬하기3_array {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 출력을 위한 스트링빌더

		// 숫자의 개수
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N]; // 숫자의 개수만큼 배열 만들어주고

		// 배열채우기
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		// 정렬
		Arrays.sort(num);
		// 순서대로 스트링빌더에 넣고
		for (int i = 0; i < N; i++) {
			sb.append(num[i]).append("\n");
		}
		// 출력
		System.out.println(sb);
	}
}
