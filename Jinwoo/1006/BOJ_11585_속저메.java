import java.util.*;
import java.io.*;
public class BOJ_11585_속저메 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] P = br.readLine().toCharArray();
		br.readLine().toCharArray();
		
		int[] Pi = new int[n]; int j=0;
		for (int i=1; i<n; i++) {
			while (j>0 && P[i<<1]!=P[j<<1]) j = Pi[j-1];
			if (P[i<<1]==P[j<<1]) Pi[i] = ++j;
			else j=0;
		}

		int t = n-j;
		StringBuilder sb = new StringBuilder();
		if (t!=0 && n%t == 0) sb.append(1).append("/").append(t);
		else sb.append(1).append("/").append(n);
		System.out.println(sb);
	}

}
