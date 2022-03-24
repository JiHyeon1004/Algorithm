package boj.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1260_DFS와BFS {
	static StringBuilder sb = new StringBuilder();
	static boolean[] did;
	static int[][] tree;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		tree = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			tree[a][b] = 1;
			tree[b][a] = 1;
		}

		did = new boolean[N + 1];
		DFS(V);
		sb.append("\n");
		did = new boolean[N + 1];
		BFS(V);
		System.out.println(sb.toString());

	}

	// DFS(깊이우선. 재귀함수)

	public static void DFS(int node) {

		did[node] = true;
		sb.append(node).append(" ");
//		if (node == tree.length - 1) {
//			return;
//		}
		for (int i = 0; i < tree.length; i++) {
			if (did[i] == false && tree[node][i] == 1) {
				DFS(i);
			}
		}

	}

	// 너비우선, queue
	public static void BFS(int node) {
		Queue<Integer> bfs = new LinkedList<Integer>();

		bfs.add(node);
		did[node] = true;

		sb.append(node).append(" ");

		while (!bfs.isEmpty()) {
			int tempNode = bfs.poll();

			for (int i = 0; i < tree.length; i++) {
				if (did[i] == false && tree[tempNode][i] == 1) {
					bfs.add(i);
					did[i] = true;
					sb.append(i).append(" ");

				}
			}
		}

	}

}
