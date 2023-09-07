import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//더더더최적화@.@
public class Main {
	static int N, M;
    static int from, to;

    static List<Integer>[] graph;//ArrayList의 배열

    static boolean[] visited;

    static boolean done = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        visited = new boolean[N];
        graph = new ArrayList[N];
        
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        // 풀이
        // 모든 친구 각각으로부터 출발
        for(int i = 0; i<N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            dfs(i, 0);
            if(done) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    static void dfs(int num, int cnt) { // 친구(정점)번호, depth(count)
        // 기저조건
        //if(done) return;
        
        if(cnt == 4) { // 4번 연속으로 친구가 연결
            done = true;
            return;
        }
        
        
        //ArrayList를 선언해서 바로 접근하기 때문에 for-each문보다 빠르다.
        List<Integer> numFriends = graph[num];
        int size = numFriends.size(); 		//num에서 갈 수 있는 다른 친구의 수
        for(int i=0; i<size; i++) {
        	int n = numFriends.get(i);
        	
        	if(visited[n]) continue;		//이미 방문
        	visited[n] = true;
        	dfs(n, cnt+1);
        	visited[n] = false;
        }
    }

}
