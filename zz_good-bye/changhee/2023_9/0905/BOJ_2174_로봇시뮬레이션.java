/*
 *  09.05 김창희
 *  BOJ_2174_로봇시뮬레이션
 *
 *  [풀이]
 *  1. 북쪽이 -1이 되고 남쪽이 +1이 된다. 좌표를 주의하자
 *  2. char로 주어지는 방향을 hashMap을 통해 정수로 변환하여 저장한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int a,b,n,m;
	static int[][] map;
	static int[]dx= {1,0,-1,0},dy= {0,1,0,-1};
	static Map<Character,Integer> dirs =new HashMap<>();
	static Node[] robot;
	static StringBuilder answer = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine());
		a=Integer.parseInt(st.nextToken());
		b=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		robot= new Node[n+1];
		
		dirs.put('N', 0);
		dirs.put('E', 1);
		dirs.put('S', 2);
		dirs.put('W', 3);
		
		map=new int[b][a];
		int number = 1;
		for(int i =0; i<n; i++) {
			st= new StringTokenizer(br.readLine());
			int y= Integer.parseInt(st.nextToken())-1;
			int x= Integer.parseInt(st.nextToken())-1;
			int dir= dirs.get(st.nextToken().charAt(0));
			
			robot[number] =new Node(x,y,number,dir);
			map[x][y]=number++;
		}
		
		for(int i =0; i<m; i++) {
			st =new StringTokenizer(br.readLine());
			int rN =Integer.parseInt(st.nextToken());
			char cmd = st.nextToken().charAt(0);
			int l = Integer.parseInt(st.nextToken());
			
			Node node = robot[rN];
			for(int j =0; j<l; j++) {	
				if(cmd == 'L') {
					node.dir = (node.dir+3)%4;
				}else if(cmd == 'R') {
					node.dir = (node.dir+1)%4;
				}else {
					int nx = node.x+dx[node.dir];
					int ny = node.y+dy[node.dir];
					if(nx<0||ny<0||nx>=b||ny>=a) {
						System.out.printf("Robot %d crashes into the wall",node.number);
						return;
					}
					
					if(map[nx][ny]!=0) {
						System.out.printf("Robot %d crashes into robot %d",node.number,map[nx][ny]);
						return;
					}
					
					map[node.x][node.y] =0;
					map[nx][ny] =node.number;
					
					node.x=nx;
					node.y=ny;
				}
			}
		}
		
		System.out.println("OK");
	}
	
	static class Node{
		int x,y,number,dir;

		public Node(int x, int y, int number, int dir) {
			this.x = x;
			this.y = y;
			this.number = number;
			this.dir = dir;
		}
	}
}
