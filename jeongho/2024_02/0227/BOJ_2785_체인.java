package algorithm2024.feb.day27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2785_체인 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int ans =0;
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        int ring = 0;
        while (list.size()>1) {
            list.set(0, list.get(0) - 1);
            list.remove(list.size() - 1);
            if(list.get(0)==0){
                list.remove(0);
            }
            ring++;
        }
        System.out.println(ring);
    }
}
