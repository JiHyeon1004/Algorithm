package language_coder;

public class LC570_배열2_자가진단7 {
	public static void main(String[] args) {
		// 5*5배열 생성
		int[][] num = new int[5][5];
		StringBuilder sb = new StringBuilder(); // 출력을 위한 스트링빌더

		// 첫 번째 행과 첫 번째 열을 1로
		for (int i = 0; i < 5; i++) {
			num[0][i] = 1;
			num[i][0] = 1;
		}
		// 나머지는 왼쪽+위
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				num[i][j] = num[i - 1][j] + num[i][j - 1];
			}
		}
		// 돌면서 스트링빌더에 담아준다.
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				sb.append(num[i][j] + " ");
			}
			sb.append('\n');
		}
		// 출력
		System.out.println(sb);
	}
}
