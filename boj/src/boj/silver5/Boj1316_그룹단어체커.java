package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1316_그룹단어체커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0; //그룹 단어의 개수

        int N = Integer.parseInt(br.readLine());

        boolean[] check;//이미 나온 알파벳인지 체크할 배열

        for (int i = 0; i < N; i++) {
            char[] word = br.readLine().toCharArray(); //단어 입력받아서 문자열배열로

            check = new boolean[30]; //이미 나온 알파벳인지 체크할 배열
            boolean isGroupWord = true; //그룹단어인지

            check[word[0] - 'a'] = true; //첫 알파벳 확인
            //두 번째 알파벳부터 앞 글자와 다르다면 이미 나온 알파벳인지 확인
            //나오지 않았다면 check 배열에 체크
            for (int j = 1; j < word.length; j++) {
                if (word[j] != word[j - 1]) {
                    if (check[word[j] - 'a']) {
                        isGroupWord = false;
                        break;
                    } else {
                        check[word[j] - 'a'] = true;
                    }
                }
            }
            //그룹단어라면 cnt 하나 올려줌
            if (isGroupWord) {
                cnt++;
            }

        }
        //출력
        System.out.println(cnt);
    }
}
