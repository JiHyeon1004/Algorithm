package boj.silver2;

import java.util.Scanner;

public class Boj4948_베르트랑공준 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sbd = new StringBuilder();
        boolean[] nums;


        while (true) {
            int n = scanner.nextInt();
            int ans = 0;

            if (n == 0) {
                System.out.println(sbd.toString());
                break;
            }

            nums = new boolean[2*n+1];
            nums[1] = false;

            for (int i = 2; i <= 2*n; i++) {
                if (!nums[i]){
                    for (int j = 2; j*i <= 2*n ; j++) {
                        nums[j*i] = true;
                    }
                    if(i > n){
                        ans++;
                    }
                }
            }

            sbd.append(ans);
            sbd.append("\n");
        }
    }
}
