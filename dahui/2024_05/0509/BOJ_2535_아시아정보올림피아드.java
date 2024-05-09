import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_2535_아시아정보올림피아드 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> count = new HashMap<>();
		ArrayList<Node> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int country = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			count.put(country, 0);
			list.add(new Node(country, number, score));
		}

		Collections.sort(list, (o1, o2) -> o2.score - o1.score);
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		int cnt = 0;
		while(true) {
			if (cnt == 3) break;

			Node node = list.get(idx);
			if (count.get(node.country) < 2) {
				sb.append(node.country).append(" ").append(node.num).append("\n");
				cnt++;
				count.put(node.country, count.get(node.country) + 1);
			}
			idx++;
		}
		System.out.println(sb);
	}

	public static class Node {
		int country, num, score;
		public Node(int country, int num, int score) {
			this.country = country;
			this.num = num;
			this.score = score;
		}
	}
}
