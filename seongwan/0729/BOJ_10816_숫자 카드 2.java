import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

//		List<Integer> lst = new ArrayList<>(); // N개의 정수를 저장할 리스트
//		List<Integer> ans = new ArrayList<>(); // 개수를 셀 M개의 정수를 저장할 리스트
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> card = new HashMap<>();  //카드의 넘버와 개수를 넣을 hashmap
		for (int i = 0; i < N; i++) {

//			lst.add(Integer.parseInt(st.nextToken())); // N개 리스트에 저장
			int num = Integer.parseInt(st.nextToken());
			card.put(num, card.getOrDefault(num, 0) + 1); //카드가 나올 때마다 num의 value값을 1증가시킴

		}
		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

//		for (int i = 0; i < M; i++) {
//			ans.add(Collections.frequency(lst, st.nextToken()));
//			// lst에서 M개의 정수의 빈도값을 계산해서 ans에 저장
            //이 방법은 리스트를 계속 돌면서 탐색해야 해서 시간초과
//		}
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < M; j++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(card.getOrDefault(num, 0)).append(" ");//M개의 정수의 value값을 공백을 두고 sb에 넣음

		}
//			sb.append(i).append(" ");

		bw.write(sb.toString()); // sb의 내용을 출력
		bw.flush();
	}

}
