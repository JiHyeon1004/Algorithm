package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Boj11279_최대힙_우선순위큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //힙을 큐로 구현
        //최대힙이므로 collections의 reverseOrder 이용
        //(기본 우선순위 큐는 오름차순 정렬)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); //연산의 개수

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            switch (x) {
                //0이 입력됐다면 최댓값 poll
                case 0:
                    if (!maxHeap.isEmpty()) {
                        sb.append(maxHeap.poll()).append("\n");
                    }
                    //큐가 비어있다면 0 출력
                    else {
                        sb.append(0).append("\n");
                    }
                    break;
                //0이 아니라면 큐에 삽입
                default:
                    maxHeap.add(x);

            }
        }

        System.out.println(sb);
    }
}
