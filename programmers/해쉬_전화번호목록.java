package programmers;

import java.util.HashMap;

public class 해쉬_전화번호목록 {

	public static void main(String[] args) {
		
		String[] phone_book = {"123","456","789"};
		solution(phone_book);

	}

	public static void solution(String[] phone_book) {

		boolean answer = true;

		HashMap<Integer, String> num = new HashMap<Integer, String>();
		for (int i = 0; i < phone_book.length; i++) {
			num.put(i, phone_book[i]);
		}
		outer: for (int i = 0; i < phone_book.length; i++) {
			for (int k = 0; k < phone_book.length; i++) {
				for (int j = 1; j < phone_book[i].length(); j++) {
					if (phone_book[i].substring(1, j).equals(phone_book[k])) {
						answer = false;
						break outer;
					}
				}
			}
		}

		System.out.println(answer);

	}

}
