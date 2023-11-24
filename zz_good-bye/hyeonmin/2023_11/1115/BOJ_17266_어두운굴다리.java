package month11.day15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17266_��ο�ٸ� {
	
	static int N, M, right, left, max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 0 ~ x1 ~ x2 ~ N
		// �� ������ ���̸� ���Ѵ�.
		// �� ���� ������ �������̴� �������� ������.
		// Ȧ���̸�? �ø�     4-1=3  2
		
		left = 0;
		right = Integer.parseInt(st.nextToken());
		
		// 0���� ù��° ���ε� ����
		max = right - left;
		
		// �糡���� max �� Ž��(����), (right-left+1)/2 >> Ȧ�� ����
		for (int i = 1; i < M; i++) {
			right = Integer.parseInt(st.nextToken());
			max = Math.max(max, (right-left+1)/2);
			left = right;
		}
		
		// ������ ���ε�� N������ ����
		max = Math.max(max, N - left);
		
		System.out.println(max);
	}
}
