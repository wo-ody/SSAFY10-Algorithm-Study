import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//subset, dfs
public class Main {
	static int N, min;
	static int matrix[][];
	//subset
	static boolean select[];
	//dfs
	static boolean visit[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		matrix = new int[N+1][N+1];
		select = new boolean[N+1];
		visit = new boolean[N+1];
		
		//인원수 파악
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			matrix[i][0] = Integer.parseInt(st.nextToken());
		}
		
		//인접 행렬
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j=1; j<=num; j++) {
				int v = Integer.parseInt(st.nextToken());
				matrix[i][j] = v;
			}
		}
		
		//subset
		min = Integer.MAX_VALUE;
		subset(1);		//1부터 (0 dummy)
		
		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}
	
	static void subset(int srcIdx) {
		//기저조건
		if(srcIdx == N) {
			//complete code
			check();
			return;
		}
		
		//선택
		select[srcIdx] = true;
		subset(srcIdx+1);
		//비선택
		select[srcIdx] = false;
		subset(srcIdx+1);
	}
	
	static void check() {
		//방문 체크 초기화
		Arrays.fill(visit, false);
		
		//선택된 집합 A
		int a = -1;
		for(int i=1; i<=N; i++) {
			if(select[i] == true) {
				a = i;
				break;
			}
		}
		//아무것도 선택되지 않은 경우
		if(a == -1) return;
		
		//dfs로 연결되었는지 확인
		dfs(a, true);		//v, select여부
		
		//비선택 집합 B
		int b = -1;
		for(int i=1; i<=N; i++) {
			if(select[i] == false) {
				b = i;
				break;
			}
		}
		//아무것도 선택되지 않은 경우
		if(b == -1) return;
		
		//연결되었는지 확인
		dfs(b, false);		//v, select여부
		
		//모두 연결 되었는지 확인
		for(int i=1; i<=N; i++) {
			if(!visit[i]) return;
		}
		
		//두 그룹으로 나뉘고, 서로 연결되었는지도 확인 완료.
		//인원수 차이 구하기
		int sumA=0;
		int sumB=0;
		for(int i=1; i<=N; i++) {
			if(select[i]) {
				sumA += matrix[i][0];
			}
			else {
				sumB += matrix[i][0];
			}
		}
		
		min = Math.min(min, Math.abs(sumA-sumB));
	}
	
	static void dfs(int v, boolean s) {
		//방문체크
		visit[v] = true;
		
		for(int i=1; i<=N; i++) {
			int adj = matrix[v][i];
			if(adj != 0 && !visit[adj] && select[adj]==s)
				dfs(adj, s);
		}
	}
}
