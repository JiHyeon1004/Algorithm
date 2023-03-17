package boj.silver5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Boj3135_라디오_greedy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt(); //현재 주파수
        int B = scanner.nextInt(); //목표 주파수
        int N = scanner.nextInt(); //즐겨찾기 개수
        List<Integer> frequency = new ArrayList<>(); //즐겨찾기 목록
        for (int i = 0; i < N; i++) {
            frequency.add(scanner.nextInt());
            if(frequency.get(i) == B){ //목적지로 바로 이동할 수 있다면 1 뱉자
                System.out.println(1);
                return;
            }
        }
        frequency.add(B); //B와 가장 가까운 주파수를 찾아 비교하기 위해 B를 추가
        frequency.add(-10001); //B가 가장 작은 경우를 대비
        frequency.add(2000); //B가 가장 클 경우를 대비
        Collections.sort(frequency); //정렬

        int positionB = frequency.indexOf(B); //B의 인덱스
        //B 앞 뒤 원소 중 B와 가까운 것을 고른다.
        //(채널을 1개씩 몇 번 넘겨야되는지 + 해당 즐겨찾기로 이동하는데 필요한 횟수인 1)
        int step = Math.min(B - frequency.get(positionB-1), frequency.get(positionB+1)-B) + 1;

        //A와 B의 차와 step을 비교해서 출력
        System.out.println(Math.min(Math.abs(A-B), step));
    }
}
