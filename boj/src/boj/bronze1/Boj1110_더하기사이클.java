package boj.bronze1;

import java.util.*;

public class Boj1110_더하기사이클 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int n = num;
		int newNum = 0;
		// 다음 수로 바뀔 때마다 cycle에 저장
		List<String> cycle = new ArrayList<>();

		for (int i = 0; i < 100000; i++) {
			int shib = ((n + 10) % 10);
			int medium = ((n + 10) / 10 - 1) + ((n + 10) % 10);//10 안더해도 오류 안날듯?
			int il = ((medium + 10) % 10);
			newNum = shib * 10 + il;
			n = newNum;
			cycle.add("newNum");
			if (newNum == num) {
				break;
			}
		}
		System.out.println(cycle.size());

	}

}
