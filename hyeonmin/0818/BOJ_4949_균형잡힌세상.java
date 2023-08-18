import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949_균형잡힌세상 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>(); 
		while(true) {
			char[] c = br.readLine().toCharArray(); 
			if(c[0] == '.') break;
			stack.clear();
			boolean isYes = true;
			
			for (int i = 0; i < c.length; i++) {
				char pop;
				switch (c[i]) {
				case '(':
					stack.push('(');
					break;
				case ')':
					if(stack.isEmpty()) {
						isYes = false;
					} else {
						pop = stack.pop();
						if(pop != '(') isYes = false;
					}
					break;
				case '[':
					stack.push('[');
					break;
				case ']':
					if(stack.isEmpty()) {
						isYes = false;
					} else {
						pop = stack.pop();
						if(pop != '[') isYes = false;
					}
					break;

				default:
					break;
				}
			}
			System.out.println(isYes && stack.isEmpty() ? "yes" : "no");
		}
	}
}
