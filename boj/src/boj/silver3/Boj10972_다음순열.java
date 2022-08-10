package silver3;

import java.util.Scanner;

public class Boj10972_다음순열 {

    static StringBuilder sb = new StringBuilder(); //스트링빌더

    public static void main(String[] args) {
        //스캐너로 입력받는다.
        Scanner sc = new Scanner(System.in);
        //숫자 입력받고 배열 선언
        int N = sc.nextInt();
        int[] permArr = new int[N];

        //배열 입력받는다.
        for (int i = 0; i < N; i++) {
            permArr[i] = Integer.parseInt(sc.next());
        }

        nextPerm(permArr);
        //출력
        System.out.println(sb);
    }

    //다음 순열을 찾는 메소드
    private static void nextPerm(int[] permArr) {
        boolean flag = true;
        //오른쪽에서부터 처음으로 왼쪽보다 오른쪽 수가 더 큰 곳을 찾는다. (i)
        outer:
        for (int i = permArr.length - 1; i > 0; i--) {
            if (permArr[i - 1] < permArr[i]) {
                //오른쪽에서부터 처음으로 i보다 큰 수가 나오는 곳을 찾는다. (j)
                for (int j = permArr.length - 1; j >= i; j--) {
                    if (permArr[j] > permArr[i - 1]) {
                        //둘이 swap
                        int tmp = permArr[j];
                        permArr[j] = permArr[i - 1];
                        permArr[i - 1] = tmp;

                        //i부터 뒷쪽은 뒤집어준다.
                        int k = permArr.length - 1;
                        while (i < k) {
                            int temp = permArr[i];
                            permArr[i] = permArr[k];
                            permArr[k] = temp;
                            i++;
                            k--;
                        }

                        flag = false;
                        break outer;
                    }
                }
            }
        }
        //내림차순으로 정렬되어있었다면 -1 출력
        if (flag) {
            System.out.println("-1");
        }
        //그게 아니라면 sb에 담아준다.
        else {
            for (int i = 0; i < permArr.length; i++) {
                sb.append(permArr[i] + " ");
            }
        }
    }
}
