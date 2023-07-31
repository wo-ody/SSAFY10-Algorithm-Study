import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			if (order.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				Queue.push(num);
			} else if (order.equals("pop")) {
				System.out.println(Queue.pop());
			} else if (order.equals("size")) {
				System.out.println(Queue.size());
			} else if (order.equals("empty")) {
				System.out.println(Queue.empty());
			} else if (order.equals("front")){
				System.out.println(Queue.front());
			} else {
				System.out.println(Queue.back());
			}
		}

	}
	static class Queue{
		private static int[] queue = new int[10001];
		private static int front = 0;
		private static int back= 0;
		
		static void push(int X) {
			queue[back++] = X;
		}

		static int pop() {
			if (front < back)
				return queue[front++];
			return -1;
		}

		static int size() {
			return back - front;
		}

		static int empty() {
			if (back-front <= 0) {
				return 1;
			} else {
				return 0;
			}
		}

		static int front() {
			if (back-front <= 0) {
				return -1;
			}
			return queue[front];
		}
		
		static int back() {
			if (back-front <= 0) {
				return -1;
			}
			return queue[back-1];
		}
	}
}
