import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

//스택에 넣고 연산자를 만날 때 마다 pop 한 두 피연산자로 연산
//A-Z -> 0~25로 매핑
//소숫점을 위해 double로 받을 예정
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Deque<Double> stack = new ArrayDeque<>();
	static double ans;
	static double[] number;

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		number = new double[N];
		for (int i = 0; i < N; i++) {
			number[i] = Double.parseDouble(br.readLine());
		}

		for (int i = 0; i < input.length(); i++) {
			char temp = input.charAt(i);
			//+
			if (temp == '+') {
				double second = stack.pop();
				double first = stack.pop();
				stack.push(first + second);
			}
			//-
			else if (temp == '-') {
				double second = stack.pop();
				double first = stack.pop();
				stack.push(first - second);
			}
			//*
			else if (temp == '*') {
				double second = stack.pop();
				double first = stack.pop();
				stack.push(first * second);
			}
			//'/'
			else if (temp == '/') {
				double second = stack.pop();
				double first = stack.pop();
				stack.push(first / second);
			}
			//number
			else {
				int num = (temp - 'A');
				stack.push(number[num]);
			}
		}
		System.out.printf("%.2f", stack.pop());
	}
}