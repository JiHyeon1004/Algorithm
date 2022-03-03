package boj.silver4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj2164_카드2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Queue<Integer> card = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			card.offer(i);
		}

		while (card.size() > 1) {
			card.poll();
			card.offer(card.poll());
		}

		System.out.println(card.poll());
	}

}
