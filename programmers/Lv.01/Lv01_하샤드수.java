package programmers.Lv01;

public class Lv01_하샤드수 {
    public boolean solution(int x) {

        //x를 스트링으로
        String strX = String.valueOf(x);

        //자릿수의 합
        int sum = 0;
        for (int i = 0; i < strX.length(); i++) {
            sum += strX.charAt(i) - '0';
        }

        return x % sum == 0;
    }
}
