package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2108_통계학 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 숫자의 개수
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N]; // 숫자배열
		int[] frequency = new int[8001]; // 빈도수 입력 배열. 음수도 있으므로 -4000해주어야한다.

		// 합
		double sum = 0;
		int max = -4000; // 최대
		int min = 4000; // 최소

		// 숫자배열 입력받는다.
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
			sum += num[i]; // 합 더해주고
			frequency[num[i] + 4000]++; // 빈도수 올려준다.
			if (max < num[i]) { // 최댓값이면 갱신
				max = num[i];
			}
			if (min > num[i]) { // 최솟값이면 갱신
				min = num[i];
			}
		}

		int fr = -1; // 최대빈도수를 갖는 숫자
		int maxFr = 0; // 최대빈도수
		// 돌면서 최대빈도수와, 최대빈도수를 갖는 숫자를 구한다.
		for (int i = 0; i < 8001; i++) {
			if (frequency[i] > maxFr) {
				maxFr = frequency[i];
				fr = i - 4000;
			}
		}
		// 최대빈도수를 갖는 숫자가 몇 개인지 확인
		int cnt = 0;
		// 돌면서
		for (int i = 0; i < 8001; i++) {
			if (frequency[i] == maxFr) {
				cnt++;
				// 두 개 이상이라면
				if (cnt == 2) {
					// 두 번째 수가 저장되고
					fr = i - 4000;
					break; // 펑
				}
			}
		}

		// 중앙값을 찾기 위해 정렬
		Arrays.sort(num);
		// 평균값
		int avg = (int) Math.round((sum / N));
		// 출력
		System.out.println(avg);
		System.out.println(num[(N - 1) / 2]);
		System.out.println(fr);
		System.out.println(max - min);
	}
}
