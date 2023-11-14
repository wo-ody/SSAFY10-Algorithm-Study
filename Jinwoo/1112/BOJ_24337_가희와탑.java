import java.io.*;
import java.util.*;
public class BOJ_24337_가희와탑 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		if (a+b-1>n) {
			System.out.println(-1);
			return;
		}
		StringBuilder sb = new StringBuilder();
		int dummy = n-a-b+1;
		if (a!=1) {
			for (int i=0; i<dummy; i++) sb.append(1).append(" ");
			for (int i=1; i<a; i++) sb.append(i).append(" ");
			sb.append(Math.max(a,b)).append(" ");
			for (int i=b-1; i>0; i--) sb.append(i).append(" ");
		} else {
			sb.append(b).append(" ");
			for (int i=0; i<dummy; i++) sb.append(1).append(" ");
			for (int i=b-1; i>0; i--) sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}
