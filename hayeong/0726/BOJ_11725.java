import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class 트리의부모찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] conn = new ArrayList[n+1];
        int[] parent = new int[n+1];
        boolean[] visited = new boolean[n+1];

        for(int i = 0; i<n+1; i++){
            conn[i] = new ArrayList<>();
        }

        for(int i = 1; i<=n-1; i++){
            st = new StringTokenizer(br.readLine());
            int start  = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            conn[start].add(end);
            conn[end].add(start);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        parent[1] = 0;
        while(!queue.isEmpty()){
            int p = queue.poll();
            for(int child : conn[p]){
                if(!visited[child]){
                    parent[child] = p;
                    visited[child] = true;
                    queue.add(child);
                }
            }
        }

        for(int i = 2; i<=n; i++){
            System.out.print(parent[i]+" ");
        }
    }
}
