import java.util.*;
import java.io.*;
public class BOJ_1194_달이차오른다 {
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N, M;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		boolean[][][] visit = new boolean[N][M][1<<7];
		
		Deque<int[]> q = new ArrayDeque<>();
		for (int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j=0; j<M; j++) {
				if (map[i][j]=='0') {
					q.add(new int[] {i,j,0,0});
					visit[i][j][0] = true;
					map[i][j] = '.';
				}
			}
		}
		int now[], ans=-1, nr, nc,key, door;
		l:while (!q.isEmpty()) {
			now = q.poll();
			for (int k=0; k<4; k++) {
				nr = now[0] + dr[k]; nc = now[1] +dc[k]; 
				if (nr<0 || nc<0 || N<=nr || M<=nc || map[nr][nc]=='#' || visit[nr][nc][now[2]]) continue;
				
				if (map[nr][nc]=='1') {ans=now[3]+1; break l;}
				key = (1<<(map[nr][nc]-'a'));
				door =  (1<<(map[nr][nc]-'A'));
				
				if (map[nr][nc] == '.' || (map[nr][nc]<='Z' && (now[2]&door)!=0)) {
					q.add(new int[] {nr, nc, now[2], now[3]+1});
					visit[nr][nc][now[2]] = true;
				} else if ('a'<=map[nr][nc] && !visit[nr][nc][now[2]|key]){
					q.add(new int[] {nr, nc, now[2]|key, now[3]+1});
					visit[nr][nc][now[2]|key] = true;
				}
			}
		}
		System.out.println(ans);
	}

}
