package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//이분탐색 (Upper Bound)
public class Boj2805_나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //나무의 수
        int[] tree = new int[N];
        int M = Integer.parseInt(st.nextToken()); //필요한 나무 길이

        int max = 0;

        //나무들의 높이를 배열에 넣어줌
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if (tree[i] > max) {
                max = tree[i];
            }
        }

        int front = 0;
        int rear = max;
        int mid = rear / 2;

        while (front < rear) {
            mid = (front + rear) / 2;
            long sum = 0L;
            for (int i = 0; i < N; i++) {
                //주어진 높이보다 높은 나무들만 자른다.
                if (tree[i] > mid) {
                    sum += (tree[i] - mid);
                }
            }

            if (sum < M) {
                rear = mid;
            } else {
                front = mid + 1;
            }

        }

        System.out.println(rear - 1);
    }
}
