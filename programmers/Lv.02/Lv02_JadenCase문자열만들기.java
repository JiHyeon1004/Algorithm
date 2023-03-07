package programmers;

import java.util.Arrays;

public class Lv02_JadenCase문자열만들기 {

    class Solution {
        public String solution(String s) {

            String ans = "";

            String[] str = s.toLowerCase().split("");
            boolean isFirst = true;


            System.out.println(Arrays.toString(str));

            for(String ss : str){
                ans += (isFirst)? ss.toUpperCase() : ss;
                isFirst = (ss.equals(" "))? true : false;
            }

            return ans;
        }
    }

}
