import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15235_OlympiadPizza {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			q.add(new int[]{Integer.parseInt(st.nextToken()), i});
		}
		int[] ans = new int[N];
		int time = 1;
		while(!q.isEmpty()) {
			int[] a = q.poll();
			int cnt = a[0];
			int person = a[1];
			if (cnt-1 == 0) {
				ans[person] = time;
			}else {
				q.add(new int[]{cnt-1, person});
			}
			time++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(ans[i]).append(" ");
		}
		System.out.println(sb);
	}
}
