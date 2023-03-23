//처음에는 리스트로 만들어서 구현했는데
//효율성에서 시간초과
//배열이 검색 성능이 더 좋으므로 배열로 변경했음
package programmers.Lv02;

import java.util.Arrays;

public class Lv02_구명보트_greedy {
    //먼저 리스트로 만들어서 정렬을 할거야
    //뒤에서부터 빼는데
    //맨 앞 (최소 몸무게) 과 합해서
    //무게 제한에 걸리지 않는다면 둘이 같이 탑승
    //무게 제한에 걸린다면 뒤에만 혼자 탑승
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int lightIdx = 0;
        int heavyIdx = people.length - 1;

        while (lightIdx < heavyIdx) {
            if (people[lightIdx] + people[heavyIdx] <= limit) {
                lightIdx++;
                heavyIdx--;
            } else {
                heavyIdx--;
            }
            answer++;
        }

        answer += (lightIdx == heavyIdx) ? 1 : 0; //하나 남았을 경우 더해줌
        return answer;
    }
}
