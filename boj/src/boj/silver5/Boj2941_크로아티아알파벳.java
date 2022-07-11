package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2941_크로아티아알파벳 {
	public static void main(String[] args) throws IOException {
		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 문자열 입력받아서 char배열로
		String str = br.readLine();
		char[] alphabet = str.toCharArray();

		// 애초에 문자열 길이를 cnt로
		int cnt = alphabet.length;

		// 문자열 돌면서
		for (int i = 0; i < alphabet.length; i++) {
			// =나-있으면 뭉탱이니깐 카운트 하나 빼주고
			if (alphabet[i] == '=' || alphabet[i] == '-') {
				cnt--;
			}
			// dz= 도 한 뭉탱이이므로 하나 더 빼준다.
			// 이 때 i의 범위 지정 안해주면 인덱스에러난다.
			else if (i > 0 && i < alphabet.length - 1 && alphabet[i] == 'z' && alphabet[i - 1] == 'd'
					&& alphabet[i + 1] == '=') {
				cnt--;
			}
			// lj, nj인 경우도 하나 빼준다.
			else if (i > 0 && alphabet[i] == 'j' && (alphabet[i - 1] == 'l' || alphabet[i - 1] == 'n')) {
				cnt--;
			}
		}
		// 카운트 출력
		System.out.println(cnt);
	}
}
