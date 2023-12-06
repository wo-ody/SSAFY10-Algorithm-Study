import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int answer = 0;
	static int N; 
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			while(h < stack.peek()) {
				stack.pop();
			}
			if(h > stack.peek()) {
				stack.push(h);
				answer += 1;
			}
		}
		System.out.println(answer);
		
		

	}

}
