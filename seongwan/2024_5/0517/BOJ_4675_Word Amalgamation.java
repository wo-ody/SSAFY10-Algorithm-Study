import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<String, PriorityQueue<String>> map = new HashMap<>();

		while (true) {
			String temp = br.readLine();

			if (temp.equals("XXXXXX"))
				break;

			char[] ch = temp.toCharArray();
			Arrays.sort(ch);
			String key = new String(ch);

			if (!map.containsKey(key)) {
				map.put(key, new PriorityQueue<>());
				map.get(key).add(temp);
			} else
				map.get(key).add(temp);
		}

		while (true) {
			String temp = br.readLine();

			if (temp.equals("XXXXXX"))
				break;

			char[] ch = temp.toCharArray();
			Arrays.sort(ch);
			String key = new String(ch);

			if (!map.containsKey(key)) {
				sb.append("NOT A VALID WORD").append("\n").append("******").append("\n");
			} else {
				int size = map.get(key).size();
				for (int i = 0; i < size; i++) {
					sb.append(map.get(key).poll()).append("\n");
				}
				sb.append("******").append("\n");
			}
		}
		System.out.println(sb);
	}
}