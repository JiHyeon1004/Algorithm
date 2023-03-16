package boj.silver5;

import java.util.Scanner;

//greedy : 매 순간 최선의 선택을 하지만 이들이 결합된 결과는 최선이 아닐 수 있다.
//매 순간의 선택은 다른 선택에 영향을 줄 수 없다.
public class Boj1789_수들의합_greedy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long S = scanner.nextLong();

        //작은 수부터 더한다.
        int answer = 0;
        while(S>=0){
            answer++;
            S -= answer;
        }

        System.out.println(answer-1);
    }
}
