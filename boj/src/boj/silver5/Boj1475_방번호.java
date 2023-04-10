package silver5;

import java.util.Scanner;

public class Boj1475_방번호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] num = sc.nextLine().toCharArray();
        int[] plasticSet = new int[9]; //0부터 8까지의 번호만 준다. 9는 6과 합칠 것임.

        //한 숫자씩 돌면서
        for(int i = 0; i < num.length; i++){
            switch (num[i] - '0'){
                //6이나 9라면 6에 +1
                case 6:
                case 9:
                    plasticSet[6]++;
                    break;
                //이외에는 해당 숫자에 +2
                default:
                    plasticSet[num[i] - '0'] += 2;
            }
        }

        //최댓값 구하고
        int max = 0;
        for(int i = 0; i < 9; i++){
            if(plasticSet[i] > max){
                max = plasticSet[i];
            }
        }
        //최댓값이 짝수라면 나누기 2 한 만큼.
        //최댓값이 홀수라면 나누기 2 한 값에 +1
        int ans = max/2 + max%2;
        System.out.println(ans);
    }
}
