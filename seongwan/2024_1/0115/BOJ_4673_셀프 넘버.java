//1부터 시작해서 d(n) 무한 수열을 만들면서 나온 수를 체크하고
//계속해서 나오지 않은 수를 출력하고 그 수로부터 시작해서 무한 수열을 만드는 걸 반복한다

public class Main {
	static boolean[] check = new boolean[10001];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		for (int i = 1; i <= 10000; i++) {
			if (!check[i]) {// 무한 수열을 구하면서 체크되지 않았다면
				sb.append(i + "\n");
				check[i] = true;
				int num = i;
				while (true) {
					int sum = num;
					sum += num / 10000;
					num %= 10000;
					sum += num / 1000;
					num %= 1000;
					sum += num / 100;
					num %= 100;
					sum += num / 10;
					sum += num % 10;
					if (sum > 10000)
						break;
					num = sum;
					check[num] = true;
				}
			}
		}
		System.out.println(sb);
	}
}