import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] num;
	static int[] memo;
	
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		num = new int[N+1];
		memo = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) num[i] = Integer.parseInt(st.nextToken());
	
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				if(num[j] < num[i]) memo[i] = Math.max(memo[j] + 1,memo[i]);
			}
			result = Math.max(result, memo[i]);
		}
		
		System.out.println(result);
	}

}
