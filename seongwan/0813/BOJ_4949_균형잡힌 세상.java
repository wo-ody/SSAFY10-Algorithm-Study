import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static String s;
	static char[] ch;
	static Deque<Character> stack = new ArrayDeque<Character>();
	static boolean chk;

	public static void main(String[] args) throws IOException {
		while (true) {
			chk = false;
			stack.clear();// 문자열마다 스택을 비우고 시작함
			s = br.readLine();
			if (s.equals("."))
				break;// .이 입력되면 종료
			ch = s.toCharArray();
			for (int i = 0; i < ch.length; i++) {
				if (chk)
					break;
				check(ch[i]);
			} // 입력 받은 String을 char배열로 만들어서 한 문자씩 비교
		}
		System.out.println(sb);
	}

	static void check(char c) {
		if (c == ')')
			if (stack.isEmpty() || stack.pop() != '(') {// 여는 괄호가 나오지 않았거나 맞는 괄호가 아니었을 때
				sb.append("no\n");
				chk = true;// 문자열 탐색이 다 되었는지를 표시
			}

		if (c == ']')
			if (stack.isEmpty() || stack.pop() != '[') {// 여는 괄호가 나오지 않았거나 맞는 괄호가 아니었을 때
				sb.append("no\n");
				chk = true;
			}

		if (c == '(' || c == '[')
			stack.push(c);
		if (c == '.')
			if (stack.isEmpty())
				sb.append("yes\n");
			else
				sb.append("no\n");

	}// 괄호 유효성 체크

}
