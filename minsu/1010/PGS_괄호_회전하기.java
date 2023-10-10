package programmers.Lv2;

import java.util.Stack;

public class PGS_괄호_회전하기 {
	public int solution(String s) {
		int answer = 0;
		String new_s = s;
		for (int i = 0; i < s.length(); i++) {
			if (checkString(new_s))
				answer++; // 올바른 괄호 순서로 구성되어 있는지 파악
			new_s = new_s.substring(1, s.length()) + new_s.charAt(0); // 문자열을 한칸 이동 시켜 진행
		}

		return answer;
	}

	boolean checkString(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			try {
				switch (s.charAt(i)) {
				case '[':
					stack.add('[');
					break;
				case ']':
					if (stack.peek() != '[')
						return false;
					stack.pop();
					break;
				case '{':
					stack.add('{');
					break;
				case '}':
					if (stack.peek() != '{')
						return false;
					stack.pop();
					break;
				case '(':
					stack.add('(');
					break;
				case ')':
					if (stack.peek() != '(')
						return false;
					stack.pop();
					break;
				}
			} catch (Exception e) {
				return false;
			}

		}
		return stack.isEmpty() ? true : false;
	}

	public static void main(String[] args) {
		System.out.println(new PGS_괄호_회전하기().solution("[](){}"));
	}
}




