import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int memoi[];
	static int item[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		//memoi 초기화
		memoi = new int[K+1];		//0 dummy
		
		//item 세팅
		item = new int[N+1][2];			//0 dummy
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			item[i][0] = Integer.parseInt(st.nextToken());
			item[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//가치 합의 최댓값
		for(int i=1; i<=N; i++) {
			int w = item[i][0];
			int v = item[i][1];
			
			//큰 무게부터 작은 무게로 옮겨가기
			for(int k=K; k>=w; k--) {
				//memoi[w] => 이전까지의 최선의 값이므로 이번 것과 비교해서 업데이트
				memoi[k] = Math.max(memoi[k], memoi[k-w]+v);
			}
			
		}
		
		System.out.println(memoi[K]);
	}
}
