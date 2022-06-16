package language_coder;

public class LC548_반복제어문2_자가진단8 {
	public static void main(String[] args) {
		for (int i = 2; i < 5; i++) {
			for (int j = 1; j < 6; j++) {
				System.out.printf("%d * %d =%3d   ", i, j, i * j);
			}
			System.out.println();
		}
	}
}
