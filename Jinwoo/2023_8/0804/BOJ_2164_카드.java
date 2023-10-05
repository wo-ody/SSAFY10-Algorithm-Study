package hwalgo04_부울경_3반_최진우;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
public class bj_2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Deque<Integer> q = new ArrayDeque<>();
		for (int i=1; i<=n; i++) q.add(i);
		int num =0;
		for (int i=0; i<n; i++) {
			num = q.poll();
			if (!q.isEmpty()) q.add(q.poll());
		}
		System.out.println(num);
	}
}
