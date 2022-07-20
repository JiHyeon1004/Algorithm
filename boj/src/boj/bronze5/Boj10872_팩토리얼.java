package bronze5;

import java.util.Scanner;

public class Boj10872_팩토리얼 {
    static int[] factorial; //factorial을 담을 배열

    //main
    public static void main(String[] args) {
        //스캐너로 입력받는다.
        Scanner sc = new Scanner(System.in);
        //0부터 12까지의 배열
        factorial = new int[13];
        factorial[0] = 1; //0!은 1
        factorial[1] = 1; //1!은 1

        //N 입력받는다.
        int N = sc.nextInt();

        //N이 1보다 크다면 팩토리얼 찾는 메소드 getFactorial 실행
        if (N > 1) {
            getFactorial(N);
        }

        //팩토리얼값 출력
        System.out.println(factorial[N]);
    }

    //팩토리얼값 찾는 메소드 getFactorial
    private static void getFactorial(int n) {
        //곱하는 과정을 나타낼 수 tmp
        int tmp = 1;
        //값이 채워져있다면 그 값 * tmp 가 답이고
        //값이 채워져있지 않다면 tmp에 곱해준다.
        for (int i = n; i >= 1; i--) {
            if (factorial[i] != 0) {
                factorial[n] = tmp * factorial[i];
                break;
            } else {
                tmp *= i;
            }
        }
    }
}
