package programmers.Lv02;

import java.util.Stack;

public class Lv02_올바른괄호 {

    class Solution {
        boolean solution(String s) {

            //스택을 이용해서 괄호의 짝이 올바른지 확인하자.
            Stack<Character> bracket = new Stack<>();

            for(int i = 0; i < s.length(); i++){
                switch(s.charAt(i)){
                    case '('://여는 괄호
                        bracket.push('(');//스택에 입력
                        break;

                    case ')'://닫는 괄호
                        if(!bracket.empty() && bracket.pop() == '('){
                            continue;
                        }
                        return false; //짝이 안 맞아
                }
            }

            return bracket.empty(); //스택에 괄호가 남아있다면 짝이 안 맞아
        }
    }
}
