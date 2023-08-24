import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17471_게리맨더링 {
	static int N;
	static int[] people;
	static ArrayList<Integer>[] graph;
	
	static boolean[] tgt;
	
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		people = new int[N];
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();
		tgt = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) people[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				graph[i].add(Integer.parseInt(st.nextToken()) - 1);
			}
		}
		
		comb(0);
		
		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
		
	}
	
	static boolean isConnect(int start, boolean[] lst, boolean value) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N];
		boolean[] temp = new boolean[N];
		
		q.add(start);//시작
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			temp[cur] = true;
			for (Integer nxt : graph[cur]) {
				if(visited[nxt]) continue;
				if(lst[nxt] == value) {
					q.add(nxt);
					visited[nxt] = true;
				}
			}
		}
		
		// 확인
		if(value && Arrays.equals(lst, temp)) return true;
		if(!value) {
			for (int i = 0; i < N; i++) {
				if(temp[i]) temp[i] = false;
				else temp[i] = true;
			}
			if(Arrays.equals(lst, temp)) return true;
		}
		return false;
		
	}
	
	static void simulation() {
		int A_start = -1;
		for (int i = 0; i < N; i++) {
			if(tgt[i]) {
				A_start = i;
				break;
			}
		}
		
		int B_start = -1;
		for (int i = 0; i < N; i++) {
			if(!tgt[i]) {
				B_start = i;
				break;
			}
		}
		
		if(A_start == -1 || B_start == -1) return;
		
		
		if(isConnect(A_start,tgt,true) && isConnect(B_start,tgt,false)) {
			int sumA = 0;
			for (int i = 0; i < N; i++) if(tgt[i]) sumA += people[i];
			
			
			int sumB = 0;
			for (int i = 0; i < N; i++) if(!tgt[i]) sumB += people[i];
			
			result = Math.min(result, Math.abs(sumA - sumB));
		}
		
	}
	
	static void comb(int idx) {
		// simulation
		simulation();
		if(idx == N) return;
		
		for (int i = idx; i < N; i++) {
			tgt[i] = true;
			comb(i + 1);
			tgt[i] = false;
		}
	}

}
