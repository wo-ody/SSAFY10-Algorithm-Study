public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = 0;
		Map<Integer, Boolean> dict = new HashMap<>();  // hash map 생성
		
		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();  // 키 입력
			if (!dict.containsKey(k))  // map에 키가 없다면
				dict.put(k, true);  // 해당 키를 map에 추가
		}
		
		int m = sc.nextInt();  
		for (int i = 0; i < m; i++) {
			answer = (dict.containsKey(sc.nextInt())) ? 1 : 0;  // 찾고자 하는 키가 map에 있다면 1, 아니면 0
			System.out.println(answer);
		}
	}
}
