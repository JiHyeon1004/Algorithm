package programmers;

import java.util.Arrays;

public class Lv02_최솟값만들기 {
    class Solution
    {
        public int solution(int []A, int []B)
        {
            Arrays.sort(A);
            Arrays.sort(B);

            int answer = 0;
            for(int i = 0; i < A.length; i++){
                answer += A[i] * B[A.length - i - 1];
            }

            return answer;
        }
    }
}
