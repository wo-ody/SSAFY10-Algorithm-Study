package month11.day13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10431_�ټ���� {

	static int T;
	static int[] line;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken(); // ���� ��ȣ�� t�� ����ϸ� �Ǳ� ������ ������.
			
			line = new int[20];
			
			line[0] = Integer.parseInt(st.nextToken()); // ù��° �л��� ���� ����.
			
			int sum = 0;
			
			// ���� 19���� �л��� �����鼭 �ڱ� �ڸ��� ã�� ����.
			for (int i = 1; i < 20; i++) {
				int student = Integer.parseInt(st.nextToken());
				int index = findIndex(student);
				line[i] = student;
				
				// ������ �ڸ��� �����ϸ� index�� -1�� �ƴϴ�.
				if(index != -1) {
					// �л����� �о�� ����.
					// �о Ƚ�� : i(�������� �ϴ� �ڸ�) - index(�о�鼭 �����ϴ� �ڸ�)
					goIndex(i, index);
					sum += (i - index);
				}
			}
			sb.append(t).append(" ").append(sum).append("\n");
			
			// 1. ���� �л��� ������ �ڸ��� index�� ���Ѵ�.
			// 2. �� index���� ��ĭ �̵��ؾ��ϴ��� ���Ѵ�.
			// 3. ��� ������ �ݺ��ϸ� �̵�ȸ���� �ջ��Ѵ�.
		}
		System.out.println(sb);
		
	}
	
	static void goIndex(int start, int end) {
		int temp = line[start];
		for (int i = start; i > end; i--) {
			line[i] = line[i-1];
		}
		line[end] = temp;
	}
	
	static int findIndex(int student) {
		for(int i = 0; i < 20; i++) {
			if (line[i] > student) return i;
		}
		return -1; // ������ �� �ʿ䰡 ���ٸ� -1 return
	}

}
