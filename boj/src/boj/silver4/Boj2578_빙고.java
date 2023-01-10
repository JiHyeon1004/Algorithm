package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//빙고배열을 채운 후 숫자가 불리면 해당 칸을 0으로 만든다.
//숫자가 불릴 때마다 해당 숫자의 위치를 토대로 빙고 조건을 업데이트하고
//조건이 완성되면 빙고의 카운트를 늘린다.
//빙고의 카운트가 3 이상이 되면 답 출력
public class Boj2578_빙고 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //빙고 조건 체크
        //숫자가 하나씩 불릴 때마다 해당 열/행의 카운트를 하나씩 올린다.
        //카운트가 5가 되면 빙고의 카운트++

        int[] rowBingo = new int[5];    //가로 빙고 조건 체크
        int[] columnBingo = new int[5]; //세로 빙고 조건 체크
        int[] crossBingo = new int[2];  //대각선 빙고 조건 체크 (0번은 x=y일 때, 1번은 y=4-x일 때)
        int bingo = 0;  //완성된 빙고의 수

        //빙고 배열
        int[][] bingoMap = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingoMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //불리는 수를 체크하며 빙고도 만들어보자
        outer:
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int calledNo = Integer.parseInt(st.nextToken());
                int row = -1;
                int column = -1;
                //해당 숫자의 위치 체크
                inner:
                for (int a = 0; a < 5; a++) {
                    for (int b = 0; b < 5; b++) {
                        if (bingoMap[a][b] == calledNo) {
                            row = a;
                            column = b;
                            break inner;
                        }
                    }
                }

                //행 카운트
                rowBingo[row]++;
                bingo = rowBingo[row] == 5 ? bingo + 1 : bingo;
                //열 카운트
                columnBingo[column]++;
                bingo = columnBingo[column] == 5 ? bingo + 1 : bingo;
                //대각선 카운트
                if (row == 2 && column ==2) {
                    crossBingo[0]++;
                    bingo = crossBingo[0] == 5 ? bingo + 1 : bingo;
                    crossBingo[1]++;
                    bingo = crossBingo[1] == 5 ? bingo + 1 : bingo;
                } else if (row == column) {
                    crossBingo[0]++;
                    bingo = crossBingo[0] == 5 ? bingo + 1 : bingo;
                } else if (column == 4-row) {
                    crossBingo[1]++;
                    bingo = crossBingo[1] == 5 ? bingo + 1 : bingo;
                }

                if(bingo > 2){
                    System.out.println(5*i + j + 1);
                    break outer;
                }
            }
        }
    }
}
