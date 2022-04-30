package swea;

import java.util.Scanner;

public class Im_1288_새로운불면증치료법 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int i = 1;
		int cnt = 0;
		int newnum;

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] num = new int[10];

			while (true) {
				newnum = i * N;
				while (newnum / 10 > 0) {
					num[newnum % 10]++;
					newnum = newnum / 10;
				}
				boolean flag = false;
				for (int j = 0; j < 10; j++) {
					if (num[j] == 0) {
						flag = true;
					}
				}
				if (flag == false) {
					break;
				}
			}

			System.out.println("#" + tc + " " + newnum);
		}
	}

}
