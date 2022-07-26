package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj5567_결혼식 {
    static int friendNum; //친구의 수
    static int[][] friend; //친구 배열
    static boolean[] visited; //방문 배열
    static int[] relation; //관계 촌수?
    static int cnt; //결혼식에 초대할 사람 수

    public static void main(String[] args) throws IOException {
        //버퍼드리더로 입력받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; //스트링토크나이저

        //친구 수 입력 / 친구 배열 생성
        friendNum = Integer.parseInt(br.readLine());
        friend = new int[friendNum + 1][friendNum + 1];

        //관계의 수
        int lineNum = Integer.parseInt(br.readLine());

        //친구 배열 완성
        for (int i = 0; i < lineNum; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friend[a][b] = 1;
            friend[b][a] = 1;
        }
        //관계, 방문 배열 생성
        relation = new int[friendNum + 1];
        visited = new boolean[friendNum + 1];
        cnt = 0;
        //초대장 돌린다
        invitation(1);
        //출력
        System.out.println(cnt);
    }

    //초대장
    private static void invitation(int SG) {
        //큐 만들어서 상근이 넣고 방문처리
        Queue<Integer> queue = new LinkedList<>();
        queue.add(SG);
        visited[SG] = true;

        //큐가 빌 때까지 돌려
        while (!queue.isEmpty()) {
            int x = queue.poll(); //하나 빼내고
            //관계가 2보다 작을 때만 돌린다.
            if (relation[x] < 2) {
                //친구 탐색
                for (int j = 1; j <= friendNum; j++) {
                    if (friend[x][j] == 1 && !visited[j]) { //친구라면
                        queue.add(j); //큐에 추가하고
                        cnt++; //결혼식 인원 한 명 추가
                        relation[j] = relation[x] + 1; //관계 1 증가
                        visited[j] = true; //방문처리
                    }
                }
            }
        }
    }
}
