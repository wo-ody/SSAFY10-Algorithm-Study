import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_25329_학생별통화요금계산 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String time = st.nextToken();
			StringTokenizer st1 = new StringTokenizer(time, ":");
			int h = Integer.parseInt(st1.nextToken());
			int m = Integer.parseInt(st1.nextToken()) + h*60;

			String name = st.nextToken();

			if (map.containsKey(name)){
				int t = map.get(name);
				map.put(name, t+m);
			}else {
				map.put(name, m);
			}
		}
		HashMap<String, Integer> feeMap = new HashMap<>();

		for (String key : map.keySet()) {
			int time = map.get(key);
			if (time < 100) {
				feeMap.put(key, 10);
			}else {
				int fee = 10;
				time -= 100;
				int a = time/50;
				int b = time%50;
				fee += a * 3;
				if (b > 0) fee += 3;
				feeMap.put(key, fee);
			}
		}

		List<String> feeKeySet = new ArrayList<>(feeMap.keySet());

		feeKeySet.sort((o1, o2) ->
			feeMap.get(o1).equals(feeMap.get(o2))? o1.compareTo(o2) : feeMap.get(o2) - feeMap.get(o1)
		);
		StringBuilder sb = new StringBuilder();
		for (String key : feeKeySet) {
			sb.append(key).append(" ").append(feeMap.get(key)).append("\n");
		}
		System.out.println(sb);
	}
}
