package silver5;

import java.util.Scanner;

public class Boj1193_분수찾기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //입력받는 숫자가 한 개니깐 그냥 스캐너 씀

        int x = scanner.nextInt(); //숫자 입력

        int i = 0; //몇 번째 줄인지

        //몇 번째 줄인지 확인
        while (x > 0) {
            i++;
            x -= i;
        }

        // i줄 뒤에서 x의 절댓값 번째 수인데,
        // 편하게 쓰기 위해 양수로 만들어준다.
        x *= -1;


        //i가 짝수라면 정답은 i-x/x+1
        //i가 홀수라면 정답은 x+1/i-x
        //i-x 를 구해주고 i 의 홀/짝에 따라 ans에 담아주자.

        int imx = i-x;
        String ans = "";

        ans = i%2==0? imx+"/"+(x+1):(x+1)+"/"+imx;

        System.out.println(ans);

    }
}
