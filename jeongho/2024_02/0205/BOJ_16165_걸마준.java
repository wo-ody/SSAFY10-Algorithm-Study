package algorithm2024.feb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_16165_걸마준 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Map<String, ArrayList<String>> teamMap = new HashMap<>();
		Map<String, String> memberMap = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String team = br.readLine();
			int cnt = Integer.parseInt(br.readLine());
			teamMap.put(team, new ArrayList<>());
			for (int j = 0; j < cnt; j++) {
				String name = br.readLine();
				teamMap.get(team).add(name);
				memberMap.put(name, team);
			}
			Collections.sort(teamMap.get(team));
		}

		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			int kind = Integer.parseInt(br.readLine());
			switch (kind) {
				//팀의 이름
				case 0:
					List<String> memberList = teamMap.get(name);
					for (String s : memberList) {
						sb.append(s).append("\n");
					}
					break;
				case 1:
					sb.append(memberMap.get(name)).append("\n");
					break;
			}
		}
		System.out.println(sb);

	}
}
