package boj.bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10250_ACM호텔 {
    public static void main(String[] args) throws IOException {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn;
        StringBuilder sbd = new StringBuilder();

        int T = Integer.parseInt(brd.readLine());

        for (int tc = 0; tc < T; tc++) {
            stn = new StringTokenizer(brd.readLine());
            int H = Integer.parseInt(stn.nextToken());
            int W = Integer.parseInt(stn.nextToken());
            int N = Integer.parseInt(stn.nextToken());

            int num = (N-1)/H + 1;
            int floor = N%H;

            if(floor == 0){
                floor = H;
            }

            sbd.append(floor);
            if(num >= 10){
                sbd.append(num);
            }
            else{
                sbd.append("0").append(num);
            }
            sbd.append("\n");
        }

        System.out.println(sbd.toString());

    }
}
