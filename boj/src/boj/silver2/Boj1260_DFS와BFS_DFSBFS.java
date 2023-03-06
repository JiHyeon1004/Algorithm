package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1260_DFS와BFS_DFSBFS {

    static int N; //정점의 개수
    static int M; //간선의 개수

    static boolean[][] graph; //그래프 정보를 담을 배열

    static boolean[] visited; //방문체크
    static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //정점 개수
        M = Integer.parseInt(st.nextToken()); //간선 개수
        int V = Integer.parseInt(st.nextToken()); //시작할 정점 번호

        graph = new boolean[N + 1][N + 1]; //정점들과의 관계
        visited = new boolean[N + 1]; //방문체크

        //그래프 채운다.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = true;
            graph[b][a] = true;
        }

        stringBuilder = new StringBuilder();

        DFS(V);
        stringBuilder.append("\n"); //한 줄 띄고
        Arrays.fill(visited, false); //방문체크 초기화
        BFS(V);

        //출력
        System.out.println(stringBuilder);
    }


    //깊이 우선 탐색
    public static void DFS(int point) {
        stringBuilder.append(point).append(" ");

        visited[point] = true;

        for (int i = 1; i < N + 1; i++) {
            if (graph[point][i] && !visited[i]) {
                DFS(i);
            }
        }
        return;
    }

    //너비 우선 탐색
    public static void BFS(int point){
        Queue<Integer> queue = new LinkedList<>();
        visited[point] = true;

        queue.add(point);

        while(!queue.isEmpty()){
            int polled = queue.poll();

            stringBuilder.append(polled).append(" ");

            for (int i = 0; i <= N; i++) {
                if (graph[polled][i] && !visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
