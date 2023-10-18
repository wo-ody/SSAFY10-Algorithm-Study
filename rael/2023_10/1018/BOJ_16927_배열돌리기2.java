import java.util.*;
import java.io.*;

public class Main {
    
	static int N, M, R;
	static int[][] map;
    
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	R = Integer.parseInt(st.nextToken());
    	
    	map = new int[N][M];
    	
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		for(int j=0; j<M; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	// 회전시켜야하는 덩어리 수 만큼 반복
    	int nN = N;
    	int nM = M;
    	for(int i=0; i<Math.min(M, N)/2; i++) {
    		/*
    		 * i : 회전을 시작할 좌표
    		 * 2*N + 2*M - 4 : 처음엔 가장 겉 테두리의 갯수, 그 다음엔 각 변 길이가 2씩 줄도록 해서 넣어줌
    		 */
    		rotate(i, 2*nN + 2*nM - 4);
    		nN -= 2;
    		nM -= 2;
    	}
    	
    	print();
    }

    static void rotate(int start, int len) {
    	
    	// 나누기 연산을 사용하여 반복되는 반복을 최소화 해준다.
    	int cir = R % len;
    	
    	// 새롭게 구해낸 회전 횟수 만큼 회전시킴
    	for(int t=0; t<cir; t++) {
    		
    		int temp = map[start][start]; // 마지막에 넣을 값 미리 빼놓음
    		
    		int idx = 0; // 다음 값 탐색할 인덱스
    		
    		int x = start;
			int y = start;
			
    		while(idx < 4) {
    			
    			int nx = x + dx[idx];
    			int ny = y + dy[idx];
    			
    			if(nx >= start && ny >= start && nx < N-start && ny < M-start) {
    				map[x][y] = map[nx][ny];
    				x = nx;
    				y = ny;
    			} else {
    				idx++;
    			}
    		}
    		map[start+1][start] = temp;	// 마지막에 미리 빼놨던 값 넣엊둠
    	}
    	
    }
    
    static void print() {
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			System.out.print(map[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
	
}
