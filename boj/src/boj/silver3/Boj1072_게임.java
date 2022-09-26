package silver3;

import java.math.BigInteger;
import java.util.Scanner;

public class Boj1072_게임 {

    //현재의 승률을 구하고 승률에 1 더한 값이 나오기 위해서는 몇 판을 더 해야하는지 구한다.
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BigInteger entire = new BigInteger(sc.next());
        BigInteger firstEntire = entire;
        BigInteger win = new BigInteger(sc.next());
        BigInteger percent = win.multiply(BigInteger.valueOf(100)).divide(entire);


        //승률이 이미 99퍼 이상이라면 더 이상 올릴 수 없다.
        if (percent.compareTo(BigInteger.valueOf(99)) >= 0) {
            System.out.println("-1");
        } else {

            //이분탐색 (Lower Bound)
            BigInteger end = new BigInteger("100000000000");

            while (entire.compareTo(end) < 0) {
                BigInteger mid = entire.add(end).divide(BigInteger.valueOf(2));
                BigInteger gap = mid.subtract(firstEntire);

                if (win.add(gap).multiply(BigInteger.valueOf(100)).divide(mid).equals(percent)) {
                    entire = mid.add(BigInteger.valueOf(1));
                } else {
                    end = mid;
                }

            }

            System.out.println(entire.subtract(firstEntire));
        }

    }
}
