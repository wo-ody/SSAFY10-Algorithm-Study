package studyAuthenticating;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874_스택_수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Integer> Stack = new Stack<Integer>();
		Stack<Character> result = new Stack<Character>();
		int line = Integer.parseInt(br.readLine());
		int increase = 1;
		boolean valid = true;
		
		for (int i = 0; i < line; i++) {
			int value = Integer.parseInt(br.readLine());
			
			while(increase <= value){
				result.push('+');
				Stack.push(increase);
				increase++;
			}
			
			if (Stack.peek() == value){
				result.push('-');
				Stack.pop();				
			}
			else{
				valid = false;
				break;
			}
		}
		
		if (valid) for(char chr : result) System.out.println(chr);
		else System.out.println("NO");
	}

}
