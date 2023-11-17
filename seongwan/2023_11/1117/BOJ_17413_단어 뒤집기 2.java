import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringBuilder temp = new StringBuilder();

	public static void main(String[] args) throws Exception {
		char[] input = br.readLine().toCharArray();
		for (int i = 0; i < input.length; i++) {
			if (input[i] == '<') {// 태그가 열린 경우
				sb.append(temp.reverse()); // 현재까지 입력된 단어들 뒤집어서 sb에 저장
				temp.setLength(0);
				sb.append(input[i]);
				while (true) {
					i++;
					sb.append(input[i]);
					if (input[i] == '>')// 태그가 닫힐 때까지 입력 후 break
						break;
				}
			} else if (input[i] == ' ') { // 공백이 나온 경우 현재까지 입력된 단어들 뒤집어서 sb에 저장 후 공백을 붙임
				sb.append(temp.reverse() + " ");
				temp.setLength(0);
			} else {
				temp.append(input[i]);
			}

		}
		sb.append(temp.reverse() + " "); // 입력되지 않은 단어들 뒤집어서 저장 후 출력
		System.out.println(sb);
	}
}
