package month10.day23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719_빗물 {

	static int H, W, sum;
	
	static int[] height;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// (1 ≤ H, W ≤ 500)
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		height = new int[W];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < W; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		// 양끝은 계산할 필요 없음
		for (int i = 1; i < W-1; i++) {
			int start = 0;
			int end = 0;
			
			for (int j = 0; j < i; j++) {
				start = Math.max(height[j], start);
			}
			
			for (int j = i + 1; j < W; j++) {
				end = Math.max(height[j], end);
			}
			
			if( height[i] < start && height[i] < end ) {
				sum += Math.min(start, end) - height[i];
			}
		}
		System.out.println(sum);
		
	}
	
}
