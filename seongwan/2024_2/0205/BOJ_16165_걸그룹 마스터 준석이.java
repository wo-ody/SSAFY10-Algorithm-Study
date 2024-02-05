import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

//팀의 이름을 키로 멤버의 리스트를 맵으로 관리
//멤버의 이름을 키로 팀의 이름을 맵으로 관리
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static Map<String, List<String>> team = new HashMap<>();
	static Map<String, String> memberTeam = new HashMap<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String teamName = br.readLine();

			int count = Integer.parseInt(br.readLine());
			List<String> members = new ArrayList<>();
			for (int j = 0; j < count; j++) {
				String member = br.readLine();
				members.add(member);
				memberTeam.put(member, teamName);
			}
			members.sort((e1, e2) -> e1.compareTo(e2));
			team.put(teamName, members);
		}

		for (int i = 0; i < M; i++) {
			String question = br.readLine();
			int category = Integer.parseInt(br.readLine());
			if (category == 1) {
				sb.append(memberTeam.get(question) + "\n");
			} else {
				for (String s : team.get(question)) {
					sb.append(s + "\n");
				}
			}
		}
		System.out.println(sb);
	}
}