package bj.S3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_20920_영단어암기는어려워 {
	static int N, M;
	static HashMap<String, Integer> word = new HashMap<>();
	static StringBuilder sb=new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String w = br.readLine();
			if (w.length() < M) {
				continue;
			}
			// 이미 있으면 그 값에 + 1하고 아니면 처음으로 1값 추가
			word.put(w, word.getOrDefault(w, 0) + 1);
		}
		List<String> words = word.keySet().stream().collect(Collectors.toList());

		words.sort((o1, o2) -> {
			int c1 = word.get(o1);
			int c2 = word.get(o2);

			if (c1 == c2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2); // 알파벳 사전 순으로 앞에 있는 단어일수록 앞에
				}
				return o2.length() - o1.length(); // 해당 단어의 길이가 길수록 앞에
			}
			return c2 - c1; // 자주 나오는 단어일수록 앞에
		});
		
        for(int i=0; i <words.size(); i++){
            sb.append(words.get(i)).append("\n");
        }
        System.out.println(sb);
	}
}
