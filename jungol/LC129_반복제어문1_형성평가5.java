package language_coder;

import java.util.Scanner;

public class LC129_반복제어문1_형성평가5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("Base = ");
			int base = sc.nextInt();
			System.out.print("Height = ");
			int height = sc.nextInt();
			double width = (double) base*height*0.5;
			System.out.print("Triangle width = ");
			System.out.printf("%.1f", width);
			System.out.println();
			System.out.print("Continue? ");
			String ans = sc.next();
			if(!ans.toLowerCase().equals("y")) {
				break;
			}
		}
	}
}
