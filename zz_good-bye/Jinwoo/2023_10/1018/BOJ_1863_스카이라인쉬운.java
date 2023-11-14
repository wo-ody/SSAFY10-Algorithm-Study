import java.util.*;
import java.io.*;
public class BOJ_1863_스카이라인쉬운{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int ans=0, y;
		Deque<Integer> q = new ArrayDeque<>();
		q.add(0);
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			y = Integer.parseInt(st.nextToken());
			if (q.peekLast()<y) {
				ans++;
				q.add(y);
			}else {
				while (q.size()>0 && q.peekLast()>y) q.pollLast();
				if (q.peekLast() == y) continue;
				ans++;
				q.add(y);
			}
		}
		System.out.println(ans);
	}//main
}
