import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int r, c;
	//0
	static List<Integer> horizontal = new ArrayList<>();
	//1
	static List<Integer> vertical = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		vertical.add(Integer.parseInt(st.nextToken()));
		horizontal.add(Integer.parseInt(st.nextToken()));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if (cmd == 0) {
				horizontal.add(num);
			} else {
				vertical.add(num);
			}
		}
		horizontal.sort((e1, e2) -> e1 - e2);
		vertical.sort((e1, e2) -> e1 - e2);

		r = horizontal.get(0);
		for (int i = 1; i < horizontal.size(); i++) {
			r = Math.max(r, horizontal.get(i) - horizontal.get(i - 1));
		}

		c = vertical.get(0);
		for (int i = 1; i < vertical.size(); i++) {
			c = Math.max(c, vertical.get(i) - vertical.get(i - 1));
		}

		System.out.println(r * c);
	}
}