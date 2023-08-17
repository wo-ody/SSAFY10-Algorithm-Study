import java.io.*;
import java.util.*;
public class BOJ_17471_게리멘더링 {
	static boolean[][] g;
	static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int psum = 0;
		g = new boolean[n][n];
		int zcnt = 0;
		int znode = 0;
		String[] st = br.readLine().split(" ");
		for (int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st[i]);
			psum += arr[i];
			String[] stt = br.readLine().split(" ");
			boolean[] tem = new boolean[n];
			if (stt[0].equals("0")) {zcnt++; znode=i;}
			else for (int j=Integer.parseInt(stt[0]);j>0;j--) tem[Integer.parseInt(stt[j])-1] =true;
			g[i] = tem;
		}  //입력 엉망진창. psum - 전체인구 합, arr- 각도시 인구 수, g - 그래프(grid)
		if (zcnt >=2 && n>2) System.out.println(-1); // 고립도시 두개 넘음 
		else if (zcnt==1) System.out.println(Math.abs(psum-arr[znode]*2)); // 한가지 경우만 가능
		else {
			int ans = Integer.MAX_VALUE;
			for (int i=1; i< 1<<(n-1); i++) { // 모든 경우에 대하여 검사
				boolean[] group = new boolean[n];
				boolean[] eroup = new boolean[n];
				eroup[n-1] = true;
				for (int j=0; j<n-1; j++) {
					if ((i|1<<j) == i) group[j] = true;
					else eroup[j] = true;
				}
				if (isone(group) && isone(eroup)) {
					int t = 0;
					for (int a=0; a<n; a++) if (group[a]) t+=arr[a];
					ans = Math.min(ans, Math.abs(psum-t*2));
				}
			}
			System.out.println(ans);
		}
	} // main
	
	static boolean isone(boolean[] group) {
		Deque<Integer> q = new ArrayDeque<>();
		int i=0;
		while(i<n) {
			if (group[i]) {q.add(i); break;}
			i++;
		}
		boolean[] visit = new boolean[n];
		visit[i] = true;
		while (!q.isEmpty()) {
			int now = q.pop();
			for (int a=0; a<n; a++) {
				if (g[now][a] && !visit[a] && group[a]) {q.add(a); visit[a] =true;}
			}
		}
		for (int a=0; a<n; a++) if (group[a] && !visit[a]) return false;
		return true;
	}
}
