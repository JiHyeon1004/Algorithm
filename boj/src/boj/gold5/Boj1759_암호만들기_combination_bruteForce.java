package boj.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//L개를 뽑는 조합을 만든 후 조건에 맞는지 확인한다.
public class Boj1759_암호만들기_combination_bruteForce {

    static int L, C;

    static String[] vowel = {"a", "e", "i", "o", "u"}; //모음배열

    static String[] alphabet, pwd; //주어진 알파벳과 조합을 담을 pwd배열
    static StringBuilder sbd = new StringBuilder();

    //main
    public static void main(String[] args) throws IOException {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(brd.readLine());

        L = Integer.parseInt(stn.nextToken());
        C = Integer.parseInt(stn.nextToken());

        pwd = new String[L];
        alphabet = new String[C];

        //주어진 알파벳 정보 저장
        stn = new StringTokenizer(brd.readLine());
        for (int i = 0; i < C; i++) {
            alphabet[i] = stn.nextToken();
        }

        Arrays.sort(alphabet); //오름차순으로 정렬
        getPwd(0, 0);

        System.out.println(sbd.toString()); //출력
    }


    //조합
    static void getPwd(int idx, int sidx) {
        //다 만들었으면 조건에 맞는지 검사
        //한 개의 모음과 두 개의 자음이 조건이므로
        //모음의 개수가 1 이상이고 L-2 이하이면 조건 통과
        if (sidx == L) {
            int vowelN = 0; //모음 개수
            for (String a : pwd) {
                for (String v : vowel) {
                    if (a.equals(v)) {
                        vowelN++;
                    }
                }
            }
            if (vowelN > 0 && vowelN < L - 1) {
                for (String a : pwd) {
                    sbd.append(a);
                }
                sbd.append("\n");
            }
            return;
        }

        //다 돌았으면 끝내
        if (idx == C) {
            return;
        }

        //아직 다 안 돌았으면
        else {
            //뽑고가고
            pwd[sidx] = alphabet[idx];
            getPwd(idx + 1, sidx + 1);
            //안뽑고 가고
            getPwd(idx + 1, sidx);
        }

    }
}
