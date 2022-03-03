package boj.silver3;

import java.util.Scanner;

public class Boj1244_스위치켜고끄기 {
	public static void main(String[] args) {

		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(); // 스위치의 개수
		int[] arr = new int[num]; // 스위치 배열

		// 스위치 입력받아줌
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}

		int student = sc.nextInt(); // 학생 수 입력
		int[] gender = new int[student]; // 학생의 성별
		int[] key = new int[student]; // 학생이 받은 수
		int[] realkey = new int[student]; // 실제 인덱스는 학생이 받은 수 -1이기 때문에..인덱스에 들어갈 배열

		// 학생수만큼 돌린다.
		for (int i = 0; i < student; i++) {
			gender[i] = sc.nextInt(); // 학생의 성별 입력받음
			key[i] = sc.nextInt(); // 학생이 받은 수
			realkey[i] = key[i] - 1; // 학생이 받은 수에서 -1 해준다.

			if (gender[i] == 1) { // 남자라면
				while (realkey[i] < num) { // 인덱스값이 num보다 작을 때만 돌린다.
					arr[realkey[i]] = arr[realkey[i]] == 0 ? 1 : 0; // 인덱스의 스위치가 0이면 1로 바꾸고 아니면 0으로 바꾼다.
					realkey[i] += key[i]; // 인덱스에 학생이 받은 수를 더해준다.(배수이므로)
				}
			} else { // 여자라면
				int j = 0;
				for (j = 0; j < num; j++) {
					if (realkey[i] - j >= 0 && realkey[i] + j < num && arr[realkey[i] - j] == arr[realkey[i] + j]) { //인덱스가 배열 범위 안에 있고, 대칭되는 스위치의 값이 같으면
						arr[realkey[i] - j] = arr[realkey[i] - j] == 0 ? 1 : 0; //대칭의 왼쪽을 맡은 스위치가 0이면 1로 바꾸고 아니면 0으로 바꾼다.
						arr[realkey[i] + j] = arr[realkey[i] - j]; //왼 = 오 만들어줌
					} else { //아니면 깨버려
						break;
					}

				}
			}
		}

		//출력
		for (int i = 0; i < num; i++) {
			System.out.print(arr[i] + " ");
			if (i % 20 == 19) { //20의 배수-1번째일때마다
				System.out.println(); //엔터쳐줘
			}
		}
		sc.close();
	}

}
