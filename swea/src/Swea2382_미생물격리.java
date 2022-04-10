import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea2382_미생물격리 {

	public static int[][] cellArr; // 셀 배열
	public static int cell; // 셀 크기
	public static int K; // 미생물 군집 수
	public static int[][] micro; // 미생물배열
	public static int[][] crash; // 부딪히는 미생물들의 배열

	// 메인
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 버퍼드리더로 입력받아준다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 테스트케이스
		int T = Integer.parseInt(br.readLine());

		// 테스트케이스만큼 돌려준다.
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			cell = Integer.parseInt(st.nextToken()); // 구역의 크기
			int time = Integer.parseInt(st.nextToken()); // 시간
			K = Integer.parseInt(st.nextToken()); // 미생물 군집의 수
			micro = new int[K][4]; // 미생물 정보를 담을 배열

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				micro[i][0] = Integer.parseInt(st.nextToken()); // 세로좌표
				micro[i][1] = Integer.parseInt(st.nextToken()); // 가로좌표
				micro[i][2] = Integer.parseInt(st.nextToken()); // 미생물 수
				micro[i][3] = Integer.parseInt(st.nextToken()); // 방향 (상:1, 하:2, 좌:3, 우:4)
			}

			// 시간만큼 돌릴거야
			for (int i = 0; i < time; i++) {
				for (int j = 0; j < K; j++) {
					// 무브메서드를
					move(j, micro[j][0], micro[j][1], micro[j][2], micro[j][3]);
				}
			}
			// 미생물수
			int cnt = 0;

			// 미생물 군집을 돌면서 수를 합하자.
			for (int i = 0; i < K; i++) {
				cnt += micro[i][2];
			}

			// 출력
			System.out.printf("#%d %d \n", tc, cnt);

		} // tc
	}// main

	// 미생물 이동 메소드
	private static void move(int j, int y, int x, int num, int direction) {

		// 셀 배열
		cellArr = new int[cell][cell];

		switch (direction) {

		// 상 방향이라면
		case 1:
			// y좌표를 하나 줄여주고
			micro[j][0] = y - 1;
			// 줄였더니 0이라면
			if (y - 1 == 0) {
				micro[j][2] /= 2; // 미생물 수 반으로
				micro[j][3] = 2; // 하방향으로 바꾼다.
			}

			cellArr[y - 1][x]++; // 해당 위치 셀 배열의 값을 하나 증가시켜준다.

			break;

		// 하 방향이라면
		case 2:
			// y좌표를 하나 키워주고
			micro[j][0] = y + 1;
			// 줄였더니 셀 끝이라면
			if (y + 1 == cell - 1) {
				micro[j][2] /= 2; // 미생물 수 반으로
				micro[j][3] = 1; // 상방향으로 바꾼다.
			}

			cellArr[y + 1][x]++; // 해당 위치 셀 배열의 값을 하나 증가시켜준다.

			break;

		// 좌 방향이라면
		case 3:
			// x좌표를 하나 줄여주고
			micro[j][1] = x - 1;
			// 줄였더니 0이라면
			if (x - 1 == 0) {
				micro[j][2] /= 2; // 미생물 수 반으로
				micro[j][3] = 4; // 우방향으로 바꾼다.
			}

			cellArr[y][x - 1]++; // 해당 위치 셀 배열의 값을 하나 증가시켜준다.

			break;

		// 우 방향이라면
		case 4:
			// x좌표를 하나 늘려주고
			micro[j][1] = x + 1;
			// 늘렸더니 셀 끝이라면
			if (x + 1 == cell - 1) {
				micro[j][2] /= 2; // 미생물 수 반으로
				micro[j][3] = 3; // 좌방향으로 바꾼다.
			}

			cellArr[y][x + 1]++; // 해당 위치 셀 배열의 값을 하나 증가시켜준다.

			break;

		case 0:
			// 0이면 패스

			break;

		default:
			break;
		}// switch

		// 부딪히는 아이들에 대한 처리
		// cellArr를 돌면서
		for (int i = 0; i < cell; i++) {
			for (int k = 0; k < cell; k++) {
				if (cellArr[i][k] > 1) { // cellArr의 값이 1보다 크다면 부딪힌다는 것을 의미

					// 부딪히는 미생물 배열
					// 5칸짜리인 이유는 마지막에 K중에 몇 번째인지 인덱스를 넣어주기 위해.
					// cellArr[i][k] 는 부딪히는 미생물 군집의 수
					crash = new int[cellArr[i][k]][5];
					// 누가누가 부딪히는지 찾아주는 메서드
					search(i, k);

					int max = 0; // 부딪히는 애들 중 최대의 미생물 수
					int king = -1; // 최대의 미생물 수를 갖는 군집이 K개 중 몇 번째인지의 인덱스
					int kingDirection = -1; // 최종 결정될 방향

					// crash배열을 돌면서 가장 많은 미생물수를 갖는 군집을 찾고, 방향을 결정한다.
					for (int m = 0; m < cellArr[i][k]; m++) {
						if (crash[m][2] > max) {
							max = crash[m][2];
							king = crash[m][4];
							kingDirection = crash[m][3];
						}
					} // m

					int cnt = 0; // 부딪히는 군집들의 미생물 수 합
					for (int m = 0; m < cellArr[i][k]; m++) {
						// 가장 큰 군집이 아니라면
						if (crash[m][4] != king) { // crash[m][4] 는 K중 몇 번째인지를 뜻한다.
							// 모두 0으로 리셋
							micro[crash[m][4]][0] = 0;
							micro[crash[m][4]][1] = 0;
							cnt += micro[crash[m][4]][2]; // 카운트에 미생물 수를 더해준다.
							micro[crash[m][4]][2] = 0;
							micro[crash[m][4]][3] = 0;

						}
					}
					// 가장 큰 군집 미생물 수에 cnt를 더해준다.
					micro[king][2] += cnt;
				}

			}
		}

	}// move

	// 부딪히는 미생물 군집을 찾아서 crash 배열에 정보를 저장하는 메서드
	private static void search(int y, int x) {
		int j = 0; // j는 crash배열의 인덱스
		// K개의 군집을 돌면서
		// y좌표와 x좌표가 주어진 값과 같다면
		for (int i = 0; i < K; i++) {
			if (micro[i][0] == y && micro[i][1] == x) {
				// 해당 정보를 crash배열에 저장
				crash[j][0] = y;
				crash[j][1] = x;
				crash[j][2] = micro[K][2];
				crash[j][3] = micro[K][3];
				crash[j][5] = i;
			}
			j++;
		}
	} // search
}
