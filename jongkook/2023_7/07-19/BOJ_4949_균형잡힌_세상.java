package studyAuthenticating;
import java.io.*;
import java.util.*;
public class BOJ_4949_균형잡힌_세상 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true){
			String on = br.readLine();
			if(on.equals(".")) break;	
			System.out.println(solve(on));
		}
		
	}
	static String solve(String str){
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < str.length()-1; i++){
			char chr = str.charAt(i);
			if(chr == '(' || chr == '[') stack.push(chr);
			else if(chr == ')'){
				if(stack.isEmpty() || stack.peek() != '(') return "no";
				else stack.pop();
			}
			else if (chr == ']'){
				if(stack.isEmpty() || stack.peek() != '[') return "no";
				else stack.pop();
			}
		}
		if(!stack.isEmpty()) return "no";
		else return "yes";
		
	}
}
