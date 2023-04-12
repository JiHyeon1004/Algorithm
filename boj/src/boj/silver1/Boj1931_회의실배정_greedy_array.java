package boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj1931_회의실배정_greedy_array {
    //활동 선택 문제!
    //최대한 많은 활동을 하려면
    //종료 시간으로 정렬해야한다!
    public static void main(String[] args) throws IOException {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn;
        int N = Integer.parseInt(brd.readLine());
        int ans = 0;
        int full = 0; //몇 시까지 회의가 차있는지

        int[][] timeTable = new int[N][2];

        //회의 정보 큐에 넣는다.
        for (int i = 0; i < N; i++) {
            stn = new StringTokenizer(brd.readLine());
            timeTable[i][0] = Integer.parseInt(stn.nextToken());
            timeTable[i][1] = Integer.parseInt(stn.nextToken());
        }

        //종료 시간을 기준으로 정렬한다.
        Arrays.sort(timeTable, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                //종료 시간이 같다면 시작 시간 빠른 순으로 (오름차순)
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[1];
                }
                //종료 시간이 빠른 순으로 (오름차순)
                return o1[1] - o2[1];
            }
        });

        //회의 시간 배정
        for (int i = 0; i < N; i++) {
            if (timeTable[i][0] < full) {
                continue;
            }
            else {
                ans++;
                full = timeTable[i][1];
            }
        }

        System.out.println(ans);

    }

}
