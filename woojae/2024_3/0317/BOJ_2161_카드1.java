import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static ArrayDeque<Integer> cards = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException{
		n = Integer.parseInt(br.readLine());
		for(int i = 1; i <= n; i++)
			cards.add(i);
		
		while(cards.size() != 1) {
			sb.append(cards.poll()).append(" ");
			cards.add(cards.poll());
		}
		sb.append(cards.peek());
		
		System.out.println(sb);
	}

}
