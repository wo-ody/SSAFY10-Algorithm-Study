package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202_보석_도둑_2 {

	public static class Jewel {
		int weight;
		int value;

		Jewel(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		PriorityQueue<Jewel> jewel = new PriorityQueue<>((o1, o2) -> {
			return o1.weight - o2.weight;
		});
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

//			Jewel j = new Jewel(weight, value);
			jewel.add(new Jewel(weight, value));
		}
		int[] bags = new int[K];

		for (int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}

		// 입력 완료
		// 이제 원하는 조건에 따라 정렬하는걸 만들어야겠다.

		// 가장 작은 가방부터 채울지 큰 가방부터 채울지 생각해보자
		Arrays.sort(bags); // 작은 가방부터 채우자

		PriorityQueue<Jewel> checkedJewel = new PriorityQueue<>((o1, o2) -> {
			return o2.value - o1.value; // 가치가 높은 순으로 들어올 것.
		});

		long sum = 0;

		for (int i = 0; i < K; i++) { // 작은 가방부터 확인하자

			while (!jewel.isEmpty() && jewel.peek().weight <= bags[i]) {// 확인하는 보석을 넣을 수 있으면

				checkedJewel.add(jewel.poll()); // 충분히 넣을 수 있는 checkedJewel에 넣는다.
			}
			if (!checkedJewel.isEmpty())
				sum += checkedJewel.poll().value;
		}

		System.out.println(sum);

	}
}
