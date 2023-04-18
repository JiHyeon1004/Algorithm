package boj.silver4;

import java.util.Scanner;

public class Boj1748_수이어쓰기1 {
    public static void main(String[] args) {
        int ans = 0;

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        if(N < 10){
            System.out.println(N);
            return;
        }

        //자리수
        int num = String.valueOf(N).length();
        double numTen = Math.pow(10, num-1);

        System.out.println("numTen = " + numTen);

        ans += ((N - numTen) + 1) * num; //개수 * 길이

        System.out.println("ans = " + ans);

        N = (int) numTen-1;

        System.out.println("N = " + N);

        while(N >= 10){
            System.out.println("----------들어간다------");
            num--;
            System.out.println("num = " + num);
            numTen /= 10;
            System.out.println("numTen = " + numTen);
            ans += ((N - numTen) + 1) * num;
            System.out.println("ans = " + ans);
            N /= 10;
        }

        System.out.println(ans + 9);
    }
}
