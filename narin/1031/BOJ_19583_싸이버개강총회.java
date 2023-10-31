import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_19583_싸이버개강총회 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		HashSet<String> member = new HashSet<>(); // 입장댓글을 단 사람을 넣을 set
		HashSet<String> result = new HashSet<>(); // 출석이 완료된 사람을 넣을 결과 set

		String[] SEQ = br.readLine().split(":| "); // : 과 공백을 기준으로 나눈다

		// 모든 시간을 hour*100+minute 해서 네자리수 로 만든다
		int S = Integer.parseInt(SEQ[0]) * 100 + Integer.parseInt(SEQ[1]); // 개강총회 시작 시각
		int E = Integer.parseInt(SEQ[2]) * 100 + Integer.parseInt(SEQ[3]); // 개강총회 종료 시각
		int Q = Integer.parseInt(SEQ[4]) * 100 + Integer.parseInt(SEQ[5]); // 스트리밍 종료 시각

		String line = ""; // 입력 받을 문장 ( 시각 이름 ) 으로 구성

		while ((line = br.readLine()) != null && !line.isEmpty()) {
			// 입력 받을 때 null 값을 받는다. -> 입력을 파일로 받는 경우
			// 입력이 비어있을 때 -> 입력을 키보드로 받는 경우

			String[] chat = line.split(":| ");

			int time = Integer.parseInt(chat[0]) * 100 + Integer.parseInt(chat[1]); // 마찬가지로 네자리수로 변경
			String name = chat[2];

			if (time <= S) // 시작시각 이전이라면
				member.add(name); // 이름을 입장댓글 단 사람들 목록에 넣는다.

			if (time >= E && time <= Q) { // 개강총회 종료 ~ 스트리밍 종료 사이 시각일 때
				if (member.contains(name)) // 입장댓글을 단 사람이라면
					result.add(name); // 출석 완료. 결과 set에 넣는다.
			}
		}

		System.out.println(result.size());
	}
}
