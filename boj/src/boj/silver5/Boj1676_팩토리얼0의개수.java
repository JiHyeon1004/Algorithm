package boj.silver5;

import java.util.Scanner;

public class Boj1676_팩토리얼0의개수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int ans = 0;
        if(N < 5){
            System.out.println(ans);
            return;
        }
        for (int i = 5; i <= N; i+=5) {
            //i가 5의 배수라면
            if(i % 5 == 0){
                int j = i;
                while (j % 5 == 0) {
                    j /= 5;
                    ans++;
                }
            }
        }

        System.out.println(ans);

    }
}
