package boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7562_나이트의이동_bfs {

    static int l, nr, nc, gr, gc, newR, newC, size, ans;
    static boolean[][] board;
    static int[][] delta = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};
    static StringTokenizer stn;
    static Queue<Integer> move;
    static StringBuilder sbd;


    public static void main(String[] args) throws IOException {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        sbd = new StringBuilder();

        int T = Integer.parseInt(brd.readLine());

        //tc
        for (int tc = 0; tc < T; tc++) {
            l = Integer.parseInt(brd.readLine()); //체스판 크기
            board = new boolean[l][l];

            stn = new StringTokenizer(brd.readLine());
            nr = Integer.parseInt(stn.nextToken()); //현재 위치
            nc = Integer.parseInt(stn.nextToken());

            move = new LinkedList<>();
            move.add(nr);
            move.add(nc);
            board[nr][nc] = true;

            stn = new StringTokenizer(brd.readLine()); //목표 위치
            gr = Integer.parseInt(stn.nextToken());
            gc = Integer.parseInt(stn.nextToken());

            ans = 0; //정답

            //bfs
            outer : while(!move.isEmpty()){
                size = move.size();
                //cycle
                while(size > 0){
                    size -= 2;
                    nr = move.poll();
                    nc = move.poll();

                    //목적지 도착했당
                    if(nr == gr && nc == gc){
                        sbd.append(ans).append("\n");
                        break outer;
                    }
                    //도착 안했으면 이동
                    for (int i = 0; i < 8; i++) {
                        newR = nr + delta[i][0];
                        newC = nc + delta[i][1];
                        //새로운 좌표가 보드 내에 있고 아직 방문하지 않았다면
                        if(newR >= 0 && newR < l && newC >= 0 && newC < l && !board[newR][newC]){
                            board[newR][newC] = true;
                            move.add(newR);
                            move.add(newC);
                        }
                    }//이동
                }//cycle
                ans++;
            }//bfs
        }//tc
        System.out.println(sbd.toString());
    }//main
}
