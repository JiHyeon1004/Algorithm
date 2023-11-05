package boj.bronze2;

import java.util.Scanner;

public class Boj5528_거스름돈 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        int change = 1000 - money;

        int coin = 0;

        int[] yen = {500, 100, 50, 10, 5, 1};

        for (int i = 0; i < 6; i++) {
            int num = change/yen[i];
            coin += num;
            change -= num*yen[i];
        }

        System.out.println(coin);

    }
}
