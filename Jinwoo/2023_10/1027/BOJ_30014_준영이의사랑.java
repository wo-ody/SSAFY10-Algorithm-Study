import java.io.*;
import java.util.*;
public class BOJ_30014_준영이의사랑 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		int[] brr = new int[n];
		int a=0;
		for (int i=1; i<n; i+=2) brr[a++] = arr[i];
		for (int i=n%2==0?n-2:n-1; i>=0; i-=2) brr[a++] = arr[i];
		int ans = brr[0]*brr[n-1];
		for (int i=1; i<n; i++) ans += brr[i]*brr[i-1];
		
		StringBuilder sb = new StringBuilder();
		sb.append(ans).append("\n");
		for (int i=0; i<n; i++) sb.append(brr[i]).append(" ");
		System.out.println(sb);
	}
}
