import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

public class BOJ_2002_추월 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		HashMap<Integer, String> map = new HashMap<>();
		HashMap<String, Integer> map1 = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();
		HashMap<Integer, String> map3 = new HashMap<>();
		HashSet<String> car = new HashSet<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			map.put(i, str);
			map1.put(str, i);
		}

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			map2.put(str, i);
			map3.put(i, str);
		}

		for (int i = 0; i < N; i++) {
			String str = map.get(i);
			int num = map2.get(str);
			for (int j = i; j < num; j++) {
				String s = map3.get(j);
				if (map1.get(s) > i) car.add(s);
			}
		}
		System.out.println(car.size());
	}
}
