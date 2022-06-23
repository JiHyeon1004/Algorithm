package language_coder;

import java.util.Arrays;
import java.util.Scanner;

public class LC563_배열1_자가진단9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[10];
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < 10; i++) {
			num[i] = sc.nextInt();
		}
		
		Arrays.sort(num);
		
		for(int i = 9; i >= 0; i--) {
			sb.append(num[i] + " ");
		}
		System.out.println(sb);
	}
}
