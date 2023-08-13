import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] st = br.readLine().split(" ");
		Deque<Integer> q = new ArrayDeque<>(); //사실은 Stack
		int now;
		int[] ans = new int[n];
    
		for (int i=n-1; i>=0; i--) { // 거꾸로 오른쪽 부터 탐색
			now = Integer.parseInt(st[i]);
			while (!q.isEmpty() && q.peek() <= now) q.poll(); // 현재 보다 작은 수 다 제거
			ans[i] = q.isEmpty() ? -1:q.peek(); // 이제까지 본 수 중 가까운 Ai보다 큰 수
			q.push(now); // 현재 수 저장
		}
    
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<n; i++) sb.append(ans[i]).append(" ");
		System.out.println(sb);
	}
}
