import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, D;
	static Gift[] gifts;
	static long answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		gifts = new Gift[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			gifts[i] = new Gift(P, V);
		}

		Arrays.sort(gifts, (Gift o1, Gift o2) -> {
			return Integer.compare(o1.P, o2.P);
		});

		int start = 0;
		int end = 1;
		long sum = gifts[start].V;
		answer = gifts[start].V;
		while(end < N && start <= end) {
			if((gifts[end].P - gifts[start].P) < D) {
				sum += gifts[end++].V;
				answer = Math.max(answer, sum);
				continue;
			}
			else {
				sum -= gifts[start++].V;
			}
		}

		System.out.println(answer);

	}

	static class Gift {
		int P, V;

		Gift(int P, int V) {
			this.P = P;
			this.V = V;
		}
	}
}
