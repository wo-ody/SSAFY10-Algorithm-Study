/*
 *	08.01 김창희
 *	BOJ_14502_연구소
 *
 *	[풀이]
 *	1. 벽을 세울수 있는 0이 있는 좌표를 따로 저장하여 조합으로 3개씩 뽑아 벽을 임의로 설치한후 bfs탐색으로 바이러스를 퍼트린다 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	static List<Node> zeroPoint = new ArrayList<>();
	static List<Node> virusPoint = new ArrayList<>();
	static int n, m, safeZoneSize=-3, answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map=new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					zeroPoint.add(new Node(i, j));
					safeZoneSize++;
				}
				if (map[i][j] == 2)
					virusPoint.add(new Node(i, j));
			}
		}
		
		combZeroPoint(0,0,zeroPoint.size());
		System.out.println(answer);

	}

	public static void combZeroPoint(int start, int depth,int size) {
		if (depth == 3) {
			answer = Math.max(answer, bfs());
			return;
		}
		for (int i = start; i < size; i++) {
			map[zeroPoint.get(i).x][zeroPoint.get(i).y] = 1;
			combZeroPoint(i + 1, depth + 1,size);
			map[zeroPoint.get(i).x][zeroPoint.get(i).y] = 0;
		}

	}

	private static int bfs() {
		Queue<Node> q = new LinkedList<>();
		boolean[][] v = new boolean[n][m];
		int result =0;
		
		for (Node node : virusPoint) {
			q.offer(node);
			v[node.x][node.y] = true;
		}
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i =0; i<4; i++) {
				int nx = node.x+dx[i];
				int ny = node.y+dy[i];
				
				if(nx<0||ny<0||nx>=n||ny>=m) continue;
				
				if(!v[nx][ny] && map[nx][ny]==0) {
					v[nx][ny]=true;
					result++;
					q.offer(new Node(nx,ny));
				}
			
			}
		}

		return safeZoneSize-result;
	}
	
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
