import java.io.*;
import java.util.*;

public class Main{
	static int[][] map, visit;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static int n, m;
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        
        for (int i=0; i<n; i++) {
        	char[] stt = br.readLine().toCharArray();
        	for (int j=0; j<m; j++) map[i][j] = stt[j] -'0';
        }
        
        visit = new int[n][m];
        List<Integer> area = new ArrayList<>();
        area.add(0);
        int c=1;
        for (int i=0; i<n; i++) {
        	for (int j=0; j<m; j++) {
        		if (visit[i][j]!=0 || map[i][j]==1) continue;
        		area.add(bfs(i,j,c++));
        	}
        }
        
        HashSet<Integer> set;
        int nr, nc;
        for (int i=0; i<n; i++) {
        	for (int j=0; j<m; j++) {
        		if (map[i][j]==0) continue;
        		set = new HashSet<>();
        		for (int k=0; k<4; k++) {
        			nr =i+dr[k]; nc =j+dc[k];
        			if (nr<0 || nc<0 || nr>=n || nc>=m) continue;
        			set.add(visit[nr][nc]);
        		}
        		for (int a : set) {
        			map[i][j] += area.get(a);
        		}
        		map[i][j]%=10;
        	}
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
        	for (int j=0; j<m; j++) {
        		sb.append(map[i][j]);
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
	}
	
	static int bfs(int i, int j, int c) {
		Deque<int[]> q = new ArrayDeque<>();
		int nr, nc, now[], res=1;
		q.add(new int[] {i,j});
		visit[i][j] = c;
		while (!q.isEmpty()) {
			now = q.poll();
			for (int k=0; k<4; k++) {
				nr = now[0] + dr[k]; nc = now[1] + dc[k];
				if (nr<0 || nc<0 || nr>=n || nc>=m || map[nr][nc]==1 ||visit[nr][nc]!=0) continue;
				visit[nr][nc] = c; res++;
				q.add(new int[] {nr, nc});
			}
			
		}
		return res;
	}
}

