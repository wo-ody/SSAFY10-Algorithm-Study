import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18258_큐2 {

	static int N, X;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			switch(str.charAt(1)) {
			case 'u' : // push
				st = new StringTokenizer(str);
				st.nextToken();
				X = Integer.parseInt(st.nextToken());
				queue.offer(X);
				break;
			case 'o' : // pop
				sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
				break;
			case 'i' : // size
				sb.append(queue.size()).append("\n");
				break;
			case 'm' : // empty
				sb.append(queue.isEmpty() ? 1 : 0).append("\n");
				break;
			case 'r' : // front
				sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
				break;
			case 'a' : // back
				sb.append(queue.isEmpty() ? -1 : X).append("\n");
				break;
			}
		}
		
		System.out.println(sb);
	}
	

}
