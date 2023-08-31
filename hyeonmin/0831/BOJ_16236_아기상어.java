import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {
	
	static int N;
	static int[][] map;
	static boolean[][] visit;
	
	static Fish shark;		// 상어도 물고기! 상어의 위치를 기록
	static int size = 2;
	static int kill = 0;
	
	static ArrayList<Fish> list = new ArrayList<>();
	static int ans;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {	
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark = new Fish(i, j, 0);
					map[i][j] = 0;
				}
			}
		}
		
		go();
		System.out.println(ans);
	}

	private static void go() {
		
		Queue<Fish> queue = new LinkedList<>();
		queue.offer(shark);
		visit[shark.y][shark.x] = true;
		
		while(true) {
			while(!queue.isEmpty()) {
				Fish now = queue.poll();
				int time = now.time;
				
				for (int i = 0; i < 4; i++) {
					int ny = now.y + dy[i];
					int nx = now.x + dx[i];
					
					if(!(0 <= ny && ny < N && 0 <= nx && nx < N) || visit[ny][nx]) continue;
					
					if(map[ny][nx] < size && map[ny][nx] != 0) {
						queue.offer(new Fish(ny, nx, time+1));
						visit[ny][nx] = true;
						list.add(new Fish(ny, nx, time+1));
					}
					
					if(map[ny][nx] == size || map[ny][nx] == 0) {
						queue.offer(new Fish(ny, nx, time+1));
						visit[ny][nx] = true;
					}
				}
			}
			
			if(!list.isEmpty()) {
				moveEat();
				
				queue.clear();
				visit = new boolean[N][N];

				queue.offer(shark);
				visit[shark.y][shark.x] = true;
			}else {
				return;
			}
		}
	}

	private static void moveEat() {
		Collections.sort(list, new Comparator<Fish>() {
			@Override
			public int compare(Fish o1, Fish o2) {
				if(o1.time == o2.time) {
					if(o1.y == o2.y) {
						if(o1.x > o2.x) {
							return 1;
						}else {
							return -1;
						}
					}else {
						if(o1.y > o2.y) {
							return 1;
						}else {
							return -1;
						}				
					}
				}else if(o1.time > o2.time){
					return 1;
				}else {
					return -1;
				}
			};
		});

		Fish now = list.get(0);
		
		shark.y = now.y;
		shark.x = now.x;
		
		if(++kill == size) {
			size++;
			kill = 0;
		}
		
		ans += now.time;
		map[now.y][now.x] = 0;
		list.clear();
	}
	
	private static class Fish {
		int y, x, time;
		public Fish(int x, int y, int time) {
			this.y = x;
			this.x = y;
			this.time = time;
		}
	}

}