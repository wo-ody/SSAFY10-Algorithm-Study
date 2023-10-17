package algorithm2023.april;

/*  
 * ���̵� : 
 * ���̵��: 
 * �ð����⵵:
 * �ҿ� �ð�: 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class S1_BOJ1713_0420 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int K;
	static int ts = 0;
	static ArrayList<student> q = new ArrayList<>();

	static void addN(int n) {
		student s = new student(n,1,ts++);
		if (q.isEmpty()) {
			q.add(s);
		} else {
			for (int i = 0; i < q.size(); i++) {
				// �ش� �л��� �̹� �ִٸ�
				if (q.get(i).n == n) {
					s.cnt = q.get(i).cnt + 1;
					s.time = q.get(i).time;
					// ��õ ���� 1 �ø���
					q.remove(i);
					// ���� ����Ʋ���� ����
					if (q.isEmpty()) {
						// ����Ʋ�� ������ �������� �ٷ� �߰��ϰ� ����
						q.add(s);
						return;
					}
					break;
				}
			}
			int idx = 0;
			//������ �߰��� �ε���
			for(int i = 0;i<q.size();i++) {
				if(q.get(i).cnt>s.cnt) {
					idx++;
				}else if(q.get(i).cnt==s.cnt) {
					if(q.get(i).time>s.time) {
						idx++;
					}
				}
			}
			if(idx>N-1) {
				//N���� ���� ���� ����� ��쿣 �ش� ���� ���� ���� ������ �����ؾ� �ϱ� ������ �� ���� �߰�
				idx--;
			}
			q.add(idx, s);
			if(q.size()>N) {
				///�� �� ��� ������ �ε��� ����
				q.remove(q.size()-1);
			}
			
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(s[i]);
			addN(n);
			/*
			for(student student : q) {
				bw.write(student.n+" ");
			}
			bw.write("\n"+n+"�߰�\n");
			*/
		}
		//bw.write("\n");
		
		ArrayList<Integer> ans = new ArrayList<>();

		for (student student : q) {
			ans.add(student.n);
		}
		
		Collections.sort(ans);
		for (int num : ans) {
			bw.write(num + " ");
		}
		bw.flush();
		bw.close();
	}
	
	static class student{
		private int n;
		private int cnt;
		private int time;
		
		student(int n, int cnt, int time){
			this.n = n;
			this.cnt = cnt;
			this.time = time;
		}
	}
	
}