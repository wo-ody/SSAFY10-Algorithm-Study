import java.util.*;
import java.io.*;
public class BOJ_17143_낚시왕 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0,0,1,-1};
	static HashMap<Integer, Shark> pool = new HashMap<>();
	static HashMap<Integer, Shark> npool = new HashMap<>();
	static HashMap<Integer, Shark> t;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int i, j, s, d, z;
		for (int a=0; a<m; a++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken())-1;
			j = Integer.parseInt(st.nextToken())-1;
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken())-1;
			z = Integer.parseInt(st.nextToken());
			if (d<=1) s%=r*2-2;
			else s%=c*2-2;
			pool.put(i*c+j,new Shark(s,d,z));
		}
		int ans=0;
		for (int col=0; col<c; col++) {
			for (int row=0; row<r; row++) {
				if (pool.containsKey(row*c+col)) {
					ans += pool.get(row*c+col).z;
					pool.remove(row*c+col);
					break;
				}
			}
			move(r, c);
			
		}
		System.out.println(ans);
	}
	
	static void move(int r, int c){
		npool.clear();
		int i, j, next;
		Shark s;
		for (Map.Entry<Integer, Shark> e: pool.entrySet()) {
			i = e.getKey()/c; j = e.getKey()%c; s = e.getValue();
			for (int a=0; a<s.s; a++) {
				i += dr[s.d]; j += dc[s.d];
				if (i==-1) {i=1; s.d^=1;}
				if (j==-1) {j=1; s.d^=1;}
				if (i==r) {i=r-2; s.d^=1;}
				if (j==c) {j=c-2; s.d^=1;}
			}
			next = i*c +j;
			if (npool.containsKey(next) && npool.get(next).z > s.z) continue;
			npool.put(next, s);
		}
		t = npool; npool = pool; pool = t;
	}

	static class Shark{
		int s, d, z;
		public Shark(int s, int d, int z) {
			this.s = s; this.d = d; this.z = z;
		}
	}
}
