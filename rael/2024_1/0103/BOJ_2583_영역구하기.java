import java.io.*;
import java.util.*;

public class Main {
	static final int dx[] = {0,0,1,-1};
	static final int dy[] = {1,-1,0,0};
	static int n,m,count;
	static int map[][];
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int y=y1; y<y2; y++) { 
				for(int x=x1; x<x2; x++){ 
                    //직사각형 영역 1로 표시
					map[y][x] = 1;
				}
			}
		}
		
        //몇 개 나올지 모르니깐 ArrayList
		ArrayList<Integer> areaCnt = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) {
					count = 0; //영역 개수 초기화
					dfs(i,j);
					areaCnt.add(count);
				}
			}
		}
		
        //정렬
		Collections.sort(areaCnt);
		
		sb.append(areaCnt.size()).append('\n');
		for(int area : areaCnt)  {
			sb.append(area + " ");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int x, int y) {
		map[x][y] = 1;
		count++;    //영역 크기
		
		for(int k=0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			if(0<=nx && nx<n && 0<=ny && ny<m) {
				if(map[nx][ny] == 0) {
					dfs(nx,ny);
				}
			}
		}
	}

}
