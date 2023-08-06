import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		for(int i = 1; i < n + 1; i++) {
			HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
			int g = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < g; j++) {  // 단순 Hash 사용 문제
				int guest = Integer.parseInt(st.nextToken());
				if(!dict.containsKey(guest))
					dict.put(guest, 1);
				else
					dict.put(guest, dict.get(guest) + 1);
			}
			List<Integer> arr = new ArrayList<>(dict.keySet());  // 혼자 오는 인원은 무조건 고정이므로 정답 반환을 위해 정렬 수행, 정렬을 하기 위한 리스트 변환
			Collections.sort(arr, (o1, o2)->dict.get(o1) - dict.get(o2));  // 리스트의 키로 Hash를 만들고 각 키에 대한 값으로 오름차순 정렬
			System.out.printf("Case #%d: %d\n", i, arr.get(0));  // 혼자 오는 인원의 키가 필요하며 정렬은 리스트로 했기 때문에 get을 통해 접근
		}
	}
}
