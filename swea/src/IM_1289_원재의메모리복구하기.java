package swea;

import java.util.Scanner;

public class IM_1289_원재의메모리복구하기 {
	public static void main(String[] args) {

		//스캐너로 입력받는다
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트케이스 수

		//테스트케이스만큼 돌려줌
		for (int tc = 1; tc <= T; tc++) {
			String original = sc.next(); //원래 상태
			int[] changed = new int[original.length()]; //현재 상태
			int cnt = 0; //수정횟수

			//전체를 돌면서
			for (int i = 0; i < original.length(); i++) {
				if (original.charAt(i) - '0' != changed[i]) { //원래랑 지금이랑 다르면
					changed[i] = original.charAt(i) - '0'; //현재 인덱스 바꿔주고
					for (int j = i; j < original.length(); j++) { //끝까지 통일해
						changed[j] = changed[i];
					}
					cnt++; //횟수 증가
				}
			}

			//출력
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
