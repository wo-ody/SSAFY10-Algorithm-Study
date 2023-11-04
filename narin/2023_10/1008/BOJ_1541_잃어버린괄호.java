import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");

		List<String> calc = new ArrayList<>();

		while (st.hasMoreTokens()) {
			calc.add(st.nextToken());
		}

		int result = 0;

		for (String str : calc) {
			st = new StringTokenizer(str, "+");
			int sum = 0;

			while (st.hasMoreTokens()) {
				sum += Integer.parseInt(st.nextToken());
			}
			
			if (str == calc.get(0)) {
				result += sum;
			} else {
				result -= sum;
			}
		}

		System.out.println(result);

	}
}
