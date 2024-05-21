import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2217_로프 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(list, Collections.reverseOrder());
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, list.get(i) * (i + 1));
		}
		System.out.println(ans);
	}
}
