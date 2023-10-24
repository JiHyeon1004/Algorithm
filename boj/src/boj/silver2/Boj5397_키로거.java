package boj.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj5397_키로거 {

    //스택을 두 개 만든다. (커서 왼쪽과 오른쪽)
    //마지막에 스택 합쳐서 출력

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < tc; i++) {

            StringBuilder sbd1 = new StringBuilder();
            StringBuilder sbd2 = new StringBuilder();

            Stack<String> left = new Stack<>();
            Stack<String> right = new Stack<>();

            String pwd = bufferedReader.readLine();
            for (int j = 0; j < pwd.length(); j++) {
                if (pwd.charAt(j) == '<') {
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    else {
                        continue;
                    }
                } else if (pwd.charAt(j) == '>') {
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    else {
                        continue;
                    }
                } else if (pwd.charAt(j) == '-') {
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    else {
                        continue;
                    }
                } else {
                    left.push(pwd.charAt(j)+"");
                }
            }

            while(!left.isEmpty()){
                sbd1.append(left.pop());

            }

            while (!right.isEmpty()){
                sbd2.append(right.pop());
            }


            System.out.println(sbd1.reverse().toString() + sbd2.toString());
        }
    }
}
