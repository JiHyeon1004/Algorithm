package boj.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj13305_주유소_greedy {
    public static void main(String[] args) throws IOException {
        //다음 도시와 비교하여 현재 기름값이 더 비싸다면
        //다음 도시로 갈 만큼만 구매
        //현재가 더 싸다면
        //더 싼 곳이 나올 때까지 구매

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int cityNum = Integer.parseInt(bufferedReader.readLine()); //도시의 개수
        long[] distance = new long[cityNum - 1];
        long[] price = new long[cityNum];

        //도시 별 거리
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Long.parseLong(stringTokenizer.nextToken());
        }

        //도시 별 주유소 가격
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < price.length; i++) {
            price[i] = Long.parseLong(stringTokenizer.nextToken());
        }

        //주유시작
        long priceNow = price[0]; //현재 주유가
        long sum = 0; //총 주유비

        for (int i = 0; i < cityNum - 2; i++) {
            if (priceNow > price[i + 1]) {
                sum += priceNow * distance[i];
                priceNow = price[i + 1];
            }
            else{
                sum += priceNow * distance[i];
            }
        }

        //마지막 도시로 가는 길
        sum += priceNow * distance[cityNum-2];

        System.out.println(sum);

    }
}
