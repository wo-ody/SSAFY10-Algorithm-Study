import java.util.*;
import java.io.*;
public class BOJ_27172_수나누기게임 {
	static int[] X = new int[1000001];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] ans = new int[N];
		for (int i=1; i<=N; i++) X[Integer.parseInt(st.nextToken())] = i;
		for (int i=1; i<1000001; i++) {
			if (X[i]==0) continue;
			for (int j=i<<1;j<1000001; j+=i) {
				if (X[j]!=0) {ans[X[i]-1]++; ans[X[j]-1]--;}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int a : ans) sb.append(a).append(" ");
		System.out.println(sb);
	}

}
