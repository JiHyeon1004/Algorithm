package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1157_단어공부 {
	public static void main(String[] args) throws IOException {
		//문자열을 대문자 혹은 소문자로 변환하고 싶다면
		//String 클래스의 toUpperCase() / toLowerCase() 사용
		
		//버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력받은 문자열을 모두 대문자로 바꾸어줌
		String word = br.readLine().toUpperCase();
		//알파벳의 횟수를 저장할 배열
		//알파벳은 모두 26개임
		int[] count = new int[26];
		
		//문자열의 문자를 
		for(int i = 0; i < word.length(); i++) {
			count[word.charAt(i) - 'A']++;
		}
		
		int max = 0;
		char ans = ' ';
		for(int i = 0; i < 26; i++) {
			if(count[i] > max) {
				max = count[i];
				ans = (char)(i+'A');
			}
			else if(count[i] == max)
				ans = '?';
		}
		
		System.out.println(ans);
	}
}
