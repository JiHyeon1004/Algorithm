package programmers.Lv02;

import java.util.HashSet;

public class Lv02_영어끝말잇기 {

    public int[] solution(int n, String[] words) {

        HashSet<String> wordSet = new HashSet<>();

        int person = 0; //몇 번째 사람인지
        int cycle = 1; //몇 번째 순환인지
        int wordIdx = 0; //몇 번째 단어인지
        Character lastAlphabet = words[0].charAt(0); //끝 알파벳

        while (wordIdx < words.length) {
            //규칙에 위배된다면
            if (wordSet.contains(words[wordIdx]) || lastAlphabet != words[wordIdx].charAt(0)) {
                return new int[]{(person % n) + 1, cycle};
            }
            //위배되지 않는다면
            else {
                wordSet.add(words[wordIdx]); //set에 추가
                lastAlphabet = words[wordIdx].charAt(words[wordIdx].length() - 1); //끝 알파벳 갱신
                person++; //다음 사람
                wordIdx++; //다음 단어
                if (person % n == 0) {
                    cycle++;
                }
            }
        }
        //탈락자가 없으면
        return new int[]{0, 0};

    }
}
