package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boj2751_수정렬하기2 {
	// O(n^2)을 못하게 하는 문제
	// arrays.sort보다 collections.sort가 빠르다
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 출력을 위한 스트링빌더

		// 숫자의 개수
		int N = Integer.parseInt(br.readLine());
		List<Integer> num = new ArrayList<Integer>(); // 숫자를 담을 리스트

		// 숫자를 리스트에 추가해준다.
		for (int i = 0; i < N; i++) {
			num.add(Integer.parseInt(br.readLine()));
		}
		// 정렬
		Collections.sort(num);
		// 리스트 돌면서 스트링빌더에 담는다.
		for (int i = 0; i < N; i++) {
			sb.append(num.get(i) + "\n");
		}
		// 출력
		System.out.println(sb);
	}
}
