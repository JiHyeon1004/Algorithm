package programmers.Lv02;

public class Lv02_이진변환반복하기 {

    class Solution {
        public int[] solution(String s) {

            int changed = 0; //변환 횟수
            int zeroes = 0; //사라진 0의 개수

            //1로 변할 때까지 변환한다.
            while(!s.equals("1")){
                changed++;
                int lengthBefore = s.length(); //변환 전 스트링의 길이
                s = s.replaceAll("0", ""); //0 제거
                int newLength = s.length(); //변환 후 스트링의 길이
                zeroes += lengthBefore - newLength; //사라진 0의 개수

                s = Integer.toBinaryString(newLength); //10진수의 int를 2진수의 string으로 반환
            }

            return new int[] {changed, zeroes};
        }
    }

}
