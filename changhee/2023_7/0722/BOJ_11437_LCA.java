/**
 * 7.22 김창희
 * BOJ_11437_LCA
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> tree=new ArrayList<>();
    static int[] depth, parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i =0; i<n+1; i++) tree.add(new ArrayList<>());
        depth=new int[n+1];
        parent=new int[n+1];

        for(int i =0; i<n-1; i++){
            st= new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        //방향이 없기 때문에 밑에서 위로 올라올수있다. 루트 초기화 필수
        depth[1]=1;
        setDepthAndParent(1,2);

        int m = Integer.parseInt(br.readLine());
        for(int i =0; i<m; i++){
            st= new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            answer.append(lca(u,v)).append("\n");
        }

        System.out.println(answer);

    }

    private static int lca(int u, int v) {
        while(depth[u]>depth[v]) u = parent[u];
        while(depth[u]<depth[v]) v = parent[v];

        while (u != v) {
            u = parent[u];
            v = parent[v];
        }
        return u;
    }

    private static void setDepthAndParent(int v, int d) {
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{v,d});

        while(!q.isEmpty()){
            int[] node = q.poll();

            for (int nv : tree.get(node[0])) {
                if(depth[nv]!=0) continue;
                depth[nv] = node[1];
                parent[nv] = node[0];
                q.offer(new int[] {nv,node[1]+1});
            }
        }
    }
}
