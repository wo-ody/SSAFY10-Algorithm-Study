package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11724_연결_요소의_갯수 {
    static int node, edge, count;
    static ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= node; i++) lst.add(new ArrayList<>());
        visited = new boolean[node+1];

        for(int e = 1; e <= edge; e++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            lst.get(from).add(to);
            lst.get(to).add(from);
        }

        for(int i = 1; i <= node; i++){
            if(visited[i]) continue;
            count++;
            dfs(i);
        }
        System.out.println(count);
    }
    static void dfs(int start){

        for(Integer el : lst.get(start)){
            if(visited[el]) continue;
            visited[el] = true;
            dfs(el);
        }

    }
    static void printLst(){
        for(ArrayList<Integer> ali : lst){
            for(Integer el : ali){
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}
