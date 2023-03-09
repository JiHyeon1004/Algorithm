package silver5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Boj1251_단어나누기 {

    static String word;
    static int[] slash;
    static List<String> wordList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        word = scanner.next(); //주어진 단어

        slash = new int[2];

        wordList = new ArrayList<>();

        findSlash(0, 0);

        Collections.sort(wordList);

        System.out.println(wordList.get(0));
    }

    //끊는 지점 찾기
    //idx까지 포함해서 끊는다. -> idx는 word.length()-1 까지여야함.
    public static void findSlash(int sidx, int idx) {
        if (sidx == 2) {
            newWord(slash[0], slash[1]);
        }
        else if (idx == word.length() - 1) {
            return;
        } else {
            //뽑고 가고
            slash[sidx] = idx;
            findSlash(sidx + 1, idx + 1);
            //안 뽑고 가고
            findSlash(sidx, idx + 1);

        }
    }

    //단어를 끊어서 재조합
    public static void newWord(int slash1, int slash2) {

        StringBuilder sb = new StringBuilder();

        String first = sb.append(word.substring(0, slash1 + 1)).reverse().toString(); //첫 단어
        sb.delete(0, sb.length());
        String mid = sb.append(word.substring(slash1 + 1, slash2 + 1)).reverse().toString(); //중간 단어
        sb.delete(0, sb.length());
        String last = sb.append(word.substring(slash2 + 1)).reverse().toString(); //마지막 단어

        wordList.add(first + mid + last);

    }
}
