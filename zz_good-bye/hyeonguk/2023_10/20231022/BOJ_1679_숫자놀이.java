import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K, maxNum;
	static int[] nums, memoi;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());	
		nums = new int[N];
        
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			maxNum = Math.max(maxNum, nums[i]);
		}
		
		K = Integer.parseInt(br.readLine());
		memoi = new int[maxNum * K + 2];
        
        // 풀이
		for (int i=1; i<memoi.length; i++) {
			memoi[i] = Integer.MAX_VALUE;
			for (int j=0; j<N; j++) {
				if (nums[j] <= i) {
					memoi[i] = Math.min(memoi[i], memoi[i-nums[j]] + 1);
				}
			}
			if (memoi[i] > K) {
				if (i % 2 == 0)
					sb.append("holsoon");
				else
					sb.append("jjaksoon");
				sb.append(" win at ");
				sb.append(i);
				break;
			}
		}	
		System.out.println(sb);
	}
}
