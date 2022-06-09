package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj10815_숫자카드_이분탐색 {
	static int[] card;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		card = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(card);
		
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			sb.append(have(num) + " ");
		}
		
		System.out.println(sb);
		
	}

	private static int have(int num) {
		int min = 0;
		int max = N-1;
		int mid = 0;
		
		while(min <= max) {
			mid = (min + max) / 2;
			if(card[mid] == num) {
				return 1;
			}
			else if(card[mid] < num) {
				min = mid + 1;
			}
			else {
				max = mid - 1;
			}
		}
		return 0;
	}
}
