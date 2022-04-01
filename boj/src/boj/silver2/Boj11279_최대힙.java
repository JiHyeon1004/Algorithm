package boj.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11279_최대힙 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] heap = new int[N + 1]; // 힙 배열
		int size = 0; // 힙의 사이즈

		// 연산의 수 만큼 돌린다.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			// 삽입
			if (num != 0) {
				size++; // 힙의 사이즈 1 증가
				heap[size] = num; // 마지막번째에 입력 받은 수 넣는다.
				int check = size; // 규칙에 맞는지 확인하기 위한 변수 check
				// 규칙에 맞게 배치
				while (check > 1) { // 루트노드의 자손이라면
					if (heap[check] > heap[check / 2]) { // 자식이 부모보다 크다면
						// swap
						int tmp = heap[check];
						heap[check] = heap[check / 2];
						heap[check / 2] = tmp;
					}
					check = check / 2; // check를 부모노드로 이동
				}
			}
			// 삭제
			else if(num == 0) {
				// 루트노드가 0이 아닐 경우
				if (heap[1] != 0) {
					sb.append(heap[1]).append('\n');
					heap[1] = heap[size]; // 루트에 꼬다리를 넣어준다.
					heap[size] = 0; // 힙의 꼬다리는 0으로
					size--; // 힙의 크기 1감소
					// 규칙에 맞게 배치
					int check = 1;
					while (check < size) {
						if (heap[check] < Math.max(heap[check * 2], heap[check * 2 + 1])) {
							int tmp = heap[check];
							heap[check] = Math.max(heap[check * 2], heap[check * 2 + 1]);

							if (heap[check * 2] >= heap[check * 2 + 1]) {
								heap[check * 2] = tmp;
								check = check * 2;
							} else {
								heap[check * 2 + 1] = tmp;
								check = check * 2 + 1;
							}

						} else {
							break;
						}
					}
				}
				// 루트노드가 0인 경우
				else {
					sb.append("0").append('\n');
				}
			}
		}

		System.out.println(sb.toString());
	}

}
