import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Main {

	public static void main(String[] args) throws NoSuchElementException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> queue = new LinkedList<>(); // 연결리스트로 큐 구현

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			String[] str = s.split(" ");
			if (str[0].equals("push_back")) {

				queue.addLast((Integer.parseInt(str[1])));// push문자가 나올 시 다음에 나올 정수 add

			} else if (str[0].equals("push_front")) {
				queue.addFirst(Integer.parseInt(str[1]));// push문자가 나올 시 다음에 나올 정수 add

			} else if (s.equals("front")) {
				System.out.println(queue.size() == 0 ? -1 : queue.peekFirst());
			} else if (s.equals("back")) {
				System.out.println(queue.size() == 0 ? -1 : queue.peekLast());
			} else if (s.equals("size")) {
				System.out.println(queue.size());
			} else if (s.equals("empty")) {
				System.out.println(queue.isEmpty() ? 1 : 0);
			} else if (s.equals("pop_back")) {
				System.out.println(queue.size() == 0 ? -1 : queue.pollLast());
			} else if (s.equals("pop_front")) {
				System.out.println(queue.size() == 0 ? -1 : queue.pollFirst());
			}

		}

	}

}