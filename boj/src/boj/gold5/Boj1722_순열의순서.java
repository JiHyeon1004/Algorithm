package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//주석처리는 시간초과, 현재 코드는 틀렸습니다..
public class Boj1722_순열의순서 {
    static int N; //주어진 수
    static int[] arr; //순열을 담을 배열
    static boolean[] check; //방문체크
    static int cnt; //몇 번째 순열인지
    static int[] findArr; //주어진 순열
    static int factorial;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        //버퍼드리더로 입력받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        //숫자 입력받아서 arr, check 배열 생성
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        check = new boolean[N];

        //명령어 쪼갠다.
        String[] cmd = br.readLine().split(" ");

        switch (Integer.parseInt(cmd[0])) {
            //명령어가 1인 경우
            case 1:
                //첫 숫자 맞춰주고 시작
                factorial = 1;
                int firstNum = Integer.parseInt(cmd[1]) / (factorial(N-1)) + 1;
                cnt = (firstNum-1) * factorial(N-1);
                check[firstNum-1] = true;
                arr[0] = firstNum;
                perm(Integer.parseInt(cmd[1]),firstNum, 1);
                break;

            //명령어가 2인 경우
            case 2:
                findArr = new int[N]; //주어진 순열을 담을 배열
                List<Integer> list = new ArrayList<>();
                //순열을 받아서 배열에 담는다.
                for (int i = 0; i < N; i++) {
                    findArr[i] = Integer.parseInt(cmd[i + 1]);
                    list.add(Integer.parseInt(cmd[i + 1]));
                }
                //첫 숫자 맞춰주고 시작
//                factorial = 1;
//                cnt = (findArr[0] - 1) * factorial(N - 1) + 1;
//                check[findArr[0] - 1] = true;
//                arr[0] = findArr[0];
//                findPerm(findArr, findArr[0], 1);
//                break;

                for(int i = 0; i < N-1; i++){
                    cnt += (list.indexOf(findArr[i])) * factorial(N-1-i) + 1;
                    list.remove(list.indexOf(findArr[i]));
                }
                System.out.println(cnt);

        }

    }

    //팩토리얼 구하는 메소드
    private static int factorial(int i) {
        if(i==0){
            return 1;
        }
        //1까지 내려왔으면 factorial 반환
        if (i == 1) {
            return factorial;
        }
        //factorial에 i를 곱해주고 1 감소시킨 값을 넣어 돌린다.
        factorial *= i;
        return factorial(i - 1);
    }

    //순열이 주어지면 몇 번째 순열인지 찾는 메소드 (cmd 2)
//    private static void findPerm(int[] findArr, int firstNum, int idx) {
//        //N까지 채웠다면
//        if (idx == N) {
//            boolean flag = true;
//            //주어진 배열과 일치하는지 확인
//            for (int i = 0; i < N; i++) {
//                //일치하지 않다면
//                if (arr[i] != findArr[i]) {
//                    flag = false; //false로 바꿔주고
//                    cnt++; //cnt올려준다.
//                    break;
//                }
//            }
//            //주어진 배열과 일치한다면
//            if (flag) {
//                //출력
//                System.out.println(cnt);
//            }
//        }
//
//
//        for (int i = 0; i < N; i++) {
//            if (!check[i]) {
//                arr[idx] = i + 1;
//                check[i] = true;
//                findPerm(findArr, firstNum, idx + 1);
//                check[i] = false;
//            }
//        }
//    }

    //숫자가 주어지면 그 숫자에 해당하는 번째의 순열을 찾는 메소드 (cmd 1)
    private static void perm(int target, int firstNum, int idx) {
        if (idx == N && cnt == target - 1) {
            for (int i = 0; i < N; i++) {
                sb.append(arr[i] + " ");
            }
            System.out.println(sb);
            cnt++;
            return;
        }

        if (idx == N) {
            cnt++;
        }

        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                arr[idx] = i + 1;
                check[i] = true;
                perm(target, firstNum, idx + 1);
                check[i] = false;
            }
        }
    }
}
