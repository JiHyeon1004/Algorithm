package boj.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Boj25192_인사성밝은곰곰이_hashSet {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        HashSet<String> hello = new HashSet<>();
        int ans = 0;

        for (int i = 0; i < N; i++) {
            String name = bufferedReader.readLine();
            if(name.equals("ENTER")){
                ans += hello.size();
                hello.clear();
            }
            else{
                hello.add(name);
            }

        }
        ans += hello.size();

        System.out.println(ans);
    }
}
