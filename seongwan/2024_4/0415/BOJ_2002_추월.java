import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//map에 차량 번호를 키로 순서를 값으로 저장 후
//나온 차량의 순서가 기본 순서보다 앞에 있다면 추월한 차로 판단
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, ans;
	static Map<Integer, String> input = new HashMap<>();
	static Map<String, Integer> inputb = new HashMap<>();
	static Map<Integer, String> outputorder = new HashMap<>();
	static Map<String, Integer> output = new HashMap<>();
	static Set<String> col = new HashSet<>();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			input.put(i, s);
			inputb.put(s, i);
		}

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			output.put(s, i);
			outputorder.put(i, s);
		}

		for (int i = 0; i < N; i++) {
			for (int j = i; j < output.get(input.get(i)); j++) {
				String temp = outputorder.get(j);
				if (inputb.get(temp) > i) {
					col.add(temp);
				}
			}
		}

		System.out.println(col.size());
	}
}