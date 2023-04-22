package boj.silver5;

import java.util.Scanner;

public class Boj1476_날짜계산 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int E = scanner.nextInt();
        int S = scanner.nextInt();
        int M = scanner.nextInt();

        int ans = 1;

        while(true){
            if((ans % 15 == E % 15) && (ans % 28 == S % 28) && (ans % 19 == M % 19)){
                System.out.println(ans);
                return;
            }
            ans++;
        }
    }
}
