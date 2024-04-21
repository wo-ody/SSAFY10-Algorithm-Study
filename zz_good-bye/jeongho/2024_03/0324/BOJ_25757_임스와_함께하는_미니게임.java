package algorithm2024.mar.day24;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_25757_임스와_함께하는_미니게임 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        HashMap<String, Integer> game = new HashMap<>();
        game.put("Y", 2);
        game.put("F", 3);
        game.put("O", 4);

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String g = st.nextToken();
        int maxCnt = game.get(g);

        HashSet<String> p = new HashSet<>();

        int ans = 0;
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            String n = br.readLine();
            if(!p.contains(n)){
                p.add(n);
                cnt++;
                if(cnt==maxCnt){
                    ans++;
                    cnt=1;
                }
            }
        }
        System.out.println(ans);

    }
}
