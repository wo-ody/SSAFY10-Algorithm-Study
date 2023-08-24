/*
 *  08.24 김창희
 *  BOJ_1918_후위표기식
 *
 *  [풀이]
 *  1.연산자 마다 우선순위를 다르게 하여 식을 구성한다. *와/가 +와-보다 우선순위를 높게한다.
 *  2.연산자가 들어오면 스택에 들어오는 연산자의 우선위가 가장 커야하므로, 작거나 큰 연산자는 pop해 정답에 더해준다\
 *  3.괄호같은 경우는 먼저 계산되어야하므로 )괄호가 들어오면 (괄호가 나올때까지 우선으로 연산을 진행해야한다
 *  4. 연산자의 우선순위를 일반적으로 따지다 )가 들어오면 (가 나올때까지 스택에서 pop한다. 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static char[] exp;
	static StringBuilder answer = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		exp = br.readLine().toCharArray();
		makePostfix();
		System.out.println(answer);
	}

	public static void makePostfix() {
		Deque<Character> stack = new ArrayDeque<>();
		
		for (char c : exp) {
			if (c == '+' || c == '-' || c == '*' || c == '/') {
				int val = operatorToInt(c);
				while (!stack.isEmpty() && stack.peek() != '(') {
					int compVal = operatorToInt(stack.peek());
					if (val > compVal) break;
					answer.append(stack.pop());
				}
				stack.push(c);
				
			}else if(c=='(') {
				stack.push(c);
			}else if(c==')') {
				while(stack.peek() != '(') answer.append(stack.pop());
				stack.pop();
			}else {
				answer.append(c);
			}
		}
		
		int expLen = exp.length;
		for(int i =0; i<expLen; i++) {
			
		}

		while (!stack.isEmpty()) answer.append(stack.pop());
	}

	public static int operatorToInt(char operator) {
		if(operator == '+' ||operator == '-')  return 1;
		return 2;
	}
}
