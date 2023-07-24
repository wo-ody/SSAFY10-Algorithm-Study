/**
 * 7.24 김창희
 * BOJ_17142_연구소3
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<Node> startPoints = new ArrayList<>();
	static int[][] map;
	static int[] dx = {-1,0,1,0}, dy= {0,1,0,-1};
	static Node[] startPointM;
	static int n,m,size,infectonCount,answer=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] ==2) startPoints.add(new Node(i,j,0));
				if(map[i][j] ==0) infectonCount++;
			}
		}
		
		if(infectonCount==0) {
			System.out.println(0);
			return;
		}
		
		startPointM=new Node[m];
		size = startPoints.size();
		comb(0,0);
		
		System.out.println(answer == Integer.MAX_VALUE?-1:answer);
	}
	
	public static void comb(int start, int count) {
		if(count==m) {
			answer = Math.min(answer, spread());
			return;
		}
		
		for(int i =start; i<size; i++) {
			startPointM[count] = startPoints.get(i);
			comb(i+1, count+1);
		}
	}
	
	public static int spread() {
		Queue<Node> q= new LinkedList<>();
		boolean[][] v= new boolean[n][n];
		
		for(Node node : startPointM) {
			v[node.x][node.y] = true;
			q.offer(node);
		}
		
		int count = 0;
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int i =0; i<4; i++) {
				int nx = node.x+dx[i];
				int ny = node.y+dy[i];
				
				if(nx<0||ny<0||nx>=n||ny>=n) continue;
				
				if(!v[nx][ny]&&map[nx][ny]!=1) {
					if(map[nx][ny] == 0 && infectonCount == ++count) return node.cost+1;
					v[nx][ny] = true;
					q.offer(new Node(nx,ny,node.cost+1));
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	
	static class Node{
		int x,y,cost;

		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
}
