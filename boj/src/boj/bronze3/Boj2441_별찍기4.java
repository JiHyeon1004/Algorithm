package bronze3;

import java.util.Scanner;

public class Boj2441_별찍기4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        //한 행의 출력을 n번 반복
        for (int i = 0; i < n; i++) {
            //공백 입력
            for (int j = 0; j < i; j++) {
                sb.append(" ");
            }
            //별 입력
            for (int k = n; k > i; k--) {
                sb.append("*");
            }
            //마지막 줄이 아니라면 개행문자
            if (i != n - 1) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
