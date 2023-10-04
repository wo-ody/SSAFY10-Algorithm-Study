import java.util.Stack;

class Solution {
	public String solution(int n, int k, String[] cmd) {
		Stack<Integer> point = new Stack<Integer>();
		int size = n;

		for (int i = 0; i < cmd.length; i++) {
			String[] temp = cmd[i].split(" ");
			switch (temp[0]) {
			case "D":
				k += Integer.parseInt(temp[1]);
				break;
			case "U":
				k -= Integer.parseInt(temp[1]);
				break;
			case "C":
				point.push(k);
				size--;
				if (k == size)
					k--;
				break;
			case "Z":
				if (point.pop() <= k)
					k++;
				size++;
				break;
			}
		}

		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < size; i++) answer.append("O");
		while (!point.isEmpty()) answer.insert(point.pop(), "X");
		return answer.toString();
	}
}
