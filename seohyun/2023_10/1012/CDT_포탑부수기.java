package codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class cdt_포탑부수기 {
	static int N,M,K;
	static int[][] map;
	static int[][] attack_map;
	static boolean[][] attacked_map;
	//static ArrayList<Node> laser_road;
	static Node[][] road;
	
	static Node winner;
	static Node loser;
	
	static int[] dx = {0,1,0,-1,-1,-1,1,1};
	static int[] dy = {1,0,-1,0,-1,1,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		attack_map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		simulation();
		System.out.println(get_answer());
		
	}
	
	static void winner(int turn) {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if(o1.attack == o2.attack && o1.turn == o2.turn && o1.sum == o2.sum) return o2.y - o1.y;
				else if(o1.attack == o2.attack && o1.turn == o2.turn ) return o2.sum - o1.sum;
				else if(o1.attack == o2.attack) return o2.turn - o1.turn;
				else return o1.attack - o2.attack;
			}
		});
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) continue;
				// (int x, int y, int attack, int turn, int sum)
				pq.add(new Node(i,j,map[i][j],attack_map[i][j],i+j));
			}
		}
		
		Node tmp = pq.poll();
		winner = new Node(tmp.x, tmp.y);
		map[winner.x][winner.y] += (N+M);
		attack_map[winner.x][winner.y] = turn;
	}
	
	static void loser() {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if(o1.attack == o2.attack && o1.turn == o2.turn && o1.sum == o2.sum) return o1.y - o2.y;
				else if(o1.attack == o2.attack && o1.turn == o2.turn ) return o1.sum - o2.sum;
				else if(o1.attack == o2.attack) return o1.turn - o2.turn;
				else return o2.attack - o1.attack;
			}
		});
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0 || (i == winner.x && j == winner.y)) continue;
				// (int x, int y, int attack, int turn, int sum)
				pq.add(new Node(i,j,map[i][j],attack_map[i][j],i+j));
			}
		}
		
		Node tmp = pq.poll();
		loser = new Node(tmp.x, tmp.y);
	}
	
	// dfs 로 수정해야겠다 ...가 아니었네 
	static boolean is_possible_laser(){
		Queue<Node> q = new ArrayDeque<>();
		int[][] visited = new int[N][M];
		road = new Node[N][M];
		
		q.add(winner);
		visited[winner.x][winner.y] = 1;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(loser.x == cur.x && loser.y == cur.y) {
				return true;
			}
			
			for (int k = 0; k < 4; k++) {
				Node nxt = next(cur,k);
				if(map[nxt.x][nxt.y] == 0 || visited[nxt.x][nxt.y] > 0) continue;
				q.add(nxt);
				visited[nxt.x][nxt.y] = visited[cur.x][cur.y] + 1; 
				
				if(road[nxt.x][nxt.y] == null) {
					road[nxt.x][nxt.y] = new Node(cur.x,cur.y);
				}
			}
		}
		return false;
	}
	
	// map, attacked_map 수정
	static void attack_laser() {
		int attack = map[winner.x][winner.y];
		int cx = loser.x;
		int cy = loser.y;
		
		map[cx][cy] -= (attack);
		while(true) {
			Node nxt = road[cx][cy];
			if(nxt.x == winner.x && nxt.y == winner.y) break;
			map[nxt.x][nxt.y] -= (attack/2); 
			attacked_map[nxt.x][nxt.y] = true;
			cx = nxt.x;
			cy = nxt.y;
		}
	}
	
	// map, attacked_map 수정
	static void attack_potan() {
		int attack = map[winner.x][winner.y];
		for (int k = 0; k < 8; k++) {
			Node nxt = next(loser,k);
			if(nxt.x == winner.x && nxt.y == winner.y) continue;
			map[nxt.x][nxt.y] -= (attack/2);
			attacked_map[nxt.x][nxt.y] = true;
		}
		map[loser.x][loser.y]-= attack; 
	}
	
	static void destroy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] < 0) map[i][j] = 0;
			}
		}
	}
	
	static void update() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0 || attacked_map[i][j] ||
				   (i == winner.x && j == winner.y) || (i == loser.x && j == loser.y)) {
					continue;
				}
				else map[i][j] += 1;
			}
		}
	}
	
	static boolean isExit() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] > 0) cnt++;
			}
		}
		
		if(cnt <= 1) return true;
		else return false;
	}
	
	static int get_answer() {
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) continue;
				result = Math.max(result, map[i][j]);
			}
		}
		
		return result;
	}
	
	static void simulation() {
		for (int turn = 1; turn <= K; turn++) {
			winner(turn);
			loser();
			
			// 공격
			attacked_map = new boolean[N][M];
			if(is_possible_laser()) attack_laser();
			else attack_potan();
			
			// 포탑 부서짐
			destroy();
			
			// 포탑 정비
			update();
			
			// 부서지지 않은 포탑이 1개라면 즉시 종료
			if(isExit()) break;
		}
	}
	
	static Node next(Node cur, int d) {
		int nx = cur.x + dx[d];
		int ny = cur.y + dy[d];
		
		if(nx < 0) nx = N -1;
		if(nx == N) nx = 0;
		if(ny < 0) ny = M -1;
		if(ny == M) ny = 0;
		
		return new Node(nx,ny);
	}
	
	
	static class Node{
		int x,y;
		int attack, turn;
		int sum;
		
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public Node(int x, int y, int attack, int turn, int sum) {
			super();
			this.x = x;
			this.y = y;
			this.attack = attack;
			this.turn = turn;
			this.sum = sum;
		}
		
	}

}
