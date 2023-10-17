package boj.silver3;

import java.util.LinkedList;
import java.util.Scanner;

public class Boj1021_회전하는큐 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); //큐의 크기
        int M = scanner.nextInt(); //뽑아내려고 하는 수의 개수
        int ans = 0;

        LinkedList<Integer> deq = new LinkedList<Integer>();

        //1~N까지 deq에 담아둠.
        for (int i = 1; i <= N; i++) {
            deq.offer(i);
        }

        int[] nums = new int[M];

        for (int i = 0; i < M; i++) {
            nums[i] = scanner.nextInt();
        }

        for (int i = 0; i < M; i++) {
            int target = deq.indexOf(nums[i]);
            int half_idx; //덱의 중간 지점
            //덱의 사이즈가 짝수라면
            if(deq.size() % 2 == 0){
                half_idx = deq.size()/2 - 1;
            }
            //홀수라면
            else{
                half_idx = deq.size()/2;
            }

            //타깃이 중간에 있거나 그 앞에 위치한 경우
            //2번 연산 수행
            if(target <= half_idx){
                for (int j = 0; j < target; j++) {
                    int tmp = deq.pollFirst();
                    deq.offerLast(tmp);
                    ans++;
                }
            }
            //타깃이 뒷쪽에 있을 경우
            //3번 연산 수행
            else{
                for (int j = 0; j < deq.size() - target; j++) {
                    int tmp = deq.pollLast();
                    deq.offerFirst(tmp);
                    ans++;
                }
            }
            //target을 뽑는다.
            deq.pollFirst();
        }

        System.out.println(ans);

    }
}
