import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

//tree맵에 값과 개수를 담아놓고 최댓값,최솟값을 firstKey,lastKey를 통해 출력하며
//각 값의 value를 1줄임 값이 0이 되면 map에서 그 키를 제거
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static TreeMap<Integer, Integer> map = new TreeMap<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			//트리맵 테스트케이스별 초기화
			map.clear();
			int k = Integer.parseInt(br.readLine());

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				char cmd = st.nextToken().charAt(0);
				int key = Integer.parseInt(st.nextToken());
				//I인 경우
				if (cmd == 'I') {
					if (!map.containsKey(key)) {
						map.put(key, 1);
					}//원래 1개 이상 있던 경우
					else {
						map.put(key, map.get(key) + 1);
					}
				}//D인 경우
				else {
					//트리맵이 비지 않은 경우만 진행
					if (!map.isEmpty()) {
						//최댓값을 빼는 경우
						if (key == 1) {
							int max = map.lastKey();
							map.put(max, map.get(max) - 1);

							//0개가 남아있다면 map에서 제거
							if (map.get(max) == 0) {
								map.remove(max);
							}
						}//최솟값을 빼는 경우
						else {
							int min = map.firstKey();
							map.put(min, map.get(min) - 1);

							//0개가 남아있다면 map에서 제거
							if (map.get(min) == 0) {
								map.remove(min);
							}
						}
					}
				}
			}
			if (map.isEmpty())
				sb.append("EMPTY" + "\n");
			else
				sb.append(map.lastKey() + " " + map.firstKey() + "\n");
		}
		System.out.println(sb);
	}
}