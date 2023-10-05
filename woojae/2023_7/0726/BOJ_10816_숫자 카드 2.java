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
			k = sc.nextInt();  // 데이터 입력
			if (cards.containsKey(k))  // 입력된 데이터가 있다면
				cards.put(k, cards.get(k) + 1);  // 해당 데이터의 수 갱신
			else
				cards.put(k, 1);  // 없다면 1로 초기화
		}
		
		int m = sc.nextInt();
		for(int i = 0; i < m; i++) {
			k = sc.nextInt();  // 데이터 입력
			if (cards.containsKey(k))  // 입력된 데이터가 있다면
				sb.append(cards.get(k)).append(' ');  // 출력을 위해 저장
			else
				sb.append(0).append(' ');  // 없다면 0 저장
		}
			
		System.out.println(sb.toString().substring(0, sb.length() - 1));  // 출력 형태에 맞춰 포매팅
	}
}
