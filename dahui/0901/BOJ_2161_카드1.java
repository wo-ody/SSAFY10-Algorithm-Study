
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n;
	static Queue<Integer> q = new ArrayDeque<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			q.add(i);
		}
		
		while(q.size()!=1) {
			System.out.print(q.poll() + " ");
			q.add(q.poll());
		}
		
		System.out.println(q.poll());

	}

}
