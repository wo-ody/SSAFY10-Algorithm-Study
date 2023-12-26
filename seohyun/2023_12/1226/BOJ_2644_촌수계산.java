import java.util.*;
import java.io.*;

public class Main {
    static int n, m, start, end;
    static int[][] graph;
    static int[] dist;

    public static void dfs(int index){
        
        if(index == end) return;
        
        for(int i=1; i<=n; i++){
            if(graph[index][i]==1 && dist[i]==0){
                dist[i] = dist[index]+1;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n+1][n+1];
        dist = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        for(int i=0; i<m; i++){
            st =  new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = 1;
        }

        dfs(start);

        System.out.println(dist[end] == 0 ? -1 : dist[end]);
    }
}
