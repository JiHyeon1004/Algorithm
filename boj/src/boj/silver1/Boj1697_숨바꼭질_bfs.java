package boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1697_숨바꼭질_bfs {

    public static void main(String[] args) throws IOException {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(brd.readLine());
        int subin = Integer.parseInt(stn.nextToken()); //수빈이 처음 위치
        int sister = Integer.parseInt(stn.nextToken()); //동생의 위치 (목적지)
        boolean[] checked = new boolean[100002]; //이미 도달한 위치인지 확인용
        int time = 0; //소요된 시간

        Queue<Integer> moving = new LinkedList<>(); //움직이며 위치들을 큐에 넣겠다.
        moving.add(subin);
        checked[subin] = true;

        //bfs
        while (!moving.isEmpty()) {
            int cycle = moving.size();
            while (cycle>0) {
                cycle--;
                int now = moving.poll();
                //동생을 찾았으면 정답 뱉고 반환
                if(now == sister){
                    System.out.println(time);
                    return;
                }
                //아직 못 찾았다.
                else{
                    //위치는 0이상, 100000이하이다.
                    if(now > 0 && !checked[now-1]){
                        moving.add(now-1);
                        checked[now-1] = true;
                    }
                    if(now <= 50000 && !checked[2*now]){
                        moving.add(2*now);
                        checked[2*now] = true;
                    }
                    if(now <= 99999 && !checked[now+1]){
                        moving.add(now+1);
                        checked[now+1] = true;
                    }
                }
            }
            time++;
        }//bfs
    }//main
}
