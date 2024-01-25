package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1743_음식물피하기 {
    static int N,M,K,max;
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};
    static boolean[][] visit;
    static boolean[][] food;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
    	init(); //음식물 있는 곳을 true로 바꿔주기 	
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			//방문하지 않았고 음식물인 곳이라면 크기 구해서 max에 담기
    			if(!visit[i][j] && food[i][j]) simul(i,j);
    		}
    	}
    	System.out.println(max);
    }
    
    public static void simul(int y, int x) {
    	Queue<int[]> q = new ArrayDeque<>();
    	q.add(new int[] {y,x});
    	visit[y][x] = true;
    	int cnt = 1;
    	
    	while(!q.isEmpty()) {
    		int[] arr = q.poll();
    		
    		for(int d=0; d<4; d++) {
    			int ny = arr[0] + dy[d];
    			int nx = arr[1] + dx[d];
    			
    			if(ny < 0 || ny >= N || nx < 0 || nx >= M || 
    					visit[ny][nx] || !food[ny][nx]) continue;
    			
    			q.add(new int[] {ny, nx});
    			visit[ny][nx] = true;
    			cnt++;
    		}
    	}
    	
    	max = Math.max(max, cnt);
    }
    
    public static void init() throws IOException {
    	st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    
    	food = new boolean[N][M];
    	visit = new boolean[N][M];
    	
    	for(int i=0; i<K; i++) {
    		st = new StringTokenizer(br.readLine());
    		int r = Integer.parseInt(st.nextToken()) -1;
    		int c = Integer.parseInt(st.nextToken()) -1;
    	
    		food[r][c] = true;
    	}
    }
}
