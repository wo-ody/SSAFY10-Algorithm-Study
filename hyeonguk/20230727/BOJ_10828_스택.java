import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			if(order.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				Stack.push(num);
			}else if(order.equals("pop")) {
				System.out.println(Stack.pop());
			}else if(order.equals("size")) {
				System.out.println(Stack.size());
			}else if(order.equals("empty")) {
				System.out.println(Stack.empty());
			}else {
				System.out.println(Stack.top());
			}
		}
	}
	static class Stack {
	private static int[] stack = new int[10000];
	private static int point = -1;

	static void push(int X) {
		point += 1;
		if (point < 10000)
			stack[point] = X;
	}

	static int pop() {
		if(point > -1)
			return stack[point--];
		return -1;
	}

	static int size() {
		return point + 1;
	}

	static int empty() {
		if (point == -1) {
			return 1;
		} else {
			return 0;
		}
	}
	static int top() {
		if(point < 0) {
			return -1;
		}
		return stack[point];
	}
}
}
