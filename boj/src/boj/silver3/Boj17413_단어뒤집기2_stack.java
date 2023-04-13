package boj.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj17413_단어뒤집기2_stack {

    //입력을 하나씩 읽으면서 <>로 쌓인 태그는 그대로 출력에 넣고 <>쌓이지 않은 단어는 스택에 넣는다.
    //스택이 비어있지 않은 상태에서 공백이나 <를 만나면 스택을 출력에 뱉어 단어를 뒤집는다.
    public static void main(String[] args) throws IOException {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        String str = brd.readLine(); //문자열 입력
        StringBuilder sbd = new StringBuilder();

        Stack<String> word = new Stack<>();
        boolean isTag = false; //태그인지 아닌지 확인
        int idx = 0; //마지막에 단어로 끝나면 뒤집어주기 위해 인덱스를 센다.

        for(String s : str.split("")){
            idx++; //인덱스 추가
            //스택에 무언가 있고 단어가 끝났거나!  거꾸리해서 출력에 담는다.
            if(!word.isEmpty() && (s.equals("<") || s.equals(" "))){
                while(!word.isEmpty()){
                    sbd.append(word.pop());
                }
                sbd.append(s);
                isTag = (s.equals("<"))? true : false;
            }
            //스택이 비었는데 마지막 글자라면 해당 글자까지 포함해서 거꾸리한 후 출력에 담는다.
            else if(!word.isEmpty() && idx == str.length()){
                sbd.append(s);
                while(!word.isEmpty()){
                    sbd.append(word.pop());
                }
            }


            //태그 시작
            else if(s.equals("<")){
                isTag = true;
                sbd.append(s);
            }
            //태그 끝
            else if (s.equals(">")) {
                isTag = false;
                sbd.append(s);
            }
            //태그라면 그냥 출력에 담아
            else if (isTag) {
                sbd.append(s);
            }
            //단어라면 스택에 담아
            else {
                word.push(s);
            }
        }

        System.out.println(sbd.toString());
    }
}
