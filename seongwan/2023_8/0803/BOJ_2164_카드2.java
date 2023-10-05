import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static Deque<Integer> card = new ArrayDeque<Integer>();// deque로 카드 덱 구현
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception, IOException {
		int N = Integer.parseInt(br.readLine());
		for (int i = N; i >= 1; i--) {

			card.push(i);
		} // 카드 덱 채우기
		card_shuffle();// 결과물 출력
	}

	static void card_shuffle() {
		card.pop();
		if (card.size() == 1) {
			System.out.println(card.pop()); // 1장 남을 때 결과물 출력
			return;
		} else if (card.size() == 0) {
			System.out.println(1);
			return;
		} // 1을 입력한 경우
		card.addLast(card.pollFirst());
		card_shuffle();// 재귀를 통한 반복
	}
}
