import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, tgt1, tgt2, answer;
	static List<Integer>[] list;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		visited = new boolean[n+1];
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		tgt1 = Integer.parseInt(st.nextToken());
		tgt2 = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}
		
		answer = -1;
		dfs(tgt1, 0);
		System.out.println(answer);
	}
	
	static void dfs(int now, int cnt) {
		if(now == tgt2) {
			answer = cnt;
			return;
		}

		visited[now] = true;
		
		int size = list[now].size();
		for(int i=0; i<size; i++) {
			int next = list[now].get(i);
			if(!visited[next]) {
				dfs(next, cnt+1);
			}
		}
	}
}
