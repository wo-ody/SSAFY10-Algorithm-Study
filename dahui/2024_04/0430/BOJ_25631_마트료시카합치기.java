import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_25631_마트료시카합치기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		int ans = 1;
		int cnt = 1;
		for (int i = 1; i < N; i++) {
			if (arr[i] == arr[i-1]) cnt++;
			else {
				ans = Math.max(ans, cnt);
				cnt = 1;
			}
			if (i == N-1) ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
}
