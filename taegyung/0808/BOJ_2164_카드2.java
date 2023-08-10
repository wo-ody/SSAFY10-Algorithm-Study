package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_2164_카드2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		while (queue.size() > 1) {
			queue.poll();
			queue.offer(queue.poll());

		}

		System.out.println(queue.poll());
	}
}
