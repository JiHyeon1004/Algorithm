package boj.silver5;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

//n이 10000보다 작으므로 기본 자료형으로 해결할 수 없다. -> BigInteger 사용

public class Boj10826_피보나치수4_bigInteger {
    static BigInteger[] fibo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        fibo = new BigInteger[10001];
        Arrays.fill(fibo, BigInteger.ZERO);
        fibo[1] = BigInteger.ONE;
        System.out.println(getFibo(n));
    }

    static BigInteger getFibo(int n){
        //n이 0, 1 이거나 이미 구해놓은 수라면 바로 가져다 쓴다.
        if(n < 2 || fibo[n].compareTo(BigInteger.ZERO) != 0){
            return fibo[n];
        }
        //아직 구하지 않은 수라면 바로 앞 두 수의 합을 구한다.
        else {
            fibo[n] = getFibo(n-1).add(getFibo(n-2));
            return fibo[n];
        }
    }
}
