import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14425 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken(" "));
		int M = Integer.parseInt(st.nextToken(" "));

		String[] test = new String[N];
		String[] S = new String[M];

		for (int i = 0; i < N; i++)
			test[i] = br.readLine();

		for (int i = 0; i < M; i++)
			S[i] = br.readLine();

		int count = 0;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (S[i].equals(test[j]))
					count++;
			}
		}
		System.out.println(count);
	}

}
