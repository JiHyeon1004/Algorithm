package programmers;

public class Lv01_짝수와홀수 {
    public String solution(int num) {

        String answer = num % 2 == 0 ? "Even" : "Odd";
        return answer;
    }
}
