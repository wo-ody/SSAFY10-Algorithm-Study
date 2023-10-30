package month10.day30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 1 초    128 MB
public class BOJ_2638_치즈 {
    
    static int N, M, cntCheese, time;
    static boolean[][] map, mapCopy;
    static boolean[][] visit, outAir;
    
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 5 ≤ N, M ≤ 100
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        mapCopy = new boolean[N][M];
        outAir = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
            	int value = Integer.parseInt(st.nextToken());
            	if(value == 1) {
            		map[i][j] = mapCopy[i][j] = true;
            		cntCheese++; // 치즈 개수 증가
            	} else {
            		map[i][j] = mapCopy[i][j] = false;
            	}
            }
        }
        
        // 보정 : 외부는 -1로 표기, 치즈는 1로 표기, 내부 빈공간은 0으로 표기
        
        while(cntCheese != 0) {
        	time++;

        	// outAir 초기화
        	for (int i = 0; i < N; i++) {
        		Arrays.fill(outAir[i], false);
        	}
        	
        	// 외부공간 찾기
	        findAir();
	        
	        // 치즈 녹이기 (치즈가 녹은자리는 0로 표기)
	        for (int i = 0; i < N; i++) {
	        	for (int j = 0; j < M; j++) {
	        		if( map[i][j] ) {
	        			if ( melt(i, j) ) {
	        				mapCopy[i][j] = false;
	        				cntCheese--; // 치즈를 녹이면 개수 감소
	        			}
	        		}
	        	}
	        }
	        
	        // 녹은치즈 반영하기
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < M; j++) {
	                map[i][j] = mapCopy[i][j];
	            }
	        }
	        
        }
        
        System.out.println(time);
    }
    
    // 치즈 녹이기
    static boolean melt(int y, int x) {
    	
    	int cnt = 0;
        for (int d = 0; d < 4; d++) {
        	int ny = y + dy[d];
        	int nx = x + dx[d];
        	if ( outAir[ny][nx] ) cnt++;
        }

        // 맞닿는 외부가 2개 이상일 때 이 치즈는 녹일 수 있다.
        if( cnt > 1 ) return true;
        return false;
    }
    
    // 외부공간 찾아서 check
    static void findAir() {
        Queue<Node> queue = new ArrayDeque<>();
        outAir[0][0] = true;
        queue.offer(new Node(0, 0));
        
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            
            for (int d = 0; d < 4; d++) {
            	int ny = cur.y + dy[d];
            	int nx = cur.x + dx[d];
            	if(isOutRange(ny, nx) || outAir[ny][nx]) continue;
            	
            	if(!map[ny][nx]) {
            		outAir[ny][nx] = true;
            		queue.offer(new Node(ny, nx));
            	}
            }
        }
    }
    
    static boolean isOutRange(int y, int x) {
        return y >= N || y < 0 || x >= M || x < 0;
    }
    
    static class Node {
        int y, x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
