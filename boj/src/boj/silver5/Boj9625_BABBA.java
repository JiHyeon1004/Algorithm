package boj.silver5;

import java.util.Scanner;

public class Boj9625_BABBA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();

        int[] numA = new int[9999];
        int[] numB = new int[9999];

        numA[0] = 1; //처음에 A가 하나 존재한다.

        //직전 A는 B로 바뀌고
        //직전 B는 BA로 바뀐다.
//        numA[i] = numB[i-1];
//        numB[i] = numA[i-1] + numB[i-1];

        for (int i = 1; i < k + 1; i++) {
            numA[i] = numB[i - 1];
            numB[i] = numA[i - 1] + numB[i - 1];
        }

        System.out.println(numA[k] + " " + numB[k]);


    }
}
