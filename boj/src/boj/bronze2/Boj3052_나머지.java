package bronze2;

import java.util.HashSet;
import java.util.Scanner;

public class Boj3052_나머지 {
	public static void main(String[] args) {
		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);

		// 중복을 제거하기 위한 해쉬셋
		HashSet<Integer> ans = new HashSet<>();

		// 10개의 숫자를 돌면서
		for (int i = 0; i < 10; i++) {
			int N = sc.nextInt(); // 숫자 입력받고
			ans.add(N % 42); // 넣어준다.
		}
		// 셋의 사이즈 출력
		System.out.println(ans.size());
	}
}
