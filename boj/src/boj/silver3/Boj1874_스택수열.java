package boj.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj1874_스택수열 {
	public static void main(String[] args) throws IOException {

		// stack 생성
		Stack<Integer> seq = new Stack<>();

		// BufferedReader로 입력 받아준다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 입력 받을 숫자의 개수
		int stacknum = 0; // stack에 들어갔던 숫자 중 가장 큰 수
		boolean flag = true;

		// 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		// N개만큼의 숫자를 받아준다.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()); // 숫자입력부분

			// stack이 비어있거나 num이 top보다 크다면
			if (seq.isEmpty() || num > seq.peek()) {
				// top = num 일 때까지 push
				// sb에 문자열 추가
				for (int j = stacknum + 1; j <= num; j++) {
					seq.push(j);
					sb.append("+").append("\n");
					stacknum++; // push될 때마다 stacknum은 하나씩 증가
				}
			}
			// 만약 top이 num보다 크다면 NO를 반환해야함
			else if (seq.peek() > num) {
				// flag를 false로 바꿔준다.
				flag = false;

			}
			// stack 맨 위에 저장된 수가 num이므로 pop 한 번 해줘야함
			seq.pop();
			sb.append("-").append("\n");

		}
		// flag에 따라 출력
		if (flag == true) {
			System.out.println(sb.toString());
		} else {
			System.out.println("NO");
		}
	}

}
