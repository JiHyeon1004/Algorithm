package boj.silver4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//3의 배수는 각 자릿수의 합도 3의 배수인 것을 이용.

public class Boj10610_30_greedy {

    static int n, ans;
    static String[] num;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nums = scanner.next();
        StringBuilder sbd = new StringBuilder();
        ans = -1;
        n = nums.length();
        num = new String[n];
        boolean possible = false; //0이 들어있지 않으면 30의 배수가 될 수 없다.

        int sumEach = 0; //각 자릿수의 합

        for (int i = 0; i < n; i++) {
            num[i] = "" + nums.charAt(i);
            if (num[i].equals("0")){
                possible = true;
            }
            sumEach += Integer.parseInt(num[i]);
        }

        //0이 없거나 아예 0이라면
        if(!possible || sumEach == 0){
            System.out.println(-1);
            return;
        }

        //내림차순 정렬
        Arrays.sort(num, Collections.reverseOrder()); 

        //3의 배수라면
        if(sumEach % 3 == 0){
            for(String s : num){
                sbd.append(s);
            }
            System.out.println(sbd.toString());
        }
        //3의 배수가 아니라면
        else{
            System.out.println(-1);
        }

    }

}
