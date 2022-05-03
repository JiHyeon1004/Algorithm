package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class 완전탐색_모의고사 {

	static int[] answer;
	
	static class Solution {
		public static void main(String[] args) {

			int[] answers = { 1, 2, 4, 3, 2};

			solution(answers);
			
			System.out.println(Arrays.toString(answer));
		}

		public static int[] solution(int[] answers) {
//			int[] answer = {};

			// 넘버원, 넘버투, 넘버쓰리의 답지 배열을 만든다.
			int[] noOne = new int[answers.length];
			int[] noTwo = new int[answers.length];
			int[] noThree = new int[answers.length];

			// 답지 배열 채우기
			for (int i = 1; i < answers.length; i++) {
				// 1번친구의 답안
				if (i % 5 == 0) {
					noOne[i] = 5;
				}
				if (i % 5 != 0) {
					noOne[i] = i % 5;
				}
				// 2번 친구의 답안
				if (i % 2 == 1) {
					noTwo[i] = 2;
				}
				if (i % 8 == 2) {
					noTwo[i] = 1;
				}
				if (i % 8 == 4) {
					noTwo[i] = 3;
				}
				if (i % 8 == 6) {
					noTwo[i] = 4;
				}
				if (i % 8 == 0) {
					noTwo[i] = 5;
				}
				// 3번 친구의 답안
				if (i % 10 == 1 || i % 10 == 2) {
					noThree[i] = 3;
				} else if (i % 10 == 3 || i % 10 == 4) {
					noThree[i] = 1;
				} else if (i % 10 == 5 || i % 10 == 6) {
					noThree[i] = 2;
				} else if (i % 10 == 7 || i % 10 == 8) {
					noThree[i] = 4;
				} else if (i % 10 == 9 || i % 10 == 0) {
					noThree[i] = 5;
				}

			}

			int countOne = 0;
			int countTwo = 0;
			int countThree = 0;

			for (int i = 1; i < answers.length; i++) {
				if (noOne[i] == answers[i - 1]) {
					countOne++;
				}
				if (noTwo[i] == answers[i - 1]) {
					countTwo++;
				}
				if (noThree[i] == answers[i - 1]) {
					countThree++;
				}
			}

			// 최댓값을 정해주자
			int max;
			max = Math.max(countOne, countTwo);
			max = Math.max(max, countThree);

			// 리스트를 만들어서
			List<Integer> ans = new ArrayList<>();
			// 1번친구가 max와 같다면
			if (countOne == max) {
				// 1번을 리스트에 추가
				ans.add(1);
			}
			// 2번친구가 max와 같다면
			if (countTwo == max) {
				// 2번을 리스트에 추가
				ans.add(2);
			}
			// 3번친구가 max와 같다면
			if (countThree == max) {
				// 3번을 리스트에 추가
				ans.add(3);
			}

			answer = new int[ans.size()];
			
			// 리스트를 배열로 옮긴다.
			for(int i = 0; i < ans.size(); i++) {
				answer[i] = ans.get(i);
			}

			return answer;
		}
	}
}