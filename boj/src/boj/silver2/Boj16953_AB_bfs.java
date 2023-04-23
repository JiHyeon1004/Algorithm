package boj.silver2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj16953_AB_bfs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long A = scanner.nextInt();
        long B = scanner.nextInt();
        long ans = 1L;

        //큐를 이용해 두 개의 연산을 각각 진행
        Queue<Long> toB = new LinkedList<>();
        toB.add(A);
        toB.add(-1L); //사이클 구분용

        while(!toB.isEmpty()){
            long now = toB.poll();

            //사이클 돌았다.
            if(now == -1 && !toB.isEmpty()){
                ans++;
                toB.add(-1L);
            }
            //실패
            else if(now == -1 && toB.isEmpty()){
                System.out.println(-1);
                return;
            }
            //찾았다.
            else if(now == B){
                System.out.println(ans);
                return;
            }
            else{
                if(2*now <= B){
                    toB.add(2*now); //2를 곱한다.
                }
                if(10*now+1 <= B){
                    toB.add(10*now+1); //1을 수의 맨 오른쪽에 추가한다.
                }
            }
        }

    }
}
