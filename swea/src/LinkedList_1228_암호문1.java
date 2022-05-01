package swea;

import java.util.LinkedList;
import java.util.Scanner;

public class LinkedList_1228_암호문1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			LinkedList<Integer> list = new LinkedList();

			for (int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}
			int commandNum = sc.nextInt();

			for (int i = 0; i < commandNum; i++) {
				String l = sc.next();
				int after = sc.nextInt();
				int num = sc.nextInt();
				LinkedList<Integer> addlist = new LinkedList();

				for (int j = 0; j < num; j++) {
					addlist.add(sc.nextInt());
				}

				list.addAll(after, addlist);
			}

			System.out.printf("#%d", tc);
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + list.pop());
			}
			System.out.println();
		}
	}

}
