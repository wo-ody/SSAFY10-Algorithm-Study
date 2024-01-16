import java.io.BufferedReader;
import java.io.InputStreamReader;

//분수의 분모 +1 -> 분자+1 뒤-1 *1 -> 분자+1 ->분자-1 뒤+1 *2 ->... 반복
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int X, cnt = 0, up = 1, down = 1;

	public static void main(String[] args) throws Exception {
		X = Integer.parseInt(br.readLine());
		boolean chk = false;
		int i = 1;
		while (true) {
			if (X == i)
				break;
			cnt++;
			if (!chk) {
				i++;
				down++;
				if (X == i)
					break;
				for (int j = 0; j < cnt; j++) {
					i++;
					up++;
					down--;
					if (X == i)
						break;
				}
			} else {
				i++;
				up++;
				if (X == i)
					break;
				for (int j = 0; j < cnt; j++) {
					i++;
					up--;
					down++;
					if (X == i)
						break;
				}
			}
			chk = !chk;
		}
		System.out.println(up + "/" + down);
	}
}