package boj.silver3;

import java.util.HashSet;
import java.util.Scanner;

public class Boj11478_서로다른부분문자열의개수_hashSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        HashSet<String> seq = new HashSet<String>();

        //부분 문자열을 잘라 seq 에 넣는다.
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                seq.add(s.substring(i, j));
            }
        }
        System.out.println(seq.size()-1); //0부터0까지의 substring인 경우를 제외한다.

    }
}
