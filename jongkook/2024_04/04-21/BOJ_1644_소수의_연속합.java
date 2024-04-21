package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1644_소수의_연속합 {
    static int N, cnt;
    static boolean[] visited;
    static ArrayList<Integer> lst = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if(N == 1) {
            System.out.println(0);
            return;
        }

        visited = new boolean[N+1];
        visited[0] = visited[1] = true;


        for(int n = 2; n <= Math.sqrt(N); n++){
            if(visited[n]) continue;
            for(int k = n * n; k <= N; k += n) visited[k] = true;
        }
        for(int i = 2; i <= N; i++) if(!visited[i]) lst.add(i);

        int lastNumber = lst.get(lst.size()-1);
        if(lastNumber == N) cnt++;
        int start = 0;
        int end = 0;
        int primeCnt = lst.size()-1;
        while(start != primeCnt){
            int value = 0;
            for(int i = start; i < end; i++) value += lst.get(i);

            if(value == N){
                cnt++;
                start++;
                end++;
            }
            else if (value < N) end++;
            else start++;
        }
        System.out.println(cnt);
    }
}
