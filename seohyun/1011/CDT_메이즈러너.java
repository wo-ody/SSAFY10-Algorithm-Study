package codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class cdt_메이즈러너 {
	static int N,M,K;
	static int[][] map;
	
	static Node[] people;
	static ArrayList<Integer>[][] people_map;
	
	static Node exit;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	static int distance = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		people = new Node[M];
		exit = new Node(0,0);
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			people[i] = new Node(x,y,false);
		}
		
		st = new StringTokenizer(br.readLine());
		exit.x = Integer.parseInt(st.nextToken()) - 1;
		exit.y = Integer.parseInt(st.nextToken()) - 1;
		map[exit.x][exit.y] = -1;

		simulation();
		
		System.out.println(distance);
		System.out.println((exit.x + 1) + " " + (exit.y + 1));
	}
	
	static void move_people() {
		// map 에 사람 없애기 
		people_map = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				people_map[i][j] = new ArrayList<>();
			}
		}
		
		// 사람좌표 이동하면서 people, people_map 갱신
		// 이동한 만큼 정답에 더하기
		for (int i = 0; i < M; i++) {
			if(people[i].isExit) continue;
			int cx = people[i].x;
			int cy = people[i].y;
			PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {
					if(o1.x == o2.x) return o1.y - o2.y;
					return o1.x - o2.x;
				}
			});
			
			int cur_exit_distance = Math.abs(exit.x - cx) + Math.abs(exit.y - cy);
			// 이동거리, 방향에 대한 가중치(상하 0 좌우 1), 방향
			for (int k = 0; k < 4; k++) {
				int nx = cx + dx[k];
				int ny = cy + dy[k];
				int nd = Math.abs(exit.x - nx) + Math.abs(exit.y - ny);
				// 이동하지 않음
				if(!isCango(nx, ny) || map[nx][ny] > 0 || cur_exit_distance < nd) continue;
				
				
				int ndw = 0;
				if(k == 0 || k == 2) ndw = 1;
				pq.add(new Node(nd,ndw,k));
			}
			
			if(pq.isEmpty()) {
				people_map[cx][cy].add(i);
				continue;
			}
			
			Node first = pq.poll();
			int nx = cx + dx[first.z];
			int ny = cy + dy[first.z];
			
			
			if(exit.x == nx && exit.y == ny) {
				people[i].isExit = true;
				distance++;
				continue;
			}
			people[i].x = nx;
			people[i].y = ny;
			people_map[nx][ny].add(i);
			distance++;
			
			
		}
	}
	
	static boolean isMoreThanOne(int x, int y, int n) {
		int min_x = x;
		int max_x = x + n - 1;
		int min_y = y;
		int max_y = y + n - 1;
		
		boolean isExit = false;
		boolean isPeople = false;
		
		for (int i = min_x; i <= max_x; i++) {
			for (int j = min_y; j <= max_y; j++) {
				if(map[i][j] == -1) isExit = true;
				if(people_map[i][j].size() > 0) isPeople = true;
			}
		}
		
		if(isExit && isPeople) return true;
		else return false;
		
		
	}
	
	static Node find_square() {
		// 정사각형 한변, x, y (1명 이상의 참가자가 있어야함)
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if(o1.x == o2.x && o1.y == o2.y) return o1.z - o2.z;
				else if(o1.x == o2.x) return o1.y - o2.y;
				return o1.x -  o2.x;
			}
		});
		
		for (int sn = 2; sn <= N; sn++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i + sn - 1 < N && j + sn -1 < N) { // index 개념
						if(isMoreThanOne(i, j, sn)) {
							pq.add(new Node(sn, i,j));
						}
					}
					else break;
				}
			}
		}
		
	
		Node first = pq.poll();
		return first;
	}
	
	static void rotate(Node square) {
		int[][] tmp = new int[N][N];
		for (int i = 0; i < N; i++) tmp[i] = map[i].clone();
		
		int n = square.x;
		int x = square.y;
		int y = square.z;
		
		int px = x;
		int py = y + n - 1;
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				// map 변경
				map[px][py] = tmp[i][j];
				if(map[px][py] > 0) map[px][py] -= 1;
				if(map[px][py] == -1) {
					exit = new Node(px,py);
				}
				
				// people_map 변경
				if(people_map[i][j].size() > 0) {
					for(int pnum : people_map[i][j]) {
						people[pnum].x = px;
						people[pnum].y = py;
					}
				}
				px++;
			}
			px = x;
			py--;
		}
		
	}
	
	static void simulation() {
		for (int i = 0; i < K; i++) {
			// M명 이동
			move_people();
			
			// 모두 탈출 성공하면 종료
			int cnt = 0;
			for (int j = 0; j < M; j++) if(people[j].isExit) cnt++;
			if(cnt == M) return;
			
			// 미로 정사각형 찾기
			Node square = find_square();
			
			// 회전 시작
			rotate(square);
		}
	}
	
	static boolean isCango(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= N) return false;
		return true;
	}

	static class Node{
		int x, y,z;
		boolean isExit;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
		Node(int x, int y, boolean isExit){
			this.x = x;
			this.y = y;
			this.isExit = isExit;
		}
		
		Node(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
