package silver5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Boj2161_카드1 {
	public static void main(String[] args) {
		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(); // 출력을 위한 스트링빌더

		// 카드의 수
		int N = sc.nextInt();

		// 쌓여있는 카드를 저장할 큐
		Queue<Integer> card = new LinkedList<>();
		// 버린 카드를 저장할 리스트
		List<Integer> cardDummy = new ArrayList<Integer>();

		// 카드를 생성해주고
		for (int i = 1; i <= N; i++) {
			card.add(i);
		}

		// 카드가 한 장 남을 때까지 돌린다.
		while (card.size() > 1) {
			cardDummy.add(card.poll()); // 한 장 빼서 카드더미에 저장해주고
			card.add(card.poll()); // 한 장 빼서 카드의 맨 뒤에 추가한다.
		}

		// 스트링빌더에 추가해주고
		for (int i = 0; i < cardDummy.size(); i++) {
			sb.append(cardDummy.get(i) + " ");
		}
		sb.append(card.poll());

		// 출력
		System.out.println(sb);
	}
}
