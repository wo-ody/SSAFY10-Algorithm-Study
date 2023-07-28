import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16928_뱀과사다리게임 {
	static int N,M;
	static HashMap<Integer, Integer> hmap = new HashMap<>();
	static int result = Integer.MAX_VALUE;
	static class Point{
		int node, cnt;
		Point(int node, int cnt){
			this.node = node;
			this.cnt = cnt;
		}
	}

	
	public static void BFS() {
		Queue<Point> q = new LinkedList<>();
		int[] visited = new int[101];
		Arrays.fill(visited, 200);
		
		q.add(new Point(1,0));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int cur = p.node;
			int cnt = p.cnt;
			if(cur == 100) {
				result = Math.min(result, cnt);
			}
			//hmap 에 있는지 확인
			if(hmap.containsKey(cur)) {
				int nx = hmap.get(cur);
				if(visited[nx] > cnt) {
					q.add(new Point(nx,cnt));
					visited[nx] = cnt;
				}
			}
			//없으면 주사위 1-6 굴리기
			else {
				for(int k=1;k<=6;k++) {
					int nx = cur + k;
					if(nx > 100) continue;
					if(visited[nx] > cnt + 1) {
						q.add(new Point(nx,cnt + 1));
						visited[nx] = cnt + 1;
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N+M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			hmap.put(a,b);
		}
		
		BFS();
		System.out.println(result);
		
	}
	
	

}
