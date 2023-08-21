import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int w = 0, b = 0;
	static String[][] paper;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		paper = new String[n][n];
		for(int i = 0; i < n; i++) 
			paper[i] = br.readLine().split(" ");
		
		solution(0, 0, n);
		System.out.println(w + "\n" + b);
	}
	
	static void solution(int y, int x, int size) {
		String check = paper[y][x];
		boolean flag = true;
		loop1:
		for(int i = y; i < y + size; i++)  // 주어진 영역에서
			for(int j = x; j < x + size; j++) {
				if(!paper[i][j].equals(check)) {  // 전부 탐색하는데 하나라도 기준 색과 다르다면
					flag = false;  // 해당 영역은 동일한 숫자로 이루어져 있지 않음
					break loop1;
				}
			}

		if(flag) {  // 별다른 반복의 종료없이 반복이 종료되었다면 모두 동일한 색으로 이루어졌다는 것을 의미
			if(check.equals("0")) w++;
			else b++;
			return;
		}
		int half_size = size / 2;  // 영역별로 쪼갬
		solution(y, x, half_size);
		solution(y, x + half_size, half_size);
		solution(y + half_size, x, half_size);
		solution(y + half_size, x + half_size, half_size);
	}
}
