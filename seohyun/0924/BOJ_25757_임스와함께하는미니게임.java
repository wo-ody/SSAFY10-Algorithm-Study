package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_25757_미니게임 {
    static int N;
    static Character game;

    static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        game = st.nextToken().charAt(0);
        int pnum = 0;

        if(game == 'Y') pnum = 2;
        else if(game == 'F') pnum = 3;
        else if(game == 'O') pnum = 4;

        HashMap<String,String> hmap = new HashMap<>();
        int cnt = 1;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if(!hmap.containsKey(str)){
                hmap.put(str,str);
                cnt++;
            }
            if(cnt == pnum){
                result++;
                cnt = 1;
            }
        }

        System.out.println(result);
    }
}
