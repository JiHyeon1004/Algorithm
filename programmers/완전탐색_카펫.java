package programmers;

public class 완전탐색_카펫 {
	
	static int[] answer;
	
	public static void main(String[] args) {
		answer = new int[2];
		solution(10, 2);
		for(int i = 0; i < 2; i++) {
			System.out.println(answer[i]);
		}
		
		
	}

	public static int[] solution(int brown, int yellow) {
//		int[] answer = {};

		// 가로를 a, 세로를 b라고하면
		// a >= b
		// 노란색은 a-2 * b-2
		// 갈색은 a * b - yellow
		// 갈색 + 노란색은 a * b

		int a = 0;
		int b = 0;
		int whole = yellow + brown;
		System.out.println(whole);
		for (int i = whole; i >= 1; i--) {
			if (whole % i == 0) {
				a = i;
				b = whole / a;

				if ((a - 2) * (b - 2) == yellow) {
					answer[0] = a;
					answer[1] = b;
					break;
				}
			}
		}

		return answer;
	}
}
