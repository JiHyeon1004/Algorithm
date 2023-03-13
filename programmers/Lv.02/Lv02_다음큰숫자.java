package programmers.Lv02;

public class Lv02_다음큰숫자 {

    //Integer에 bitCount라는 메소드가 있었다...

    class Solution {
        public int solution(int n) {
            int num1N = Integer.bitCount(n);

            while(true){
                n++;
                if(Integer.bitCount(n) == num1N){
                    return n;
                }

            }
        }
    }
}
