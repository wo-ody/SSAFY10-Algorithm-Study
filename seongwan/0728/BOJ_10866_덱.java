import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Main {

	public static void main(String[] args) throws NoSuchElementException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> deque = new LinkedList<>(); // 연결리스트로 덱 구현

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			String[] str = s.split(" ");
			if (str[0].equals("push_back")) {

				deque.addLast((Integer.parseInt(str[1])));// push_back 문자가 나올 시 덱 마지막에 다음에 나올 정수 add

			} else if (str[0].equals("push_front")) {
				deque.addFirst(Integer.parseInt(str[1]));// push_front 문자가 나올 시 처음에 다음에 나올 정수 add

			} else if (s.equals("front")) {
				System.out.println(deque.size() == 0 ? -1 : deque.peekFirst());
			} else if (s.equals("back")) {
				System.out.println(deque.size() == 0 ? -1 : deque.peekLast());
			} else if (s.equals("size")) {
				System.out.println(deque.size());
			} else if (s.equals("empty")) {
				System.out.println(deque.isEmpty() ? 1 : 0);
			} else if (s.equals("pop_back")) {
				System.out.println(deque.size() == 0 ? -1 : deque.pollLast());
			} else if (s.equals("pop_front")) {
				System.out.println(deque.size() == 0 ? -1 : deque.pollFirst());
			}

		}

	}

}