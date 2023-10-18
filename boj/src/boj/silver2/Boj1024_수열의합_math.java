package boj.silver2;

import java.util.Scanner;

public class Boj1024_수열의합_math {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); //합
        int L = scanner.nextInt(); //길이
        
        int start = N/L + L; //여기서부터 밑으로 내려가면서 더한다.


        for (int i = start; i > 0; i--) {
            int count = 0; //count가 100을 초과한다면 -1을 출력한다.
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += j; //더해줘!
                count++;
                //길이가 100을 초과한다면 -1 출력하고 끝내자
                if(count > 100){
//                    System.out.println("초과해");
                    System.out.println(-1);
                    return;
                }
                //sum이 N을 넘어간다면 continue;
                else if (sum > N) {
                    break;
                }
                //정답을 찾았다면
                //수열을 출력한다.
                else if (count >= L && sum == N){
                    for (int k = 0; k < count; k++) {
                        System.out.print(j + " ");
                        j++;
                    }
                    return;
                }
            }
        }

        //다 아니면 -1출력
        System.out.println(-1);
        
    }
}
