package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Boj1302_베스트셀러 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 팔린 책의 수
		int N = Integer.parseInt(br.readLine());
		// 해쉬맵 생성
		HashMap<String, Integer> book = new HashMap<String, Integer>();

		// 책 입력받는다.
		for (int i = 0; i < N; i++) {
			String bookName = br.readLine();
			// 이미 팔린 책이라면 value를 1 증가시킨다.
			if (book.containsKey(bookName)) {
				book.replace(bookName, book.get(bookName) + 1);
			}
			// 아니면 추가
			else {
				book.put(bookName, 1);
			}
		}

		// map을 list로 변형
		List<Entry<String, Integer>> bestSeller = new ArrayList<Entry<String, Integer>>(book.entrySet());

		// list로 변한 것을 정렬
		Collections.sort(bestSeller, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				// value가 같다면 이름 오름차순
				if (o2.getValue() == o1.getValue()) {
					return o1.getKey().compareTo(o2.getKey());
				}
				// value 내림차순
				return o2.getValue().compareTo(o1.getValue());
			}

		});
		// 출력
		System.out.println(bestSeller.get(0).getKey());
	}
}
