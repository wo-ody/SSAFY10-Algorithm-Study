import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<int[]> lectures = new ArrayList<>();
		int res = 0, day[] = new int[10_001];
		
		int n = Integer.parseInt(br.readLine()), p, d;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			lectures.add(new int[] {p, d});
		}
		Collections.sort(lectures, (o1, o2)->o2[1]-o1[1]); // day내림차순
		int t;
		for (int[] now : lectures) {
			p = now[0]; d = now[1];
			while (d>=1) {
				while (day[d] > p) d--;
				if (d>=1) {
					res += p - day[d];
					t = day[d]; day[d] = p; p = t;
					d--;
				}
				if (p==0) break;
			}
		}
		System.out.println(res);
	}

}
