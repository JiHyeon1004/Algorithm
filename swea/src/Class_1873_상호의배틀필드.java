package swea;

import java.util.Scanner;

public class Class_1873_상호의배틀필드 {
	public static void main(String[] args) {

		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트케이스 수

		// 테스트케이스만큼 돌려줌
		for (int tc = 1; tc <= T; tc++) {
			int H = sc.nextInt(); // 세로
			int W = sc.nextInt(); // 가로
			char[][] map = new char[H][W]; // 가로*세로 배열 만들어줌

			// 지도 입력받음
			for (int i = 0; i < H; i++) {
				String str = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			// 현재 전차의 위치 찾기
			int tankx = 0;
			int tanky = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') { // 전차가 있으면
						tankx = j; // 전차의 X좌표
						tanky = i; // 전차의 Y좌표
					}
				}
			}

			// 명령어 입력받기
			int N = sc.nextInt();
			String command = sc.next();
			for (int i = 0; i < N; i++) { // 명령어 순서대로 처리
				switch (command.charAt(i)) {
				case 'U': // 명령어가 U라면
					map[tanky][tankx] = '^'; // 방향을 위로 바꾸고
					if (tanky - 1 >= 0 && map[tanky - 1][tankx] == '.') { // 맵을 벗어나지 않으면서 위가 평지이면
						map[tanky][tankx] = '.'; // 탱크가 있던 자리를 평지로 바꾸고
						tanky--; // 탱크의 Y좌표 -1
						map[tanky][tankx] = '^'; // 탱크 이동
					}

					break;
				case 'D': // 명령어가 D라면
					map[tanky][tankx] = 'v'; // 방향을 아래로 바꾸고
					if (tanky + 1 < H && map[tanky + 1][tankx] == '.') { // 맵을 벗어나지 않으면서 아래가 평지이면
						map[tanky][tankx] = '.'; // 탱크가 있던 자리를 평지로 바꾸고
						tanky++; // 탱크의 Y좌표 +1
						map[tanky][tankx] = 'v'; // 탱크 이동
					}

					break;
				case 'L': // 명령어가 L이라면
					map[tanky][tankx] = '<'; // 방향을 왼쪽으로 바꾸고
					if (tankx - 1 >= 0 && map[tanky][tankx - 1] == '.') { // 맵을 벗어나지 않으면서 왼쪽이 평지이면
						map[tanky][tankx] = '.'; // 탱크가 있던 자리를 평지로 바꾸고
						tankx--; // 탱크의 X좌표 -1
						map[tanky][tankx] = '<'; // 탱크 이동
					}

					break;
				case 'R': // 명령어가 R이라면
					map[tanky][tankx] = '>'; // 방향을 오른쪽으로 바꾸고
					if (tankx + 1 < W && map[tanky][tankx + 1] == '.') { // 맵을 벗어나지 않으면서 오른쪽이 평지이면
						map[tanky][tankx] = '.'; // 탱크가 있던 자리를 평지로 바꾸고
						tankx++; // 탱크의 X좌표 +1
						map[tanky][tankx] = '>'; // 탱크 이동
					}

					break;
				case 'S': // 명령어가 S이고
					if (map[tanky][tankx] == '^') { // 방향이 위라면
						for (int m = 1; m <= tanky; m++) { // 맵 맨 위까지 탐색하면서
							if (map[tanky - m][tankx] == '*') { // 벽돌 벽을 발견!
								map[tanky - m][tankx] = '.'; // 평지로 바꿔
								break; // 포문 나가
							} else if (map[tanky - m][tankx] == '#') { // 강철 벽을 발견!
								break; // 포문 나가
							}

						}
					} else if (map[tanky][tankx] == 'v') { // 방향이 아래라면
						for (int m = 1; m < (H - tanky); m++) { // 맵 맨 아래까지 탐색하면서
							if (map[tanky + m][tankx] == '*') { // 벽돌벽
								map[tanky + m][tankx] = '.'; // 평지로 바꿔
								break;
							} else if (map[tanky + m][tankx] == '#') { // 강철벽
								break; // 패스
							}

						}
					} else if (map[tanky][tankx] == '<') { // 방향이 왼쪽이라면
						for (int m = 1; m <= tankx; m++) { // 맵 맨 왼쪽까지 탐색하면서
							if (map[tanky][tankx - m] == '*') { // 벽돌별
								map[tanky][tankx - m] = '.';
								break;
							} else if (map[tanky][tankx - m] == '#') { // 강철벽
								break;
							}

						}
					} else if (map[tanky][tankx] == '>') { // 방향이 오른쪽이라면
						for (int m = 1; m < (W - tankx); m++) { // 맵 맨 오른쪽까지 탐색하면서
							if (map[tanky][tankx + m] == '*') { // 벽돌벽
								map[tanky][tankx + m] = '.';
								break;
							} else if (map[tanky][tankx + m] == '#') { // 강철벽
								break;
							}

						}
					}

					break;

				default:
					break;
				}
			}

			// 출력
			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
		sc.close();
	}

}
