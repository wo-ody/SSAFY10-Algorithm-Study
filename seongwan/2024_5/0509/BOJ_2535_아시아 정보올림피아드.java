import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class student {
		int nation;
		int num;
		int score;

		public student(int nation, int num, int score) {
			this.nation = nation;
			this.num = num;
			this.score = score;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		PriorityQueue<student> pq = new PriorityQueue<student>((e1, e2) -> e2.score - e1.score);
		int[] check = new int[N + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			pq.add(new student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())));
		}

		int count = 0;
		while (count < 3) {
			student temp = pq.poll();

			if (check[temp.nation] == 2)
				continue;

			check[temp.nation]++;
			sb.append(temp.nation).append(" ").append(temp.num).append("\n");
			count++;

		}
		System.out.println(sb);
	}
}