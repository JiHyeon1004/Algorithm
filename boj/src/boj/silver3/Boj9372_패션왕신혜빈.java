package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj9372_패션왕신혜빈 {
    public static void main(String[] args) throws IOException {
        //버퍼드리더로 입력받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //테스트케이스 수
        int T = Integer.parseInt(br.readLine());

        //테스트케이스만큼 돌린다.
        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> clothes = new HashMap<>();

            //옷의 개수만큼 입력받는다.
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken(); //옷의 이름은 필요 없음. 버린다.
                String type = st.nextToken(); //옷의 종류를 저장해서
                //처음 들어오는 종류라면
                if (!clothes.containsKey(type)) {
                    //clothes map에 1로 넣어주고
                    clothes.put(type, 1);
                }
                //기존에 있던 종류라면 기존 value에 1을 더해준다.
                else {
                    clothes.replace(type, clothes.get(type) + 1);
                }
            }
            //정답에 곱해주어야하므로 1로 초기화
            int ans = 1;
            //value값을 돌면서 +1 해준 후 ans에 곱해줌 (착용 안하는 경우도 있어서)
            for (int val : clothes.values()) {
                ans *= (val + 1);
            }
            //벌거벗으면 안되기 때문에 1 빼준 후 출력
            ans--;
            System.out.println(ans);
        }
    }
}
