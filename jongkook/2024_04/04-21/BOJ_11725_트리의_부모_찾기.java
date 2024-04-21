package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725_트리의_부모_찾기 {
    static int N;
    static boolean[] visited;
    static int[] result;
    static StringTokenizer st;
    static ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        result = new int[N+1];
        for(int n = 0; n <= N; n++) lst.add(new ArrayList<>());
        for(int n = 1; n < N; n++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            lst.get(from).add(to);
            lst.get(to).add(from);
        }
        recursive(1);
        for(int i = 2; i <= N; i++) System.out.println(result[i]);


    }
    static void recursive(int start){
        visited[start] = true;

        for(int next: lst.get(start)){
            if(visited[next]) continue;
            result[next] = start;
            recursive(next);
        }
    }
}
