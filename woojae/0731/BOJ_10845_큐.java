import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {  // 예외 처리 필수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> q = new ArrayDeque();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			if (cmd.equals("push"))
				q.add(Integer.parseInt(st.nextToken()));
			else if (cmd.equals("pop"))
				System.out.println(q.isEmpty() ? -1 : q.poll());  // poll은 삭제 후 반환
			else if (cmd.equals("size")) 
				System.out.println(q.size());
			else if (cmd.equals("empty")) 
				System.out.println(q.isEmpty() ? 1 : 0);
			else if (cmd.equals("front"))
				System.out.println(q.isEmpty() ? -1 : q.peek());
			else
				System.out.println(q.isEmpty() ? -1 : q.getLast());
		}
	}
}
