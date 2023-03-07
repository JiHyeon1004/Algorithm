package programmers;

import java.util.Arrays;

public class Lv02_최댓값과최솟값 {

    public String solution(String s) {

        String[] str = s.split(" ");
        int[] arr = new int[str.length];

        for(int i = 0; i < str.length; i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

        String answer = arr[0] + " " + arr[arr.length-1];
        return answer;
    }


    //stream을 사용한 풀이

    //앞 과정을 동일하게 마친 후 배열을 정렬하지 않고 stream으로 최대, 최소를 뽑는다.
    // StringBuffer sb = new StringBuffer();
    //        sb.append(Arrays.stream(arr).min().getAsInt());
    //        sb.append(" ");
    //        sb.append(Arrays.stream(arr).max().getAsInt());

    //근데 그냥 간단하게로는 배열 채워넣으면서 max, min 조사해도 됨.
}
