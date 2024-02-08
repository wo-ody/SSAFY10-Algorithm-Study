import java.io.BufferedReader;
import java.io.InputStreamReader;

//홀수면 창영이 승 짝면 상근이 승
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		if (N % 2 == 1) {
			System.out.println("CY");
		} else
			System.out.println("SK");
	}
}