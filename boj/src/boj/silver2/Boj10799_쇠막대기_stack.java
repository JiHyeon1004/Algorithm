package boj.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj10799_쇠막대기_stack {

    // 스택을 두 개 만든다.
    // 하나는 레이저가 아직 지나가지 않은 막대기를 스택 (왼)
    // 하나는 레이저가 지나가고 있는 막대기를 담은 스택 (오)
    // 막대기들을 오른쪽부터 읽으면서 오스택에 담는다.
    // 레이저가 발견되면 막대기 조각 수에 오스택의 사이즈를 추가한다.
    // 막대기가 끝나면 오스택에서 하나의 막대기를 제거하면서 막대기 조각 수를 추가한다.

    public static void main(String[] args) throws IOException {

        Stack<String> before = new Stack<>();
        Stack<String> after = new Stack<>();
        int num = 0;
        int not = 0; //after에 포함된 레이저와 이미 길이가 끝난 막대기의 수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        //우선 before에 모든 괄호를 담는다.
        for (int i = 0; i < str.length(); i++) {
            before.push(str.charAt(i)+"");
        }

        //after에 하나씩 담으면서 자르기를 진행한다.
        for (int i = 0; i < str.length(); i++) {
            String s = before.pop();
            // 막대기의 오른쪽 끝이라면 그냥 담는다.
            if(s.equals(")")){
                after.push(s);
            }
            //레이저라면 애프터 스택에 담긴 막대기들을 한 번씩 잘라낸다.
            else if(s.equals("(") && after.peek().equals(")")){
                after.push(s);
                not += 2;
                num += after.size() - not;
            }
            // 막대기의 왼쪽 끝이라면 막대기를 꺼내고, 해당 막대기의 수만 답에 추가한다.
            else if(s.equals("(") && after.peek().equals("(")){
                ++not;
                ++num;
            }
        }

        System.out.println(num);


    }
}
