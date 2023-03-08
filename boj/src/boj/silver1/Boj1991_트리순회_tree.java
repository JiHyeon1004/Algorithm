package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1991_트리순회_tree {

    static int N;
    static int[][] tree;
    static boolean[] check;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        tree = new int[N][2]; //[][0] : 왼자, [][1] : 오자

        //트리 입력
        for (int i = 0; i < N; i++) {
            String relation = br.readLine();
            int parent = relation.charAt(0)-'A';
            for(int j = 2; j <5; j += 2){
                if(relation.charAt(j) - 'A' >= 0 && relation.charAt(j) - 'A' < 26){
                    tree[parent][j/2-1] = relation.charAt(j) - 'A';
                }else{
                    tree[parent][j/2-1] = -1;
                }
            }
        }

        check = new boolean[N];
        preorder(0, 0);
        sb.append("\n");
        check = new boolean[N];
        inorder(0,0);
        sb.append("\n");
        check = new boolean[N];
        postorder(0, 0);
        sb.append("\n");
        System.out.println(sb.toString());

    }

    //전위 순회
    static void preorder(int now, int idx){

        //본인
        sb.append("" + (char) (now+'A')); //알파벳 붙여주고
        check[now] = true; //방문처리

        //왼쪽 자식
        if(tree[now][0] != -1 && !check[tree[now][0]]){
            preorder(tree[now][0], idx+1);
        }
        //오른쪽 자식
        if(tree[now][1] != -1 && !check[tree[now][1]]){
            preorder(tree[now][1], idx+1);
        }

    }

    //중위 순회
    static void inorder(int now, int idx){

        //왼쪽 자식
        if(tree[now][0] != -1 && !check[tree[now][0]]){
            inorder(tree[now][0], idx+1);
        }
        //본인
        sb.append("" + (char) (now+'A')); //알파벳 붙여주고
        check[now] = true; //방문처리

        //오른쪽 자식
        if(tree[now][1] != -1 && !check[tree[now][1]]){
            inorder(tree[now][1], idx+1);
        }
    }

    //후위 순회
    static void postorder(int now, int idx){

        //왼쪽 자식
        if(tree[now][0] != -1 && !check[tree[now][0]]){
            postorder(tree[now][0], idx+1);
        }
        //오른쪽 자식
        if(tree[now][1] != -1 && !check[tree[now][1]]){
            postorder(tree[now][1], idx+1);
        }
        //본인
        sb.append("" + (char) (now+'A')); //알파벳 붙여주고
        check[now] = true; //방문처리
    }

}
