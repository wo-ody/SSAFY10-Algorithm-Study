import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static HashMap<String, PriorityQueue<Integer>> hash = new HashMap<>();
	static int q;
	static long answer = 0;

	public static void main(String[] args) throws IOException {
		q = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int code = Integer.parseInt(st.nextToken());
			String gorilla = st.nextToken();
			int amount = Integer.parseInt(st.nextToken());
			if (code == 1) {
				if (!hash.containsKey(gorilla))
					hash.put(gorilla, new PriorityQueue<Integer>((o1, o2) -> o2 - o1));
				for (int j = 0; j < amount; j++)
					hash.get(gorilla).add(Integer.parseInt(st.nextToken()));
			} else {
				if (hash.containsKey(gorilla)) {
					int limit = amount < hash.get(gorilla).size() ? amount : hash.get(gorilla).size();
					for (int j = 0; j < limit; j++)
						answer += hash.get(gorilla).poll();
				}
			}
		}
		System.out.println(answer);
	}
}
