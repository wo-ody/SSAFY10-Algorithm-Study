import java.io.*;
import java.util.*;

class Pos{
	int row, col;
	public Pos(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
public class Solution {
	public static final int[] dx = {1,0,-1,0};
	public static final int[] dy = {0,1,0,-1};
	public static int N,M,ans,safeZone,max = Integer.MIN_VALUE;;
	public static boolean[][] visit;
	public static boolean[] v;
	public static int[][] map;
	
	public static int arr[];
	public static int num[];
	
	public static ArrayList<Pos> list;
	public static ArrayList<Pos> virusList;
	public static Queue<Pos> q;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		
		map	      = new int[N][M];
		list 	  = new ArrayList<>();
		virusList = new ArrayList<>();
		q         = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 0) list.add(new Pos(i,j));
				if(map[i][j] == 2) virusList.add(new Pos(i,j));
			}
		}
		
		safeZone = list.size();
		arr = new int[3];
		num = new int[safeZone];
		v   = new boolean[safeZone];
		
		for (int i = 0; i < safeZone; i++) num[i] = i;
		
		permutation(0);
		System.out.println(max);
	}
	public static void permutation(int cnt) {
		if(cnt == 3) {
			visit = new boolean[N][M];
			
			for (int i = 0; i < 3; i++) {
				visit[list.get(arr[i]).row][list.get(arr[i]).col] = true;
			}
			max = Math.max(max, safeZone - bfs() -3);
			return;
		}
		
		for (int i = 0; i < list.size(); i++) {
			if(!v[i]) {
				v[i] = true;
				arr[cnt] = num[i];
				permutation(cnt + 1);
				v[i] = false;
			}
		
		}
	}
	public static int bfs() {
		for (Pos v : virusList) q.add(v);
		
		int cnt = 0;
		while(!q.isEmpty()) {
			Pos virus = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = virus.row + dx[i];
				int ny = virus.col + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M){
					continue;
				}
				if(map[nx][ny] == 1 || map[nx][ny] == 2 || visit[nx][ny]) {
					continue;
				}
				visit[nx][ny] = true;
				cnt++;
				
				q.add(new Pos(nx,ny));
			}
		}
		return cnt;
	}
}
