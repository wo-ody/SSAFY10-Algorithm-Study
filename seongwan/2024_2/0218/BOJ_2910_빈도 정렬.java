import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

//수가 나오면 전에 나왔냐 안 나왔냐를 확인 후
//안 나온 수라면 리스트에 담고 맵의 key로 해서 value에 빈도를 담는다
//나왔던 수라면 map에서 빈도를 올려준다.
//다 받은 후 리스트에 나온 순서대로 키로 해서 value만큼 출력한다
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		Map<Integer, Integer> count = new HashMap<>();

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			//처음 나온 수라면
			if (!count.containsKey(temp)) {
				list.add(temp);
				count.put(temp, 1);
			}//나왔던 경우라면
			else {
				count.put(temp, count.get(temp) + 1);
			}
		}

		List<Integer> keyset = new ArrayList<>(count.keySet());
		keyset.sort((e1, e2) -> count.get(e2) == count.get(e1)
			? list.indexOf(e1) - list.indexOf(e2) : count.get(e2) - count.get(e1));

		for (Integer i : keyset) {
			for (int j = 0; j < count.get(i); j++) {
				sb.append(i + " ");
			}
		}
		System.out.println(sb);
	}
}