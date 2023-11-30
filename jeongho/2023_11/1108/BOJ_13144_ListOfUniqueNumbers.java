package algorithm2023.nov.day08;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13144_ListOfUniqueNumbers {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		boolean[] v = new boolean[100001];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			arr[i] = n;
		}
		int idx = 0;
		v[arr[idx]] = true;
		q.add(arr[idx++]);
		long ans = 0;
		while (idx < N) {
			int n = arr[idx++];
			if (v[n]) {
				ans += q.size();
				while (q.peek() != n) {
					v[q.peek()] = false;
					q.poll();
					ans += q.size();
				}
				q.poll();
			}
			v[n] = true;
			q.offer(n);

		}
		while(!q.isEmpty()) {
			ans+=q.size();
			q.poll();
		}
		System.out.println(ans);

	}

}