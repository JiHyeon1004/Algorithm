package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Class_1225_암호생성기 {

	public static void main(String[] args) {

		// 스캐너로 입력받아줌
		Scanner sc = new Scanner(System.in);

		// 테스트케이스 10번 받아준다
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt(); // 테스트케이스넘버
			Queue<Integer> password = new LinkedList<>(); // 암호를 큐로 선언
			boolean flag = true;

			// 8자리 암호문을 받아준다.
			for (int i = 0; i < 8; i++) {
				password.add(sc.nextInt());
			}

			// 사이클,.플래그가 트루일 때 작동한다.
			while (flag == true) {
				for (int i = 1; i <= 5; i++) {
					int renewnum = password.poll() - i; // 새로 갱신되는 숫자는 맨 앞 숫자를 가져와서 - i
					if (renewnum <= 0) { // 만약 갱신된 숫자가 0이거나 더 작다면
						password.add(0); // 맨 뒤에 0 추가
						flag = false; // 플래그를 펄스로 바꿔주고
						break; // 깨준다
					}
					// 그게 아니라면
					password.add(renewnum); // 갱신된 숫자를 뒤에 넣어준다.
				}
			}

			// 출력
			System.out.printf("#%d", tc);
			for (int i = 0; i < 8; i++) {
				System.out.print(" " + password.poll()); // poll말고 다른 방법을 쓰고 싶은데 잘 모르겠다ㅜㅜ
			}
			System.out.println();
		}
	}

}
