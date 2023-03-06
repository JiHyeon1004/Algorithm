package programmers;

public class Lv01_자연수뒤집어배열로만들기 {
    public int[] solution(long n) {

        String[] arr = String.valueOf(n).split("");

        int[] answer = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            answer[i] = Integer.parseInt(arr[arr.length - 1 - i]);
        }

        return answer;
    }
}
