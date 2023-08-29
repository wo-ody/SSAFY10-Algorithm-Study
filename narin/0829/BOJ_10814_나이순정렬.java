import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		String[][] person = new String[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			person[i][0] = st.nextToken();
			person[i][1] = st.nextToken();
		}

		Arrays.sort(person, new Comparator<String[]>() {
			@Override
			public int compare(String[] p1, String[] p2) {
				if (p1[0] == p2[0]) {
					return p1[1].compareTo(p2[1]);
				} else {
					return Integer.parseInt(p1[0]) - Integer.parseInt(p2[0]);
				}
			}
		});

		for (int i = 0; i < N; i++) {
			System.out.println(person[i][0] + " " + person[i][1]);
		}
	}
}
