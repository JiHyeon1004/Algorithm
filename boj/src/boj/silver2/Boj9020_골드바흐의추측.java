package boj.silver2;

import java.util.Arrays;
import java.util.Scanner;

public class Boj9020_골드바흐의추측 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        StringBuilder sbd = new StringBuilder();

        //에라토스테네스의 체
        boolean[] prime = new boolean[10001];
        Arrays.fill(prime, true);
        for (int i = 2; i < 10001; i++) {
            if(prime[i]){
                for (int j = 2*i; j < 10001; j+=i) {
                    prime[j] = false;
                }
            }
            else{
                continue;
            }
        }

        //중간지점부터 시작하여
        //소수인 수가 있으면 그 나머지도 소수인지 확인
        for (int i = 0; i < tc; i++) {
            int n = scanner.nextInt();
            for (int j = n/2; j > 1; j--) {
                if(prime[j]){
                    if(prime[n-j]){
                        sbd.append(j + " " + (n-j));
                        sbd.append("\n");
                        break;
                    }
                }
            }
        }

        System.out.println(sbd.toString());

    }
}
