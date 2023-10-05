import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16236_아기상어 {
	static int N;
	static int[][] map;
	static Node shark;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static int time = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark = new Node(i,j,2,0);
					map[i][j] = 0;
				}
			}
		}
		
		while(true) {
			if(eat_fish() == false) break;
			//print(map);
		}
		System.out.println(time);
		
	}
	
	static boolean eat_fish() {
		Queue<Node> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		List<Node> fish = new ArrayList<>();
		int depth = 0;
		
		q.offer(new Node(shark.x,shark.y));
		visited[shark.x][shark.y] = true;
		
		while(!q.isEmpty()) {
			int qsize = q.size();
			depth++; // 이동 
			for (int i = 0; i < qsize; i++) {
				Node cur = q.poll();
				for (int k = 0; k < 4; k++) {
					int nx = cur.x + dx[k];
					int ny = cur.y + dy[k];
					if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
					if(shark.size < map[nx][ny]) continue;
					if(shark.size > map[nx][ny] && map[nx][ny] != 0) fish.add(new Node(nx,ny));
					q.add(new Node(nx,ny));
					visited[nx][ny] = true;
				}
			}
			if(!fish.isEmpty()) break;
		}
		
		if(fish.isEmpty()) return false;
		
		// 정렬 후 맨 위 좌측의 물고기 먹음 (map, shark.size + time 갱신)
		Collections.sort(fish,new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.x == o2.x) return o1.y - o2.y;
				return o1.x - o2.x;
			}
		});
		
		Node eaten_fish = fish.get(0);
		int fish_size = map[eaten_fish.x][eaten_fish.y];
		
		map[eaten_fish.x][eaten_fish.y] = 0;
		shark.x = eaten_fish.x;
		shark.y = eaten_fish.y;
		shark.eaten_fish++;
		if(shark.size == shark.eaten_fish) {
			shark.size++;
			shark.eaten_fish = 0;
		}
		time += depth;
		
		return true;
	}
	
	static class Node{
		int x,y;
		int size;
		int eaten_fish;
		
		Node(int x, int y){
			this.x = x ;
			this.y = y;
		}
		
		Node(int x, int y, int size, int eaten_fish){
			this.x = x ;
			this.y = y;
			this.size = size;
			this.eaten_fish = eaten_fish;
		}
	}
	
	static void print(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
