import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, m;
	static int[] sanggeun_card, deck;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		sanggeun_card = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) sanggeun_card[i] = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		deck = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) deck[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(sanggeun_card);
		for(int i = 0; i < m; i++)
			sb.append(bs(deck[i])).append(" ");
		System.out.println(sb);
	}
	
	static int bs(int target) {
		int low = 0;
		int high = n - 1;
		int mid = 0;
		
		while(low <= high) {
			mid = (low + high) / 2;
			if(sanggeun_card[mid] == target)
				return 1;
			else if(target < sanggeun_card[mid])
				high = mid - 1;
			else
				low = mid + 1;
		}
		return 0;
	}
}
