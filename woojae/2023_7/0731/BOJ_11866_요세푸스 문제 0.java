import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Deque<Integer> deque = new ArrayDeque<Integer>();
		List<Integer> arr = new ArrayList<Integer>();
		
		for(int i = 1; i < n + 1; i++)
			deque.add(i);
		
		while(deque.size() != 1) {
			for (int i = 0; i < k - 1; i++)
				deque.addLast(deque.pop());
			arr.add(deque.pop());
		}
		arr.add(deque.pop());
		String str = arr.toString();
		System.out.println("<" + str.subSequence(1, str.length()-1) + ">");
	}
}
