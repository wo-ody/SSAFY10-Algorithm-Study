import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, K, count, answer;
	static boolean stop;
	static List<Belt> queue = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] tmp = new int[2*N];
		
		// 벨트 초기화 
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<2*N; i++) {
			tmp[i] = Integer.parseInt(st.nextToken());
		}
		
		// 나머지 2 ~ N*2 벨트들 초기화 
		for(int i=2*N-1; i>=0; i--) {
			queue.add(new Belt(false, tmp[i]));
		}
		
		// 내구도가 0인 칸의 개수가 K보다 작을 경우 step1 ~ step4 반복 
		while(check()) {
			step1();
			step2();
			step3();
			answer++;
		}
		System.out.println(answer);
	}
	
	// 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 가장 처음 수행되는 단계는 1번째 단계이다.
	static boolean check() {
		int cnt = 0;
		for(int i=0; i<2*N; i++) {
			if(queue.get(i).getDurability() == 0) cnt++;
			if(cnt >= K) return false;
		}
		return true;
	}
	
	// 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
	static void step1(){
		Belt tmpBelt = queue.remove(0);
		tmpBelt.setRobot(false);
		queue.add(tmpBelt);
	
	}
	
	// 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다.
	// 만약 이동할  없다면 가만히 있는다.
	// 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1이상 남아있어야 한다.
	static void step2(){
		
		queue.get(N).setRobot(false);
		
		for(int i = N; i < 2*N-1; i++) {
			int durability = queue.get(i).getDurability();
			
			if(durability > 0 && !queue.get(i).isRobot()) {
				if(queue.get(i+1).isRobot()) {
					queue.get(i).setDurability(durability-1);
					queue.get(i).setRobot(true);
					queue.get(i+1).setRobot(false);
				}
			}
		}
		
	}
	
	// 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
	static void step3(){
		int durability = queue.get(2*N-1).getDurability();
		if(durability > 0) {
			queue.get(2*N-1).setDurability(durability-1);
			queue.get(2*N-1).setRobot(true);
		}
	}
	
	// 벨트 클래스 
	static class Belt{
		boolean robot;
		int durability;
		
		Belt(boolean robot, int durability){
			this.robot = robot;
			this.durability = durability;
		}

		public boolean isRobot() {
			return robot;
		}

		public void setRobot(boolean robot) {
			this.robot = robot;
		}

		public int getDurability() {
			return durability;
		}

		public void setDurability(int durability) {
			this.durability = durability;
		}
	}
}
