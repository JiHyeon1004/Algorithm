package com.ssafy.ssauction.web.controller;

import java.util.Scanner;

public class Boj9086_문자열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for (int tc = 0; tc < T; tc++) {
            String str = sc.next();
            char a = str.charAt(0);
            char b = str.charAt(str.length() - 1);
            sb.append(a + "" + b);
            sb.append('\n');
        }
        System.out.println(sb);
    }


}
