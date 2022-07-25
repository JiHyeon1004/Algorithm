package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj3986_좋은단어 {

    public static void main(String[] args) throws IOException {
        //버퍼드리더로 입력받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //단어의 개수
        int N = Integer.parseInt(br.readLine());
        int cnt = 0; //좋은 단어의 개수

        //단어의 개수만큼 돌린다.
        for (int i = 0; i < N; i++) {
            String word = br.readLine(); //단어 입력받음
            Stack<Character> stack = new Stack<>(); //스택 생성

            //단어의 길이만큼 돌린다.
            for (int j = 0; j < word.length(); j++) {
                //스택이 비어있다면 푸쉬
                if (stack.isEmpty()) {
                    stack.push(word.charAt(j));
                }
                //비어있지 않고
                else {
                    //top이 현재 글자와 같다면 팝
                    if (stack.peek() == word.charAt(j)) {
                        stack.pop();
                    }
                    //다르다면 푸쉬
                    else {
                        stack.push(word.charAt(j));
                    }
                }
            }
            //과정을 마친 후 스택이 비었다면 개수 1씩 증가
            if (stack.isEmpty()) {
                cnt++;
            }
        }
        //출력
        System.out.println(cnt);
    }
}
