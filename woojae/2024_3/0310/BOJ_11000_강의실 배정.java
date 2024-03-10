import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PriorityQueue<time> pq = new PriorityQueue<>(((o1, o2) -> o1.end-o2.end));
	static ArrayList<time> info;
	static int n;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		info = new ArrayList<>();

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			info.add(new time(start, end));
		}

		info.sort(Comparator.comparingInt(o -> o.start));
		pq.add(info.get(0));

		for(int i = 1; i < n; i++) {
			if(info.get(i).start >= pq.peek().end)  // 다음 수업의 시작 시간이 현재 수업이 끝난 직후나 이후라면
				pq.poll();  // 현재 수업 제거
			pq.add(info.get(i));  // 다음 수업으러 갱신(현재 강의실로) or 새로운 강의실 배정
		}
		System.out.println(pq.size());  // 마지막에 남아 있는 수업들 기준으로 강의실의 수 확인
	}

	static class time {
		int start;
		int end;

		public time(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
