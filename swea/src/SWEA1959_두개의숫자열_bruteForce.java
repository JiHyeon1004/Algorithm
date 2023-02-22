package SWEA;

import java.util.Scanner;

public class SWEA1959_두개의숫자열_bruteForce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = scanner.nextInt();

        //테스트케이스의 수 만큼 돌린다.
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#" + tc + " ");

            //입력 값 채우기
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int L = Math.max(N, M); //더 긴 배열의 길이
            int S = Math.min(N, M); //더 짧은 배열의 길이
            int[] longArray = new int[20];
            int[] shortArray = new int[20];
            //N이 더 길다면
            if (L == N) {
                for (int i = 0; i < L; i++) {
                    longArray[i] = scanner.nextInt();
                }
                for (int i = 0; i < S; i++) {
                    shortArray[i] = scanner.nextInt();
                }

            }
            //M이 더 길다면
            else {
                for (int i = 0; i < S; i++) {
                    shortArray[i] = scanner.nextInt();
                }
                for (int i = 0; i < L; i++) {
                    longArray[i] = scanner.nextInt();
                }
            }


            int gap = L - S; //두 배열의 길이 차이

            int max = 0;

            //max에 첫 번째 계산 값을 저장한다. (음수때문에 최저점을 임의로 잡을 수 없음)
            for (int i = 0; i < S; i++) {
                max += shortArray[i] * longArray[i];
            }

            //브루트포스로 돌리면서 max갱신
            for (int i = 1; i <= gap; i++) {
                int cal = 0;
                for (int j = 0; j < S; j++) {
                    cal += shortArray[j] * longArray[j + i];
                }
                if (cal > max) {
                    max = cal;
                }
            }

            sb.append(max);
            sb.append("\n");

        }

        System.out.println(sb.toString());


        /** 참고
         * 순서대로 입력을 받고 싶다면
         * 메소드를 만들고 상황에 따라 메소드에 인자를 다르게 넣어주면 된다.
         *
         * int ans = (N>M) ? find(N,M,A,B) : find(M,N,B,A);
         *
         * public static int find(int n, int m, int[] a, int[] b){
         *  int max = -99999;
         *  for(int i = 0; i < n-m+1; i++){
         *  int sum = 0;
         *  for(int j = 0; j < m; j+=){
         *  sum += a[i+j]*b[i];
         *          }
         *      }
         *  }
         */

    }

}
