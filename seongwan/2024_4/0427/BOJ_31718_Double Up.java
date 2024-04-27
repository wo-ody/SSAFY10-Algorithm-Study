import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, ans;
	static int[] input;
	static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		for (Integer i : input) {
			int temp = divide(i);
			if (!map.containsKey(temp)) {
				map.put(temp, 1);
			} else {
				map.put(temp, map.get(temp) + 1);
			}
			ans = Math.max(ans, map.get(temp));
		}
		System.out.println(ans);
	}

	static int divide(int n) {
		while (n % 2 == 0) {
			n /= 2;
		}
		return n;
	}
}