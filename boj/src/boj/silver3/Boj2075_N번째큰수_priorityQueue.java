package boj.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj2075_N번째큰수_priorityQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn;

        int N = Integer.parseInt(brd.readLine());
        PriorityQueue<Integer> nums = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            stn = new StringTokenizer(brd.readLine());
            for (int j = 0; j < N; j++) {
                nums.add(Integer.parseInt(stn.nextToken()));
            }
        }

        for (int i = 0; i < N - 1; i++) {
            nums.poll();
        }

        System.out.println(nums.poll());
    }
}
