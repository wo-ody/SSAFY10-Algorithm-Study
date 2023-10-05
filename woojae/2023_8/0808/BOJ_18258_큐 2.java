import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		Deque<Integer> deque = new ArrayDeque<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		String cmd = "";
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			cmd = st.nextToken();
			if(cmd.equals("push"))
				deque.add(Integer.parseInt(st.nextToken()));
			else if(cmd.equals("pop"))
				sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
			else if(cmd.equals("size"))
				sb.append(deque.size()).append("\n");
			else if(cmd.equals("empty"))
				sb.append(deque.isEmpty() ? 1 : 0).append("\n");
			else if(cmd.equals("front"))
				sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
			else
				sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
		}
		System.out.println(sb);
	}
}
