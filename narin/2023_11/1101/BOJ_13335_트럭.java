import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] trucks = new int[n];
		int time = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			trucks[i] = Integer.parseInt(st.nextToken());
		}

		int idx = 0;
		int weight = 0;

		Queue<Integer> bridge = new ArrayDeque<>();

		for (int i = 0; i < w; i++) {
			bridge.add(0);
		}

		while (true) {

			if (idx == n)
				break;

			weight -= bridge.poll();

			int truck = trucks[idx];

			if (weight + truck <= L) {
				bridge.add(truck);
				weight += truck;
				idx++;
			} else {
				bridge.add(0);
			}

			time++;
		}

		System.out.println(time + w);
	}
}
