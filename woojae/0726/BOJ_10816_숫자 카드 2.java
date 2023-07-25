import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		HashMap<Integer, Integer> cards = new HashMap<Integer, Integer>();
		int k = 0;
		
		for(int i = 0; i < n; i++) {
			k = sc.nextInt();
			if (cards.containsKey(k))
				cards.put(k, cards.get(k) + 1);
			else
				cards.put(k, 1);
		}
		
		int m = sc.nextInt();
		for(int i = 0; i < m; i++) {
			k = sc.nextInt();
			if (cards.containsKey(k))
				sb.append(cards.get(k)).append(' ');
			else
				sb.append(0).append(' ');
		}
			
		System.out.println(sb.toString().substring(0, sb.length() - 1));
	}
}
