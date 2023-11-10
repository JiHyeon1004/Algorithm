package bronze1;

//아홉 명 중 일곱 명이면 두 명이 제외이므로
//두 명을 선택하여 전체에서 제외한 것이 100이 되면 정답임

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Boj2309_일곱난쟁이_bruteForce {

    static int[] hobbit9;
    static int[] notReal;
    static List<Integer> isReal;
    static int targetHeight;
    static boolean alreadyFound;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        hobbit9 = new int[9]; //9명의 키 배열
        notReal = new int[2]; //제외시킬 것의 인덱스를 담을 배열
        isReal = new ArrayList<>(); //진짜만 담는 리스트
        int wholeHeight = 0; //전체 키 합

        for (int i = 0; i < 9; i++) {
            hobbit9[i] = scanner.nextInt();
            wholeHeight += hobbit9[i];
        }

        //두 명을 뽑아서 targetHeight만큼이면 정답
        targetHeight = wholeHeight - 100;

        //이미 정답이 나왔는지 확인
        alreadyFound = false;

        comb(0, 0);

        //정렬 후 출력
        Collections.sort(isReal);
        for (int height : isReal) {
            System.out.println(height);
        }
    }

    //조합 후 검사
    public static void comb(int sIdx, int idx) {
        if (alreadyFound) { //이미 찾았으면 패스
            return;
        }
        if (sIdx == 2) { //다 뽑았으면
            int sum = 0;
            for (int i = 0; i < 2; i++) {
                sum += hobbit9[notReal[i]];
            }
            //찾았다
            if (sum == targetHeight) {
                alreadyFound = true;
                for (int i = 0; i < 9; i++) {
                    if (i != notReal[0] && i != notReal[1]) {
                        isReal.add(hobbit9[i]);
                    }
                }
            }
            return;
        }
        if (idx == 9) {
            return;
        }

        //뽑고 가고
        notReal[sIdx] = idx;
        comb(sIdx + 1, idx + 1);
        //안 뽑고 가고
        comb(sIdx, idx + 1);
    }
}
