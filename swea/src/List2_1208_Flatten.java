package swea;

import java.util.Scanner;

public class List2_1208_Flatten {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int x = 1; x <= 10; x++) {
			int dump = sc.nextInt();
			int[] boxheight = new int[100];
			int finalmax = 0;
			int finalmin = 100;

			for (int i = 0; i < 100; i++) {
				boxheight[i] = sc.nextInt();

			}

			for (int i = 0; i < dump; i++) {
				int max = 0;
				int maxidx = 0;
				int min = 100;
				int minidx = 0;
				for (int j = 0; j < 100; j++) {
					if (boxheight[j] > max) {
						max = boxheight[j];
						maxidx = j;
					}
					if (min > boxheight[j]) {
						min = boxheight[j];
						minidx = j;
					}
				}
				boxheight[maxidx]--;
				boxheight[minidx]++;
			}

			for (int i = 0; i < 100; i++) {
				if (boxheight[i] > finalmax) {
					finalmax = boxheight[i];
				}
				if (finalmin > boxheight[i]) {
					finalmin = boxheight[i];
				}
			}

			System.out.println("#" + x + " " + (finalmax - finalmin));
		}
	}

}
