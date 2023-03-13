package programmers.Lv02;

import java.util.Stack;

public class Lv02_짝지어제거하기 {
    class Solution
    {
        public int solution(String s)
        {
            Stack<Character> zzak = new Stack<>();
            int i = 0;

            while(i < s.length()){
                if(zzak.empty()){
                    zzak.push(s.charAt(i));
                }
                else {
                    if(zzak.peek()==s.charAt(i)){
                        zzak.pop();
                    }
                    else{
                        zzak.push(s.charAt(i));
                    }
                }
                i++;
            }

            return (zzak.empty()) ? 1 : 0;
        }

    }
}
