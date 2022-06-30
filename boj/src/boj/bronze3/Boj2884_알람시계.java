package bronze3;

import java.util.Scanner;

public class Boj2884_알람시계 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int hour = sc.nextInt();
		int minute = sc.nextInt();

		if (minute >= 45) {
			System.out.println(hour + " " + (minute - 45));
		} else if (hour > 0) {
			System.out.println((hour - 1) + " " + (minute + 60 - 45));
		} else {
			System.out.println(23 + " " + (minute + 60 - 45));
		}

	}
}
