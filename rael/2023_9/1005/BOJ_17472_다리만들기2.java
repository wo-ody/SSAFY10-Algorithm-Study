import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//그래프 자료구조를 준비하고 크루스칼로 풀이
//섬->정점
//	dfs()
//다리->간선
//	세로(vr()), 가로(hr())
public class Main {
	static int N, M, min;
	static int map[][];
	
	//dfs
	static boolean[][] visit;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static int V;		//정점
	static PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
	//간선 리스트
	static ArrayList<ArrayList<Edge>> vertex;		//어떤 한 정점에서 갈 수 있는 다른 정점 (간선관리)
	static boolean[] visitPrim;
	
	static class Edge{
		int v, cost;
		
		Edge(int v, int cost){
			this.v = v;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		
		//map input <= 섬은 -1
		for (int i = 0; i < N; i++) {
	        st = new StringTokenizer(br.readLine());
	        for (int j = 0; j < M; j++) {
	            map[i][j] = Integer.parseInt(st.nextToken())*(-1); // 바다: 0 섬:-1로 초기화
	        }
	    }
		
		//dfs
		int num=1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == -1 && !visit[i][j]) {
					//새로운 섬(정점)
					dfs(i,j,num);
					num++;
				}
			}
		}
		
		//정점 수
		V = num - 1;		//dfs 후 마지막 증가분 고려
		vertex = new ArrayList<ArrayList<Edge>>();
		for(int i=0; i<=V; i++) {
			vertex.add(new ArrayList<Edge>());
		}
		visitPrim = new boolean[V+1];
		
		//map[][]로부터 간선 정보 계산
		//가로로 쭉
		hr();
		//세로로 쭉
		vr();
		
		//프림 풀이
		//시작 정점 1번부터
		int cnt = 1;
		visitPrim[1] = true;
		pq.addAll(vertex.get(1)); //시작 1번 정점에서 ArrayList에 담긴 모든 다른 정점을 담아냄
		
		while(!pq.isEmpty()) {
			Edge e= pq.poll();
			
			//visit check
			if(visitPrim[e.v]) continue;
			
			//방문 안 했음
			visitPrim[e.v] = true;
			pq.addAll(vertex.get(e.v));
			min += e.cost;
			cnt ++;
				
			//정점을 선택하는 것이므로 정점 개수만큼!
			if(cnt == V) break;
		}
		
		if(cnt != V || min == 0) min = -1;
		System.out.println(min);
	}
	
	static void addEdge(int v1, int v2, int cost) {
		//뒤져서 중복인 항목을 제거하는 것이 손해가 될 수도, 이득이 될 수도 있다.
		boolean same = false;
		
		//v1 정점에서 갈 수 있는 다른 정점(간선) 
		for(Edge edge : vertex.get(v1)) {
			//같은 정점을 연결하는 간선이면 최소값으로 갱신
			if(edge.v == v2) {
				same = true;
				edge.cost = Math.min(edge.cost, cost);
				break;
			}
		}
		//새로운 간선이면 추가
		if(!same) vertex.get(v1).add(new Edge(v2, cost));
	}
	
	static void hr() {
		//행으로 내려온다
		for(int i=0; i<N; i++) {
			int prev = 0;
			int curr = 0;
			int v1 = 0;
			int v2 = 0;
			int cost = 0;
			
			// 옆으로 쭉 가면서 간선 발견시 추가
			for(int j=0; j<M; j++) {
				curr = map[i][j];
				// 0 -> 0이 아닌 좌표 (바다 -> 섬, 최초 시작점->섬)
				if(prev == 0 && curr != 0) {
					//아직 시작 정점 방문 X 상태
					if(v1 == 0) v1 = curr;
					else{
						//간선 발생
						v2 = curr;
						// 다리 길이 2 이상인지 확인
						if(cost > 1) {
							addEdge(v1, v2, cost);
							addEdge(v2, v1, cost);
						}
						v1 = v2;
						v2 = 0;
						cost = 0;
					}
				}
				//섬에서 시작했고, 아직 바다
				else if(v1 != 0 && curr == 0) {
					cost++;
				}
				
				prev = curr;
			}
		}
	}
	
	//옆으로 이동하면서
	static void vr() {
		//행으로 내려온다
		for(int i=0; i<M; i++) {
			int prev = 0;
			int curr = 0;
			int v1 = 0;
			int v2 = 0;
			int cost = 0;
			
			// 옆으로 쭉 가면서 간선 발견시 추가
			for(int j=0; j<N; j++) {
				curr = map[j][i];
				// 0 -> 0이 아닌 좌표 (바다 -> 섬, 최초 시작점->섬)
				if(prev == 0 && curr != 0) {
					//아직 시작 정점 방문 X 상태
					if(v1 == 0) v1 = curr;
					else{
						//간선 발생
						v2 = curr;
						// 다리 길이 2 이상인지 확인
						if(cost > 1) {
							//간선 추가 (v1, v2, cost)
							addEdge(v1, v2, cost);
							addEdge(v2, v1, cost);
						}
						v1 = v2;
						v2 = 0;
						cost = 0;
					}
				}
				//섬에서 시작했고, 아직 바다
				else if(v1 != 0 && curr == 0) {
					cost++;
				}
				
				prev = curr;
			}
		}
	}
	
	static void dfs(int y, int x, int num) {
		visit[y][x] = true;
		map[y][x] = num;
		
		//4방 탐색으로 갈 수 있는 곳을 계속 가면서 재귀호출 dfs
		for(int d=0; d<4; d++) {
			int ny = y+dy[d];
			int nx = x+dx[d];
			
			if(ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx]) continue;
			if(map[ny][nx] == -1) dfs(ny, nx, num);
		}
		
	}
}
