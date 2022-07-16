package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Boj2217_로프 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 로프의 개수
		int N = Integer.parseInt(br.readLine());
		// 로프의 최대 중량을 담을 배열
		Integer[] weight = new Integer[N];

		// 최대 중량 배열을 채운다ㅣ.
		for (int i = 0; i < N; i++) {
			weight[i] = Integer.parseInt(br.readLine());
		}

		// 최대 중량 배열 내림차순 정렬
		Arrays.sort(weight, Collections.reverseOrder());

		// 들 수 있는 중량을 나타낼 배열
		int[] max = new int[N];

		// max는 해당 로프의 최대 중량 * 그 최대 중량 이상을 들 수 있는 로프의 개수
		for (int i = 0; i < N; i++) {
			max[i] = weight[i] * (i + 1);
		}

		// max를 오름차순 정렬하여
		Arrays.sort(max);

		// 마지막 값을 출력
		System.out.println(max[N - 1]);
	}
}
