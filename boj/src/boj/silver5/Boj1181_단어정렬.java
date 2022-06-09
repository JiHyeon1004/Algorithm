package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Boj1181_단어정렬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N입력받아줌
		int N = Integer.parseInt(br.readLine());

		// 중복값을 제거하기 위해 hashset으로 받아준다.
		HashSet<String> str = new HashSet<>();
		for (int i = 0; i < N; i++) {
			str.add(br.readLine());
		}

		// hashset을 배열로
		String[] word = new String[str.size()];
		str.toArray(word);

		// comparator와 comparable사용
		Arrays.sort(word, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return o1.length() - o2.length();
			}
		});
		// 차례대로 출력
		for (int i = 0; i < word.length; i++) {
			System.out.println(word[i]);
		}
	}
}
