import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

//연결리스트로 인덱스를 인덱스를 조정해가며 구현
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static LinkedList<Character> list = new LinkedList<>();
	static int T;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String s = br.readLine();
			int index = 0;
			for (int i = 0; i < s.length(); i++) {
				char temp = s.charAt(i);
				if (temp == '<') {
					if (index != 0)
						index--;
				} else if (temp == '>') {
					if (index != list.size())
						index++;
				} else if (temp == '-') {
					if (index != 0) {
						list.remove(index - 1);
						index--;
					}
				} else {
					list.add(index, temp);
					index++;
				}
			}
			for (Character c : list) {
				sb.append(c);
			}
			sb.append("\n");
			list.clear();
		}
		System.out.println(sb);
	}
}