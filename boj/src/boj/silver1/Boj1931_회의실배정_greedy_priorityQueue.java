package boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1931_회의실배정_greedy_priorityQueue {
    //활동 선택 문제!
    //최대한 많은 활동을 하려면
    //종료 시간으로 정렬해야한다!
    public static void main(String[] args) throws IOException {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn;
        int N = Integer.parseInt(brd.readLine());
        int ans = 0;
        int full = 0; //몇 시까지 회의가 차있는지

        PriorityQueue<Conference> timeTable = new PriorityQueue<>();

        //회의 정보 큐에 넣는다.
        for (int i = 0; i < N; i++) {
            stn = new StringTokenizer(brd.readLine());
            Conference newConf = new Conference(Integer.parseInt(stn.nextToken()), Integer.parseInt(stn.nextToken()));
            timeTable.add(newConf);
        }


        //회의 시간 배정
        while (!timeTable.isEmpty()) {
            if (timeTable.peek().start < full) {
                timeTable.poll();
                continue;
            }
            else {
                ans++;
                full = timeTable.poll().end;
            }
        }

        System.out.println(ans);


        PriorityQueue<Integer> test = new PriorityQueue<>(Collections.reverseOrder());
        test.add(3);
        test.add(5);
        test.add(1);

        while(!test.isEmpty()){
            System.out.println(test.poll());
        }


    }


    public static class Conference implements Comparable<Conference>{
        int start, end;

        public Conference(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Conference o) {

            //종료 시간이 같다면 시작 시간이 빠른 순 (오름차순)
            if(this.end == o.end){
                return this.start - o.start;
            }

            return this.end - o.end;
        }
    }

}
