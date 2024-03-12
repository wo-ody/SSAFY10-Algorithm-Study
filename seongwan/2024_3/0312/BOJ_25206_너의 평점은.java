import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Map<String, Double> score = new HashMap<>();
	static double sum;
	static double calSum;

	public static void main(String[] args) throws Exception {
		init();

		for (int i = 0; i < 20; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			double credit = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();

			//P성적 과목은 무시
			if (grade.equals("P")) {
				continue;
			}

			sum += credit;
			calSum += credit * score.get(grade);
		}

		System.out.println(calSum / sum);
	}

	static void init() {
		score.put("A+", 4.5);
		score.put("A0", 4.0);
		score.put("B+", 3.5);
		score.put("B0", 3.0);
		score.put("C+", 2.5);
		score.put("C0", 2.0);
		score.put("D+", 1.5);
		score.put("D0", 1.0);
		score.put("F", 0.0);
	}
}