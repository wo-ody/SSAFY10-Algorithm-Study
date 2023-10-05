import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int a, b;
	
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		int[][] arr = new int[t][2];
		
		for(int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			a = arr[i][0];
			b = arr[i][1];
			bfs(a);
		}
		System.out.println(sb);
	}
	
	static void bfs(int input) {
		Queue<Data> q = new ArrayDeque<>();
		boolean[] visit = new boolean[10000];
		String[] cmds = {"D", "S", "L", "R"};
		int modify_num = 0;
		q.add(new Data(input, ""));
		
		while(!q.isEmpty()) {
			Data temp = q.poll();
			if(temp.num == b) {  // 계산할 값이 목적값이 되었다면
				sb.append(temp.cmd).append("\n");  // 종료
				return;
			}
			for (int i = 0; i < 4; i++) {  // 큐에서 제거된 값은 항상 DSLR을 거침
				modify_num = operate(i, temp.num);  // 각 명령어에 따라 로직 수행
				if(!visit[modify_num]) {  // 해당 값이 처음 계산된 값이라면
					visit[modify_num] = true;
					q.add(new Data(modify_num, temp.cmd + cmds[i]));  // 다음 계산을 위해 저장, cmd는 계속해서 계승됨
				}
			}	
		}
	}
	
	static int operate(int op_num, int n) {
		switch (op_num) {
		case 0: return D(n);
		case 1: return S(n);
		case 2: return L(n);
		case 3: return R(n);
		}
		return 1;
	}
	
	static int D(int n) {
		return n * 2 > 9999 ? (n * 2) % 10000 : n * 2;
	}
	
	static int S(int n) {
		return n == 0 ? 9999 : n - 1;  // n이 0일 때 수행해야 하는데 n - 1일 때 수행하게 해서 계속 틀림
	}
	
	static int L(int n) {
		return (n % 1000) * 10 + (n / 1000);  // L연산 시, 나머지는 * 10은 왼쪽으로 밀려난 수가 되며 몫은 끝자리가 됨
	}
	
	static int R(int n) {
		return (n % 10) * 1000 + (n / 10);  // R연산 시, 나머지는 * 1000은 첫 수가 되며 몫은 오른쪽으로 밀려난 자리가 됨
	}
	
	static class Data {
		int num;
		String cmd;
		
		Data(int num, String cmd) {
			this.num = num;
			this.cmd = cmd;
		}
	}

}
