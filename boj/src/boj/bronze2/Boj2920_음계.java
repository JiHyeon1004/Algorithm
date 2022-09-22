package bronze2;

import java.util.Scanner;

public class Boj2920_음계 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String music = sc.nextLine();
		
		String ascending = "1 2 3 4 5 6 7 8";
		String descending = "8 7 6 5 4 3 2 1";
		
		if(music.equals(ascending)) {
			System.out.println("ascending");
		}
		else if(music.equals(descending)) {
			System.out.println("descending");
		}
		else {
			System.out.println("mixed");
		}
	}
}
