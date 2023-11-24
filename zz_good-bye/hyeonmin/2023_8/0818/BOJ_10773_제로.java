import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773_제로 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int K = Integer.parseInt(br.readLine());
		int sum = 0;
		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n != 0) {
				stack.push(n);
			} else {
				stack.pop();
			}
		}
		
		while(!stack.isEmpty()) sum+=stack.pop();
		
		System.out.println(sum);
		
	}

}
