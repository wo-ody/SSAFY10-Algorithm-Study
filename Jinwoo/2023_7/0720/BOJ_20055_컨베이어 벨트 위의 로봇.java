import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static Queue<Integer> robot = new LinkedList<>();
	static int roLen;
	static int n;
	static int k;
	static int[] belt;
	public static void main(String[] args) {
		n = sc.nextInt();
		k = sc.nextInt();
		belt = new int[n*2];
		for (int i=0; i<n*2; i++) {
			belt[i] = sc.nextInt();
		}
		int up = 0, down = n-1;
		int ans = 0;
		int roLen = 0;
		while (k > 0) {
			up = turn(up);
			down = turn(down);
			int c = roLen;
			for (int i=0; i<c; i++) {
				int rob = robot.poll();
				if (rob == down) {
					roLen--;
					continue;
				}
				int arob = go(rob);
				if (arob == down) {
					roLen--;
					continue;
				}else robot.add(arob);
			}
			if (!robot.contains(up) && belt[up]>0) {
				belt[up]--;
				if (belt[up] == 0) k--;
				robot.add(up);
				roLen++;
			}
			ans++;
		}
		System.out.println(ans);
	} // main
	
	public static int turn(int b) {
		if (b==0) return 2*n-1;
		return b-1;
	}
	
	public static int go(int b) {
		int a = (b==2*n-1)? 0:b+1;
		if (!robot.contains(a) && belt[a] > 0) {
			belt[a]--;
			if (belt[a] == 0) k--;
			return a;
		} else {
			return b;
		}
	}
}