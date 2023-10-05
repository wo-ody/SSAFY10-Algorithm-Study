import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class boj_2164 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Deque<Integer> deque = new ArrayDeque<>();
		for(int i = 1; i <= n; i++)
			deque.add(i);
		
		while(deque.size() != 1) {  // 마지막 카드가 남을 때까지
			deque.pop();  // 맨 위의 카드 카드 제거
			deque.addLast(deque.pop());  // 이후 맨 위 카드를 맨 아래로 보냄
		}
		System.out.println(deque.pop());  // 마지막 남은 카드 제거
	}
}
