package algorithm2023.aug.day09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1021_회전하는큐 {
	static int N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		LinkedList<Integer> list = new LinkedList<>();
		st = new StringTokenizer(br.readLine(), " ");
		int cnt = 0;
		for(int i = 1;i<=N;i++) {
			list.offer(i);
		}
		int idx = 0;
		for(int i = 0;i<M;i++) {
			int n = Integer.parseInt(st.nextToken());
			int nIdx = list.indexOf(n);
			int diff1 = Math.max(idx, nIdx) - Math.min(idx, nIdx);
			
			int diff2 = (list.size()-Math.max(idx, nIdx))+Math.min(idx, nIdx);
			cnt+=Math.min(diff1, diff2);
			idx = nIdx;
			list.remove(nIdx);
			
		}
		System.out.println(cnt);
	}
}
