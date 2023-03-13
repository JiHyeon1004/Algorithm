package boj.silver1;

import java.util.*;

//처음 제출 시 틀렸음
//틀린 이유 : 맨 처음 단지를 시작할 때 방문체크를 안해서 ㅎ (40번라인)
//잘하자,,
public class Boj2667_단지번호붙이기_DFS {
    static List<Integer> num; //한 단지 당 가구 수를 저장하는 배열
    static int N;
    static int[][] map; //지도
    static boolean[][] check; //방문체크
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int houseN; //단지 내 가구 수


    public static void main(String[] args) {
        num = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        //지도 완성
       map = new int[N+2][N+2]; //겉은 0으로 둘러쌀거야
       check = new boolean[N+2][N+2];
        for (int i = 1; i < N+1; i++) {
            String[] str = scanner.next().split("");
            for (int j = 1; j < N+1; j++) {
                map[i][j] = Integer.parseInt(str[j-1]);
            }
        } //지도 완성


        //지도를 돌면서 1이고 방문하지 않았다면 dfs를 돌려 단지를 조사한다.
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if(map[i][j] == 1 && !check[i][j]){
                    houseN = 1;
                    check[i][j] = true;
                    dfs(i,j);
                    num.add(houseN); //단지 내 가구 수를 리스트에 추가
                }
            }
        } //단지 조사

        Collections.sort(num); //리스트 정렬

        //출력
        System.out.println(num.size()); //단지 수
        for(int i = 0; i < num.size(); i++){
            System.out.println(num.get(i)); //단지 내 가구 수
        }

    }

    //dfs
    public static int dfs(int r, int c){

        //사방탐색
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i]; //새로운 행
            int nc = c + dc[i]; //새로운 열

            if(map[nr][nc] == 1 && !check[nr][nc]){
                check[nr][nc] = true;
                houseN++;
                dfs(nr, nc);
            }
        }
        return houseN;
    }
}
