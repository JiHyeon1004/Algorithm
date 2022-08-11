package silver2;

import com.sun.source.doctree.SummaryTree;

import javax.sound.sampled.BooleanControl;
import java.awt.im.spi.InputMethod;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1182_부분수열의합 {

    static int N; //수열에 들어가는 수의 개수
    static long S; //더한 값이 S인 부분수열을 찾는다.
    static int[] seq; //수열을 담을 배열
    static int cnt; //조건을 만족하는 부분수열의 개수
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        //버퍼드리더로 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        seq = new int[N];
        check = new boolean[N];

        st = new StringTokenizer(br.readLine());
        //수열을 입력받는다.
        //음수인 경우도 있으므로 1000000을 더해준 값으로 저장한다.
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken()) + 1000000;
        }
        cnt = 0;
        //뽑는 개수를 넣어 part 메소드를 돌린다.
        for (int i = 1; i <= N; i++) {
            part(0, 0, i);
        }
        //출력
        // S=0 이라면 아무것도 뽑지 않는 경우도 포함되므로 하나 빼준다.

            System.out.println(cnt);


    }

    //부분수열을 구하는 메소드
    private static void part(int idx, int snum, int num) {
        //개수만큼 뽑았다면
        if (snum == num) {
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (check[i]) {
                    sum += seq[i] - 1000000;
                }
            }
            if (sum == S) {
                cnt++;
            }
        }

        for (int i = idx; i < N; i++) {
            check[i] = true;
            part(i + 1, snum + 1, num);
            check[i] = false;
        }
    }
}
