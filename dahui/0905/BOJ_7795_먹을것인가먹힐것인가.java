import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//A,B sort 하기
//A의 숫자를 B에서 이분탐색으로 큰 쌍 개수 구하기
//A의 다음 숫자를 찾을 땐, 이 전에 찾았던 B의 숫자부터 찾기 (정렬 되있으므로 )
public class BOJ_7795_먹을것인가먹힐것인가 {
	static int T,N,M,ans;
	static int[] A;
	static int[] B;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			A = new int[N];
			B = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(B);
			
			ans = 0;
			
			for(int i=0; i<N; i++) {
				binarySearch(A[i], 0, M-1);
			}
			
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);

	}
	
	static void binarySearch(int key, int start, int end) {
		int mid;
		
		while(start <= end) {
			mid = (start+end)/2;
			if(key <= B[mid]) {
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		
		//다 돌았는데 같은 숫자가 없다면 그 때의 start 값이 개수
		ans += start;
		return;
	}

}
