import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {  // 10866 큐 문제와 동일
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			if (cmd.equals("push_front"))
				deque.addFirst(Integer.parseInt(st.nextToken()));
			else if (cmd.equals("push_back"))
				deque.addLast(Integer.parseInt(st.nextToken()));
			else if (cmd.equals("pop_front"))
				System.out.println(deque.isEmpty() ? -1 : deque.pollFirst());
			else if (cmd.equals("pop_back"))
				System.out.println(deque.isEmpty() ? -1 : deque.pollLast());
			else if (cmd.equals("size"))
				System.out.println(deque.size());
			else if (cmd.equals("empty"))
				System.out.println(deque.isEmpty() ? 1 : 0);
			else if (cmd.equals("front"))
				System.out.println(deque.isEmpty() ? -1 : deque.peekFirst());
			else
				System.out.println(deque.isEmpty() ? -1 : deque.peekLast());
				
		}
	}
}
