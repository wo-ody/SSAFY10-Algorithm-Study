import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class cdt_싸움땅 {
	static int N,M,K;
	static PriorityQueue<Integer>[][] gun;
	static Node[] player;
	static int[][] player_map;
	static int[] point;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		gun = new PriorityQueue[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				gun[i][j] = new PriorityQueue<Integer>((i1, i2) -> i2 - i1);
			}
		}
		player = new Node[M+1];
		player_map = new int[N][N];
		point = new int[M+1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num > 0) gun[i][j].add(num);
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) ;
			int s = Integer.parseInt(st.nextToken()) ;
			player[i+1] = new Node(x,y,d,s,0);
			player_map[x][y] = i+1;
		}
		
		simulation();
		for (int i = 1; i <=M ; i++) {
			System.out.print(point[i] + " ");
		}
	}
	
	static int opposite_dir(int dir) {
		if(dir == 0) return 2;
		else if(dir == 2) return 0;
		else if(dir == 1) return 3;
		else return 1;
	}
	
	static void get_gun(int x, int y, int pnum) {
		if(player[pnum].gun == 0) {
			if(!gun[x][y].isEmpty()) player[pnum].gun = gun[x][y].poll();
		}
		else {
			gun[x][y].add(player[pnum].gun);
			if(!gun[x][y].isEmpty())  player[pnum].gun = gun[x][y].poll();
		}
	}
	
	static void fight(int win, int lose, int x, int y) {
		// player, player_map 갱신
		
		Node winner = player[win];
		Node loser = player[lose];
		
		point[win] += Math.abs((winner.s + winner.gun) - (loser.s + loser.gun)); // 1.
		if(loser.gun != 0) {
			gun[x][y].add(loser.gun); // 2.
			loser.gun = 0;
		}
		int cd = loser.d;
		for (int k = 0; k < 4; k++) {
			int nx = loser.x + dx[cd];
			int ny = loser.y + dy[cd];
			if(isCango(nx, ny) && player_map[nx][ny] == 0) break;
			else cd = (cd + 1) % 4;
		} // 3.
		int loser_nx = loser.x + dx[cd];
		int loser_ny = loser.y + dy[cd];
		get_gun(loser_nx,loser_ny,lose); // 4.
		
		get_gun(x,y,win);//5.
		
		player_map[x][y] = win;
		player_map[loser_nx][loser_ny] = lose;
		player[lose].x = loser_nx;
		player[lose].y = loser_ny;
		player[lose].d = cd;
		player[win].x = x;
		player[win].y = y;
	}
	
	static void move_players() {
		for (int i = 1; i <= M ; i++) {
			int cx = player[i].x;
			int cy = player[i].y;
			int cd = player[i].d;
			int cs = player[i].s;
			
			player_map[cx][cy] = 0; // player_map 갱신
			
			int nx = cx + dx[cd];
			int ny = cy + dy[cd];
			if(!isCango(nx, ny)) {
				cd = opposite_dir(cd);
				nx = cx + dx[cd];
				ny = cy + dy[cd];
			}
			
			//---좌표 구하기
			player[i].x = nx;
			player[i].y = ny;
			player[i].d = cd;
			if(player_map[nx][ny] == 0) {
				// 총획득
				get_gun(nx,ny,i);
				player_map[nx][ny] = i;
			}
			else {//fight
				int p1_idx = i;
				int p2_idx = player_map[nx][ny];
				
				int p1_value = player[p1_idx].s + player[p1_idx].gun;
				int p2_value = player[p2_idx].s + player[p2_idx].gun;
				
				if(p1_value > p2_value) {
					fight(p1_idx, p2_idx,nx,ny);
				}
				else if(p1_value < p2_value) {
					fight(p2_idx, p1_idx,nx,ny);
				}
				else {
					if(player[p1_idx].s > player[p2_idx].s) {
						fight(p1_idx, p2_idx,nx,ny);
					}
					else {
						fight(p2_idx, p1_idx,nx,ny);
					}
				}
			}
			
			
		}
	}
	
	static void simulation() {
		for (int cnt = 0; cnt < K; cnt++) {
			move_players();
		}
	}
	
	static boolean isCango(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= N) return false;
		return true;
	}

	static class Node{
		int x,y,d,s;
		int gun;
		public Node(int x, int y, int d, int s, int gun) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.s = s;
			this.gun = gun;
		}

		
	}
}
