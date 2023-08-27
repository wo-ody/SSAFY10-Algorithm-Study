import java.util.*;
import java.io.*;
public class practice{
	static int[][] map;
	static int n, mx, ans;
	static List<int[]> core;
	static Deque<int[]> stack;
	static int[] dr = {-1,1,0,0}; 
	static int[] dc = {0,0,1,-1};
    
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc=1; tc<=T; tc++){
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            core = new ArrayList<>();
            stack = new ArrayDeque<>();
            for (int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j]==1) core.add(new int[] {i,j});
                }
            }
            mx =0; ans=0;
            connect(0,0,0);
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    } //main

    static void connect(int now, int tmx, int tans){
        if (now==core.size()){
            if (mx < tmx ||(mx==tmx && ans>tans)) {
            	mx = tmx;
            	ans = tans;
            }
            return;
        }
        int r= core.get(now)[0], c = core.get(now)[1];
        int cnt;
        if (r==0 || c==0 || r==n-1 || c==n-1) {
            connect(now+1,tmx+1, tans);
            return;
        }
        for (int k=0; k<4; k++){
        	cnt = isCon(k, r, c);
        	if (cnt!=0) connect(now+1, tmx+1, tans+cnt);
        	back(cnt);
        }
        connect(now+1,tmx,tans);
    }

    static int isCon(int dir, int i, int j){
        int res = 0;
        i+= dr[dir]; j += dc[dir];
        while (0<=i && i<n && 0<=j && j<n && map[i][j]==0){
            map[i][j] = 1;
            stack.add(new int[] {i,j});
            res++;
            i+= dr[dir]; j += dc[dir];
        }
        if (i==-1 || j==-1 || i==n || j==n) return res;
        back(res);
        return 0;
    }
    
    static void back(int x) {
    	int[] now;
    	for (int i=0; i<x; i++) {
    		now = stack.pollLast();
    		map[now[0]][now[1]] = 0;
    	}
    }
}
