package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1543_문서검색_replace사용 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        int originLength = document.length();
        String word = br.readLine();

        String newDoc = document.replaceAll(word, "");


        int newLength = newDoc.length();
        int ans = (originLength-newLength)/word.length();

        System.out.println(ans);

    }
}
