package algorithm2023.aug.day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	static int N, popul[];
	static boolean graph[][];
	static boolean[] v;
	static int min = Integer.MAX_VALUE;
	static int bm;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		bm = 1<<N;
		popul = new int[N];
		graph = new boolean[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			popul[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			for (int j = 0; j < M; j++) {
				int nb = Integer.parseInt(st.nextToken()) - 1;
				graph[i][nb] = true;
			}
		}
		for(int i =1;i<bm;i++) {
			v = new boolean[N];
			red(i);
			blue(i);
			if(check()) {
				int rCnt =0;
				int bCnt = 0;
				for(int j =0;j<N;j++) {
					if((i&(1<<j))>0)rCnt+=popul[j];
					else bCnt+=popul[j];
				}
				min = Math.min(min, Math.abs(rCnt-bCnt));
			}
		}
		System.out.println(min==Integer.MAX_VALUE?-1:min);
		
		
	}
	
	static void red(int bm) {
		int start = 0;
		for(int i =0;i<N;i++) {
			if((bm&(1<<i))>0) {
				start = i;
				break;
			}
		}
		//첫번째 집단에 대해 탐색
		Queue<Integer> red = new LinkedList<>();
		red.add(start);
		v[start]  =true;
		while(!red.isEmpty()) {
			int cur = red.poll();
			for(int i= 0;i<N;i++) {
				//연결 돼 있고 비트마스킹되어있다면 탐색
				if(graph[cur][i]&&(bm&(1<<i))>0) {
					if(!v[i]) {
						red.offer(i);
						v[i]  = true;
					}
				}
			}
		}
	}
	
	static void blue(int bm) {
		int start = 0;
		for(int i =0;i<N;i++) {
			if((bm&(1<<i))==0) {
				start = i;
				break;
			}
		}
		//첫번째 집단에 대해 탐색
		Queue<Integer> blue = new LinkedList<>();
		blue.add(start);
		v[start]  =true;
		while(!blue.isEmpty()) {
			int cur = blue.poll();
			for(int i= 0;i<N;i++) {
				//연결 돼 있고 비트마스킹 되어 있지 않다면 탐색
				if(graph[cur][i]&&(bm&(1<<i))==0) {
					if(!v[i]) {
						blue.offer(i);
						v[i]  = true;
					}
				}
			}
		}
	}
	
	static boolean check() {
		for(int i =0;i<N;i++) {
			if(!v[i])return false;
		}
		return true;
	}
}
