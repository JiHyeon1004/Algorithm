package swea;

import java.util.Scanner;

public class Im_7272_안경이없어 {
	public static void main(String[] args) {

		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String left = sc.next();
			String right = sc.next();
			String ans = "DIFF"; // 기본값은 diff
			int cnt = 0; // 한 글자씩 같아보일때마다 카운트 더해줌

			// 일단 왼쪽 오른쪽 글자수가 같아야한다.
			if (left.length() == right.length()) {

				for (int i = 0; i < left.length(); i++) {
					// i번째 글자가 노빵꾸라면
					if (left.charAt(i) == 'C' || left.charAt(i) == 'E' || left.charAt(i) == 'F' || left.charAt(i) == 'G'
							|| left.charAt(i) == 'H' || left.charAt(i) == 'I' || left.charAt(i) == 'J'
							|| left.charAt(i) == 'K' || left.charAt(i) == 'L' || left.charAt(i) == 'M'
							|| left.charAt(i) == 'N' || left.charAt(i) == 'S' || left.charAt(i) == 'T'
							|| left.charAt(i) == 'U' || left.charAt(i) == 'V' || left.charAt(i) == 'W'
							|| left.charAt(i) == 'X' || left.charAt(i) == 'Y' || left.charAt(i) == 'Z') {
						if (right.charAt(i) == 'C' || right.charAt(i) == 'E' || right.charAt(i) == 'F'
								|| right.charAt(i) == 'G' || right.charAt(i) == 'H' || right.charAt(i) == 'I'
								|| right.charAt(i) == 'J' || right.charAt(i) == 'K' || right.charAt(i) == 'L'
								|| right.charAt(i) == 'M' || right.charAt(i) == 'N' || right.charAt(i) == 'S'
								|| right.charAt(i) == 'T' || right.charAt(i) == 'U' || right.charAt(i) == 'V'
								|| right.charAt(i) == 'W' || right.charAt(i) == 'X' || right.charAt(i) == 'Y'
								|| right.charAt(i) == 'Z') {
							cnt++; // 둘 다 노빵꾸면 카운트+1
						}
					}
					// i번째 글자가 원빵꾸라면
					if (left.charAt(i) == 'A' || left.charAt(i) == 'D' || left.charAt(i) == 'O' || left.charAt(i) == 'P'
							|| left.charAt(i) == 'Q' || left.charAt(i) == 'R') {
						if (right.charAt(i) == 'A' || right.charAt(i) == 'D' || right.charAt(i) == 'O'
								|| right.charAt(i) == 'P' || right.charAt(i) == 'Q' || right.charAt(i) == 'R') {
							cnt++; // 둘 다 원빵꾸면 카운트 +1
						}
					}
					// i번째 글자가 투빵꾸라면
					if (left.charAt(i) == 'B' && right.charAt(i) == 'B') {
						cnt++; // 둘 다 투빵꾸면 카운트+1
					}
				}
				if (cnt == left.length()) { // 글자길이만큼 카운트가 세졌다면
					ans = "SAME"; // same으로 바뀐다.
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

}
