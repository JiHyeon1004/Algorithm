package programmers;

import java.util.Arrays;

class 정렬_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        
        answer = new int[commands.length];
        
        //명령이 들어오는 만큼 돌린다.
        for(int i = 0; i < commands.length; i++){
            //범위 내 배열의 길이 저장
			int newArrLength = commands[i][1]-commands[i][0] + 1 ;
            //범위 내의 배열을 담을 새로운 배열
			int[] newArr = new int[newArrLength];
			//범위 내의 배열을 새로운 배열에 담아 저장해줌.
			
			for(int k = 0; k < newArrLength; k++) {
				newArr[k] = array[commands[i][0] - 1 + k];
			}
            //범위 내 배열 정렬
			Arrays.sort(newArr);
            //명령이 들어온 번째에 해당하는 수를 answer배열에 저장
            answer[i] = newArr[commands[i][2] - 1];
		}

        
        return answer;
    }
}