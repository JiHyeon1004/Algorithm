package bronze1;

import java.util.Scanner;

public class Boj1259_팰린드롬수 {
	public static void main(String[] args) {
		
		//스캐너로 입력받음
		Scanner sc = new Scanner(System.in);
		//출력을 위한 스트링빌더
		StringBuilder sb = new StringBuilder();
		
		//와일문
		while(true) {
			String str = sc.nextLine(); //입력받은 값
			boolean flag = true; //팰린드롬수인지 아닌지 판단
			
			//0이 입력되면 그만한다.
			if(str.equals("0")) {
				break;
			}
			//0이 아니라면
			else {
				//쪼개서 char array로 만든 후 대칭인지 확인
				char[] arr = str.toCharArray();
				for(int i = 0; i <str.length()/2; i++) {
					//대칭이 아니라면
					if(arr[i] != arr[str.length()-1-i]) {
						flag = false; //팰린드롬수가 아님
						break;
					}
				}
				//팰린드롬수라면 yes를, 팰린드롬수가 아니라면 no를
				if(flag) {
					sb.append("yes").append("\n");
				}else {
					sb.append("no").append("\n");
				}
			}
		}
		//출력
		System.out.println(sb);
	}
}
