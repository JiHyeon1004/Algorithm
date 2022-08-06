package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10974_모든순열 {

    static int N;
    static int arr[];
    static boolean check[];
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {

        //버퍼드리더로 입력받는다.
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //숫자 입력
        N = Integer.parseInt(bufferedReader.readLine());
        //순열을 담을 배열과 방문체크 배열
        arr = new int[N];
        check = new boolean[N];

        //순열을 구한다.
        perm(0);

        //출력
        System.out.println(sb);

    }

    //permutation
    private static void perm(int idx) {
        //다 끝났다면
        if(idx == N){
            //sb에 ekadkfk
            for(int i = 0; i < N; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
        }
        //순열
        for(int i = 0; i < N; i++){
            if(!check[i]){
                arr[idx] = i+1;
                check[i] = true;
                perm(idx+1);
                check[i] = false;
            }
        }
    }
}
