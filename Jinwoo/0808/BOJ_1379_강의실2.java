import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer[]> l = new ArrayList<>();
		for (int i = 0;i<n;i++) {
			String[] st = br.readLine().split(" ");
			l.add(new Integer[] {Integer.parseInt(st[1]), Integer.parseInt(st[2]), Integer.parseInt(st[0])-1});
		}
		Collections.sort(l,(o1, o2) -> o1[0]-o2[0]);
		PriorityQueue<Integer[]> q = new PriorityQueue<>((o,t)->o[0]-t[0]);
		int room =1, eroom;
		q.add(new Integer[] {l.get(0)[1], room++});
		int[] lecture = new int[n];
		lecture[l.get(0)[2]] = 1;
		for (int i=1; i<n;i++) {
			Integer[] lec = l.get(i);
			if (q.peek()[0] <= lec[0]) {
				eroom = q.poll()[1];
				q.add(new Integer[] {lec[1], eroom});
				lecture[lec[2]] = eroom;
			}else {
				q.add(new Integer[] {lec[1], room++});
				lecture[lec[2]] = room-1;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(q.size()).append("\n");
		for (int i :lecture) sb.append(i).append("\n");
		System.out.println(sb);
	}
}
