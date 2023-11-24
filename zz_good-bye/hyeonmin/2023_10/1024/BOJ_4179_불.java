package month10.day24;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179_불 {

    static int R, C;
    static boolean impossible, exist;
    
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
    
    static char[][] map;
    static boolean[][] visit;
    static Queue<int[]> fireQueue = new ArrayDeque<>();
    static Queue<Node> node = new ArrayDeque<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 1 ≤ R, C ≤ 1000
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new char[R][C];
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
        	String str = br.readLine();
            for (int j = 0; j < C; j++) {
            	char c = str.charAt(j);
            	if(c=='F') fireQueue.offer(new int[] {i, j});
            	else if(c=='J') node.offer(new Node(i, j, 0));
            	map[i][j] = c;
            }
        }
        
        impossible = exist = false;
        while(!impossible) {
        	// 1. 불 4방향 확산됨
        	int fireCnt = fireQueue.size();
        	for (int i = 0; i < fireCnt; i++) {
        		int cur[] = fireQueue.poll();
        		spreadFire(cur[0], cur[1]);
        	}
        	// 2. 이동 (다음 위치와 비용을 가지고 있는 Node 클래스)
        	int nodeCnt = node.size();
        	for (int i = 0; i < nodeCnt; i++) {
        		Node cur = node.poll();
        		move(cur.y, cur.x, cur.dist);
        	}
        	// 3. 갈 수 있는 곳이 없다면? IMPOSSIBLE 출력\
        	if(node.size()==0) impossible = true;
        	// 4. 탈출에 성공하면?
        	else if(exist) break;
        }
        if(impossible) System.out.println("IMPOSSIBLE");
        else System.out.println(node.poll().dist);
        
    }
    
    static void move(int y, int x, int dist) {
    	
    	for (int d = 0; d < 4; d++) {
    		int ny = y + dy[d];
    		int nx = x + dx[d];
    		
    		if( isOutRange(ny, nx) ) {
    			exist = true;
    			node.offer(new Node(ny, nx, dist+1));
    			return;
    		}
    		else if( map[ny][nx] == '#' || map[ny][nx] == 'F' || visit[ny][nx]) continue;
    		visit[ny][nx] = true;
    		node.offer(new Node(ny, nx, dist+1));
    	}
    }
    
    static void spreadFire(int y, int x) {
        // bfs
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            
            if( isOutRange(ny, nx) || map[ny][nx] == '#' || map[ny][nx] == 'F') continue;
            map[ny][nx] = 'F';
            fireQueue.offer(new int[] {ny, nx});
        }
    }
    
    static boolean isOutRange(int y, int x) {
        return y >= R || y < 0 || x >= C || x < 0;
    }
    
    static class Node {
    	int y, x, dist;
    	public Node(int y, int x, int dist) {
    		this.y = y;
    		this.x = x;
    		this.dist = dist;
    	}
    }

}