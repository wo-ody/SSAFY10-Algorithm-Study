import java.io.*;
import java.util.*;
public class 연습장 {
	static int[] d = new int[3];
	static int[] p = new int[3];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		int r, g, b;
		int[] t;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			d[0] = Math.min(p[1], p[2]) + r;
			d[1] = Math.min(p[0], p[2]) + g;
			d[2] = Math.min(p[1], p[0]) + b;
			t = d; d=p; p=t;
		}
		System.out.println(Math.min(p[0], Math.min(p[1], p[2])));
	}

}
