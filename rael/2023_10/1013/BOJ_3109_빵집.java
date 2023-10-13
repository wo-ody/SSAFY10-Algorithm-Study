import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, ans;
	static char map[][];
	static int[] dy = {-1,0,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ans=0;
		map = new char[R][C];
		
		//1. 입력
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		//풀이
		//행으로 위에서 밑으로 내려가면서 최대한 많은 파이프라인을 연결
		for(int i=0; i<R; i++) {
			if(dfs(i,0)) ans++;
		}
		
		System.out.println(ans);
	}
	
	static boolean dfs(int y, int x) {
		int nx = x + 1;		//오른족으로 항상 이동
		
		if(nx == C-1) return true;		//오른쪽 가스관과 연결.
		
		//우선 순위를 가진 연결 시도
		for(int d=0; d<3; d++) {
			int ny = y + dy[d];
			
			if(ny<0 || ny>=R || map[ny][nx] == 'x') continue;
			
			//방문 처리는 어떻게?? -> 성공 / 실패 여부 상관 없이 무조건 방문 처리 (실패여도 갈 이유가 없기 때문)
			map[ny][nx] = 'x';
			if(dfs(ny, nx)) return true;		//성공하면 더이상 탐색 X
		}
		
		return false;
	}
}
