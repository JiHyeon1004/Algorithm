package boj.silver5;

import java.util.Scanner;

public class Boj1343_폴리오미노 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String board = scanner.next() + "."; //마지막에 끝내는 부분을 추가
        StringBuilder sbd = new StringBuilder(); //출력할 답

        int linked = 0; //연결된 x의 개수

        for (char c : board.toCharArray()) {
            //x라면 linked 추가
            if (c == 'X') {
                linked++;
            }
            //.이라면
            else {
                //홀수개이면 덮을 수 없으므로 -1을 출력하고 끝낸다.
                if (linked % 2 == 1) {
                    System.out.println("-1");
                    return;
                }
                //짝수개라면 덮을 수 있다.
                else {
                    sbd.append("AAAA".repeat(linked / 4)); //4칸짜리
                    sbd.append("B".repeat(linked % 4)); //2칸짜리
                    sbd.append(".");
                }
                linked = 0;
            }
        }


        //마지막 . 은 지우고 출력
        System.out.println(sbd.toString().substring(0, sbd.length() - 1));

    }
}
