import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		for(int i=0; i<K; i++) {
			int temp = Integer.parseInt(br.readLine());

			if(temp == 0) {
				stack.pop();
			}
			else {
				stack.push(temp);
			}

		}

		int sum = 0;
		for(int num : stack) {
			sum += num;
		}

		System.out.println(sum);

	}
}
