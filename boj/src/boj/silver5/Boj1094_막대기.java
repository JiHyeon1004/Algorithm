package silver5;

import java.util.Scanner;

public class Boj1094_막대기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt(); //원하는 길이

        double stickLength = 64;
        int stickNum = 1;
        double shortest = 64;

        while(stickLength > x){
            stickNum++;
            shortest /= 2;

            if(stickLength-shortest > x || stickLength-shortest == x){
                stickNum--;
                stickLength -= shortest;
            }

        }

        System.out.println(stickNum);


    }
}
