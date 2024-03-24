package algorithm2024.mar.day24;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_10546_배부른마라토너 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name,0)+1);
        }

        for (int i = 0; i < N - 1; i++) {
            String name = br.readLine();
            map.put(name,map.get(name)-1);
        }
        String ans = "";
        for (String s : map.keySet()) {
            if(map.get(s)>0)ans=s;
        }
        System.out.println(ans);
    }
}
