import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_9012_괄호 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Boolean> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		char[] c;
		for (int i = 0; i < N; i++) {
			stack.clear();
			c = br.readLine().toCharArray();
			boolean isVPS = true;
			
			for (int j = 0; j < c.length; j++) {
				if(c[j]=='(') {
					stack.push(true);
				}
				else if(c[j]==')') {
					if(stack.size()==0) {
						isVPS = false;
						break;
					}
					stack.pop();
				}
			}
			if(stack.size() > 0) {
				isVPS = false;
			}
			
			sb.append(isVPS ? "YES" : "NO").append("\n");
		}
		System.out.println(sb);
	}

}
