package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj11652_카드 {
    public static void main(String[] args) throws IOException {
        //버퍼드리더로 입력받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //카드의 개수
        int N = Integer.parseInt(br.readLine());
        //카드의 번호와 개수를 저장할 해쉬맵
        Map<Long, Integer> card = new HashMap<>();

        //카드의 개수만큼 돌린다.
        for (int i = 0; i < N; i++) {
            //카드의 번호 입력받는다.
            long cardNum = Long.parseLong(br.readLine());
            //이전에 존재하지 않는다면 맵에 추가
            if (!card.containsKey(cardNum)) {
                card.put(cardNum, 1);
            }
            //이미 존재한다면 value를 1 증가시켜준다.
            else {
                card.replace(cardNum, card.get(cardNum) + 1);
            }
        }

        //내림차순 정렬 (같을 시에는 오름차순)
        List<Map.Entry<Long, Integer>> list_entries = new ArrayList<Map.Entry<Long, Integer>>(card.entrySet());

        //comparator 사용
        Collections.sort(list_entries, new Comparator<Map.Entry<Long, Integer>>() {

            @Override
            public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2) {

                //값이 같다면 key를 오름차순
                if (o2.getValue().equals(o1.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                //아니라면 value 내림차순
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        //첫 번째의 key값을 출력
        System.out.println(list_entries.get(0).getKey());

    }
}
