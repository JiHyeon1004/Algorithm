package programmers.Lv02;

public class Lv02_숫자의표현 {

    //나의 풀이
    //수학적으로 풀고싶었다.
    public int solution(int n) {
        int answer = 1; //자기 자신만 있는 경우가 무조건 존재하므로

        //n이 1일 경우 바로 1 리턴;
        if (n == 1) {
            return answer;
        }

        //연속한 자연수의 최대 개수를 구해보자
        //1부터 합을 누적했을 때, 그 합이 n보다 커진다면 연속한 자연수의 개수는 해당 개수보다 작다.
        int[] sum = new int[n + 1]; //index까지 누적합의 결과
        int s = 0; //최대 개수 + 1
        while (true) {
            s++;
            sum[s] = sum[s - 1] + s;
            if (sum[s] > n) {
                break;
            }
        }

        int i = s - 1; //연속한 자연수의 최대 개수

        //i개의 연속한 자연수로 이루어져있다면
        //시작하는 수를 a라고 했을 때
        // n == a*i + sum[i]
        //위 식을 만족한다면 answer 증가

        while (i > 1) {
            if ((n - sum[i]) == ((n - sum[i]) / i) * i) {
                answer++;
            }
            i--;
        }

        return answer;
    }



    //다른 사람 풀이
    //'주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다'
    //라는 정수론 정리가 있다....
    //이게 더 수학적이네...하지만 난 몰랐지 ㅎㅅㅎ

    public int expressions(int num) {
        int answer = 0;
        for (int i = 1; i <= num; i += 2)
            if (num % i == 0)
                answer++;

        return answer;
    }

}
