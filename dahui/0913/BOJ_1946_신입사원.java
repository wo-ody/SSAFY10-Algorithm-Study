import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Grade implements Comparable<Grade> {
	int a;
	int b;

	Grade(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public int compareTo(Grade o) {
		if(this.a > o.a) {
			return 1;
		} else {
			return -1;
		}
	}
}

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			ArrayList<Grade> list = new ArrayList<>();

			for(int i = 0; i < N; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();

				list.add(new Grade(a, b));
			}

			Collections.sort(list);

			int ans = 1; // 서류 1등은 무조건 통과 
			int min = list.get(0).b; // 면접 점수 최소값 
			for(int i = 1; i < N; i++) {
				if(list.get(i).b < min) { // 이전의 최소 면접 점수보다 낮으면 통과 
					ans++;
					min = list.get(i).b; // 최소 점수 갱신 
				}
			}
			System.out.println(ans);
		}	
	}
}
