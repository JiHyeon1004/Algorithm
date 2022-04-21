package swea;

import java.util.Scanner;

public class String_1989_초심자의회문검사 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		//테스트케이스만큼 돌리기
		for (int x = 1; x <= T; x++) {
			int ans = 0;
			String str = sc.next();

			//앞에서 i 번째와 뒤에서 i 번째의 문자열이 같으면 1, 아니면 0
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == str.charAt(str.length() - i - 1)) {
					ans = 1;
				} else {
					ans = 0;
				}
			}

			System.out.println("#" + x + " " + ans);
		}
	}

}
