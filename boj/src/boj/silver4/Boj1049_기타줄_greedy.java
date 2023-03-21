package boj.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1049_기타줄_greedy {

    public static void main(String[] args) throws IOException {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(brd.readLine());

        int need = Integer.parseInt(stz.nextToken());
        int brand = Integer.parseInt(stz.nextToken());

        int minSet = 1000; //세트 중 제일 싼 가격
        int minSingle = 1000; //낱개 중 제일 싼 가격

        //최저가 갱신
        for (int i = 0; i < brand; i++) {
            stz = new StringTokenizer(brd.readLine());
            int setPrice = Integer.parseInt(stz.nextToken());
            if(setPrice < minSet){
                minSet = setPrice;
            }
            int singlePrice = Integer.parseInt(stz.nextToken());
            if(singlePrice < minSingle){
                minSingle = singlePrice;
            }
        }

        //모두 세트로 사는 경우, 섞어서 사는 경우, 모두 낱개로 사는 경우를 비교
        int onlySet = (((need-1)/6) + 1) * minSet;
        int mix = ((need)/6) * minSet + (need%6) * minSingle;
        int onlySingle = need * minSingle;

        System.out.println(Math.min(onlySet, Math.min(mix, onlySingle)));

    }
}
