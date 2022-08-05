package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1389_케빈베이컨의6단계법칙 {

    static int N; //유저의 수
    static int[][] friend; //친구관계를 나타내는 배열
    static boolean[] check; //방문체크
    static int[][] relation; //행에 따른 열의 관계 정보를 나타내는 배열
    static Integer[] KB; //케빈베이컨의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        friend = new int[N + 1][N + 1];
        relation = new int[N + 1][N + 1];
        KB = new Integer[N + 1];
        KB[0] = 0;

        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friend[a][b] = 1;
            friend[b][a] = 1;
        }

        for (int i = 1; i < N + 1; i++) {
            check = new boolean[N + 1];
            bfs(i);
            KB[i] = 0;
            for (int j = 1; j < N + 1; j++) {
                KB[i] += relation[i][j];
            }
        }

        int min = M*N;
        int ans = 0;
        for(int i = 1; i < N+1; i++){
            if(KB[i] < min){
                min = KB[i];
                ans = i;
            }
            else if(KB[i] == min){
                ans = Math.min(i, ans);
            }
        }
        System.out.println(ans);


//        Arrays.sort(KB, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if (o2.equals(o1)) {
//                    return o1.compareTo(o2);
//                }
//                return o1 - o2;
//            }
//        });

    }

    private static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int cnt = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (cnt < N) {
                for (int i = 1; i < N + 1; i++) {
                    if (friend[i][x] == 1 && !check[i]) {
                        queue.add(i);
                        if (relation[n][i] == 0) {
                            relation[n][i] = relation[n][x] + 1;
                            cnt++;
                        }

                    }
                }

            }
        }
    }
}
