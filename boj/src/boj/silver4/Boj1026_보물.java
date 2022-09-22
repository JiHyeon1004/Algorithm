package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj1026_보물 {

    //큰 수 일수록 작은 수와 곱해져야 할 것 같음
    //A의 오름차순과 B의 내림차순을 순서대로 곱해서 더해주면 되겠다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A); //A는 오름차순
        Arrays.sort(B, Collections.reverseOrder()); //B는 내림차순

        //답
        int ans = 0;

        //돌면서 곱한 값을 더해줌
        for (int i = 0; i < N; i++) {
            ans += A[i] * B[i];
        }

        //출력
        System.out.println(ans);

    }

}
