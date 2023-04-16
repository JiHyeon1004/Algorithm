package boj.silver3;

import java.util.Arrays;
import java.util.Scanner;

//백준에서는 잘 돌아가지만 IDE에서는 스택오버플로우
//IDE 돌리는 윈도우와 백준 서버가 있는 우분투의 스택 사이즈 차이 때문임

public class Boj1904_01타일 {

    static int[] tile;

    //개수가 피보나치 수열대로 증가한다.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        tile = new int[n+1];
        Arrays.fill(tile, -1); //나머지가 0일 수도 있기 때문에 -1로 초기화해줘야함

        System.out.println(getTile(n));

    }


    static int getTile(int n) {
        //n에 1이 들어올 때를 대비해서 이렇게 해줘야함.
        //미리 tile[1], tile[2]를 지정하면 안된다.
        if(n <= 2){
            return n;
        }
        if (tile[n] == -1) {
            tile[n] = (getTile(n - 1) + getTile(n - 2)) % 15746;
        }
        return tile[n];
    }
}

