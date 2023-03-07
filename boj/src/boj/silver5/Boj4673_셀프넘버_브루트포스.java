package silver5;

public class Boj4673_셀프넘버_브루트포스 {
    public static void main(String[] args) {
        //셀프넘버 배열을 선언
        //완전 탐색하면서 해당 숫자를 생성자로 하는 숫자는 true로 변환시킨다.
        //false인 것이 셀프넘버
        boolean[] selfNum = new boolean[10001];

        //셀프넘버를 담아서 출력할 stringBuilder
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 10001; i++) {
            //생성자에 의해 생성된 수가 아니라면
            if (!selfNum[i]) {
                sb.append(i).append("\n"); //정답에 추가하고
                //범위 내에서 계속 생성한다.
                int idx = i; //생성자가 생성하는 수를 임시로 저장할 변수
                while (idx < 10001) {
                    //i를 생성자로 하여 (i+각 자리의 숫자)
                    int n = idx;
                    while (n > 0) {
                        idx += n % 10;
                        n /= 10;
                    }
                    if (idx < 10001) {
                        selfNum[idx] = true;

                    }
                }
            }
        }
        System.out.println(sb);
    }
}
