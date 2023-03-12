package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj1927_최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            String command = br.readLine();
            if(command.equals("0")){
                if(minHeap.isEmpty()){
                    sb.append("0").append("\n");
                }
                else{
                    sb.append(minHeap.poll()).append("\n");
                }
            }
            else{
                minHeap.add(Integer.parseInt(command));
            }
        }

        System.out.println(sb.toString());
    }
}
