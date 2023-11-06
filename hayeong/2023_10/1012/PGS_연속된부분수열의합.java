import java.util.Arrays;
import java.util.PriorityQueue;

public class PGS_연속된부분수열의합 {
	public static int[] solution(int[] sequence, int k) {
		PriorityQueue<Point> pq = new PriorityQueue<>(
				(p1, p2) -> p1.len == p2.len ? p1.start - p2.start : p1.len - p2.len);
		int start = 0;
		int end = 0;
		int sum = sequence[0];
		while (end < sequence.length && start <= end) {
			if (sum < k) {
				end++;
				if(end<sequence.length)
					sum += sequence[end];

			} else if (sum > k) {
				sum -= sequence[start];
				start++;
			} else {
				pq.add(new Point(start, end, end - start + 1));
				sum -= sequence[start];
				start++;
				end++;
				if(end<sequence.length)
					sum += sequence[end];
				
			}
		}

		Point result = pq.poll();
		int[] answer = {result.start, result.end};
		return answer;
	}

  
	static class Point {
		int start, end, len;

		Point(int start, int end, int len) {
			this.start = start;
			this.end = end;
			this.len = len;
		}
	}
}
