import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, l;
	static int[] arr;
	static ArrayDeque<Node> dq = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			if(!dq.isEmpty() && dq.peek().idx <= i-l)  // 0번부터 시작하므로 +1 해줄 필요 없음
				dq.pollFirst();
			
			while(!dq.isEmpty() && arr[i] < dq.peekLast().val) {
				dq.pollLast();
			}
			dq.add(new Node(i, arr[i]));
			sb.append(dq.peek().val).append(" ");
		}
		System.out.println(sb);
	}
	
	static class Node {
		int idx, val;

		public Node(int idx, int val) {
			super();
			this.idx = idx;
			this.val = val;
		}
	}
}
