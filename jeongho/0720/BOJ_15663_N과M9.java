import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_15663_N과M9{
	static int N;
	static int M;
	static int[] nums;
	static ArrayList<String> arr = new ArrayList<>();
	static boolean[] v;
	static int[] ans;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("C:\\Users\\JH\\git\\Algorithm\\Baekjoon\\src\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		nums = new int[N];
		
		s = br.readLine().split(" ");
		//숫자 입력
		for(int i = 0;i<N;i++) {
			nums[i] = Integer.parseInt(s[i]);
		}
		//사전순 정렬을 위해 숫자 배열 먼저 정렬
		Arrays.sort(nums);
		
		//답을 저장할 배열 및 방문배열 초기화
		ans = new int[M];
		v = new boolean[N];
		//dfs(백트래킹)
		dfs(0);
		System.out.println(sb);
	}
	
	static void dfs(int cnt) {
		
		//M개를 골랐으면 답 배열 StringBuilder에 Append
		if(cnt==M) {
			for(int n : ans) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		//이전에 추가된 값이랑 같은 값이 추가되면 중복 탐색이 일어나므로 이전 추가된 값을 저장할 before 추가
		int before = 0;
		
		for(int i = 0;i<N;i++) {
			//방문하지 않았고 바로 이전에 추가된 값이 아니라면 탐색
			if(!v[i]&&before!=nums[i]) {
				v[i] = true;
				ans[cnt] = nums[i];
				//이전에 추가된 값 갱신
				before = nums[i];
				dfs(cnt+1);
				v[i] = false;
				
			}
		}
	}
}
