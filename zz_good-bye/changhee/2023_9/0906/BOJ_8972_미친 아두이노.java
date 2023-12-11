/*
 *  09.06 김창희
 *  BOJ_8972_미친 아두이노
 *
 *  [풀이]
 *  1. 미친 아두이노는 큐에 따로 저장한다.
 *  2. 아홉방향 모두 돌아보며 거리를 구하고 로봇과의 최소거리를 가지는 방향을 반환받는다.
 *  3. 중첩되는 미친 아두이노는 모두 제거해야하기 때문에 i,j위치에 몇개의 미친아두이노가 있는지 카운트하기 위헤 이차원 배열에 카운트한다.
 *  4. 큐가 빌때까지 돌고(미친 아두이노가 이동 전의 위치를 '.'로 변경한다) 카운트 배열에 값이 1인것만 map에 미친 아두이노의 위치를 다시 표시해준다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static char[][] map;
	static int[] dx= {1,1,1,0,0,0,-1,-1,-1}, dy= {-1,0,1,-1,0,1,-1,0,1};
	static Node robot;
	static Queue<Node> q =new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st =new StringTokenizer(br.readLine());
    	
    	n=Integer.parseInt(st.nextToken());
    	m=Integer.parseInt(st.nextToken());
    	
    	map=new char[n][m];
    	for(int i=0; i<n; i++) {
    		String temp = br.readLine();
    		for(int j =0; j<m; j++) {
    			map[i][j] = temp.charAt(j);
    			if(map[i][j] == 'I') robot  =new Node(i,j);
    			if(map[i][j] == 'R') q.offer(new Node(i,j));
    		}
    	}
    	
    	String cmd = br.readLine(); 
    	
    	for(int i =0; i<cmd.length(); i++) {
    		if(!move(cmd.charAt(i)-49)) {
    			System.out.printf("kraj %d",i+1);
    			return;
    		}
    	}
    	
    	StringBuilder answer = new StringBuilder();
    	for(int i =0; i<n; i++) {
    		for(int j =0; j<m; j++) {
    			answer.append(map[i][j]);
    		}
    		answer.append("\n");
    	}
    	
    	System.out.println(answer);
    }
    public static boolean move(int dir) {
    	
    	int nx = robot.x+dx[dir];
    	int ny = robot.y+dy[dir];
    	if(map[nx][ny]=='R') return false;
    	
    	map[robot.x][robot.y] = '.';
    	map[nx][ny] = 'I';
    	robot.x=nx;
    	robot.y=ny;
    	
    	int[][] count = new int[n][m];
    	while(!q.isEmpty()){
    		Node node = q.poll();
    		int nDir = selectDir(node.x, node.y);
    		nx = node.x+dx[nDir];
    		ny = node.y+dy[nDir];
    		
    		map[node.x][node.y] = '.';
    		count[nx][ny]++;
    		node.x=nx;
    		node.y=ny;
    		
    		if(map[nx][ny] == 'I') return false;
    	}
    

    	 for(int i = 0; i < n; i++) {
             for(int j = 0; j < m; j++) {
                 if(count[i][j] == 1) {
                     map[i][j] = 'R';
                     q.offer(new Node(i, j));
                 }
             }
         }
    	return true;
    }
    
    public static int selectDir(int x, int y) {
    	int dist = Integer.MAX_VALUE;
    	int dir=-1;
    	
    	for(int i =0; i<9; i++) {
    		if(i==4)continue;
    		int nx=x+dx[i]; 
    		int ny=y+dy[i];
    		if(nx<0||ny<0||nx>=n||ny>=m) continue;
    		int nDist = Math.abs(robot.x-nx)+Math.abs(robot.y-ny); 
    		if(dist > nDist) {
    			dist = nDist;
    			dir = i;
    		}
    	}
    	return dir;
    }
    
    static class Node{
    	int x,y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}    	
    }
}
