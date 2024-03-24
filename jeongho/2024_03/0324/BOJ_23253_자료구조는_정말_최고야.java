package algorithm2024.mar.day24;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_23253_자료구조는_정말_최고야 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i <M; i++) {
            ArrayList<Integer> dq = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                dq.add(Integer.parseInt(st.nextToken()));
            }
            list.add(dq);
        }
        boolean canSort = true;
        loop:
        for (ArrayList<Integer> integers : list) {
            for(int i =0;i<integers.size()-1;i++){
                if(integers.get(i)<integers.get(i+1)){
                    canSort = false;
                    break loop;
                }
            }
        }

        System.out.println(canSort?"Yes":"No");
    }

}
