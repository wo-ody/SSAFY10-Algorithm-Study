import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		List<Integer> answer = new ArrayList<>(n);
		answer.add(arr[0]);
		int[] dp = new int[n];
		dp[0] = 0;
		for (int i=1; i<n; i++) {
			if (answer.get(answer.size()-1) < arr[i]) {
				dp[i] = answer.size();
				answer.add(arr[i]);
			}else {
				dp[i] = bs(answer, arr[i]);
				answer.set(dp[i], arr[i]);
			}
		}
		int size = answer.size();
		int[] lis = new int[size];
		int target = size-1;
		for (int i=n-1; i>=0; i--) {
			if (dp[i] == target) {
				lis[target--] = arr[i];
			}
		}
		System.out.println(size);
		StringBuilder sb = new StringBuilder();
		for (int i : lis) sb.append(i).append(" ");
		System.out.println(sb);
	} // main
	static int bs(List<Integer> A, int t) {
		int l = 0, r = A.size()-1;
		int m = (l+r)/2;
		while (l!=r) {
			m = (l+r)/2;
			if (A.get(m) >= t) r=m;
			else l=m+1;
		}
		return l;
	}
}
