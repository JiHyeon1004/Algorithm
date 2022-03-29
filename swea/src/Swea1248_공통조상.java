import java.util.HashSet;
import java.util.Scanner;

public class Swea1248_공통조상 {

	public static int cnt; // 서브트리의 크기
	public static int node; // 서브트리의 크기를 찾는 메소드에 들어갈 인자
	public static int nodenum; // 정점의 개수
	public static int[][] tree; // 트리 배열

	public static void main(String[] args) {

		// 스캐너로 입력받음
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder(); // 스트링빌더

		// 테스트케이스만큼 돌려주면서
		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i); // 앞에 테케 붙여주고

			int nodenum = sc.nextInt(); // 정점의 개수
			int edgenum = sc.nextInt(); // 간선의 개수
			int firstnum = sc.nextInt(); // 주어지는 숫자 중 첫 번째
			int secondnum = sc.nextInt(); // 주어지는 숫자 중 두 번째

			// 트리배열 만들어준다.
			tree = new int[nodenum + 1][2];

			// 트리배열 채워줌
			for (int j = 0; j < edgenum; j++) {
				int parent = sc.nextInt();
				if (tree[parent][0] == 0) { // 자식이 하나도 채워져있지 않다면
					tree[parent][0] = sc.nextInt(); // 0번에 채워주고
				} else { // 자식이 존재한다면
					tree[parent][1] = sc.nextInt(); // 1번에 채워준다.
				}
			}

			// firstnum의 조상 찾아서 hashset에 넣어주기
			HashSet<Integer> ancestor = new HashSet<>(); // 셋 만들어준다.
			while (firstnum != 1) { // 루트에 도달하기 전까지
				for (int j = nodenum; j >= 1; j--) { // j를 부모자리에 넣었을 때 firstnum이 자식인지 확인
					if (tree[j][0] == firstnum || tree[j][1] == firstnum) { // 자식이라면
						ancestor.add(j); // 해쉬셋에 부모를 넣어주고
						firstnum = j; // 부모로 관점을 바꾼다.
						break; // 포문 깨줌
					}
				}
			}
			int commonparent = 0;
			// secondnum의 조상 찾으면서 hashset과 비교
			outer: while (secondnum != 1) { // 루트에 도달하기 전까지
				for (int j = nodenum; j >= 1; j--) { // j를 부모자리에 넣었을 때 secondnum이 자식인지 확인
					if (tree[j][0] == secondnum || tree[j][1] == secondnum) { // 자식이라면
						if (ancestor.contains(j)) { // ancestor set이 j를 포함하는지 확인
							// 포함한다면
							commonparent = j; // 가장 작은 공통조상을 찾았다!
							break outer; // 끝내버려
						}
						// ancestor가 j를 포함하지 않는다면
						// 공통조상이 아님
						secondnum = j; // 관점을 j로 바꾸고
						break; // 포문 깨줌
					}
				}
			}

			// 서브트리의 크기
			cnt = 1; // 처음 시작하는 노드도 세어주기 위해서 1로 초기화
			subtree(commonparent); // 공통조상을 넣어서 subtree의 크기를 구해준다.

			// 스트링빌더에 공통조상과 서브트리의 크기 넣어줌
			sb.append(" ").append(commonparent).append(" ").append(cnt).append('\n');

		}
		// 출력
		System.out.println(sb.toString());
	}

	// 서브트리의 크기를 구하는 메서드
	public static void subtree(int node) {

		// 자식이 두 개가 다 존재할 때
		if (tree[node][1] != 0) {
			cnt += 2; // 자식의 수 2개 플러스
			subtree(tree[node][0]); // 뿌려줘~
			subtree(tree[node][1]); // 뿌려줘~
		}
		// 자식이 하나만 존재할 때
		else if (tree[node][0] != 0 && tree[node][1] == 0) {
			cnt++; // 자식의 수 1개 플러스
			subtree(tree[node][0]); // 뿌려줘~
		}

	}

}
