import java.io.*;
import java.util.*;
public class Main {
	static List<int[]> stars;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		stars = new ArrayList<>();
		int x, y;
		for (int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			stars.add(new int[] {x, y});
		}
		int ans=0, t;
		for (int[] star:stars) {
			x = star[0]; y = star[1];
			for (int i=0; i<=l; i++) {
				ans = Math.max(ans, check(x, y-i, l));
			}

		}
		System.out.println(k-ans);
	}
	
	static int check(int x, int y, int l) {
		int t=0;
		for (int[] c:stars) {
			if (x<=c[0] && c[0]<=x+l && y<=c[1] && c[1]<=y+l) t++;
		}
		return t;
	}

}
