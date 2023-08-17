package algorithm2023.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G5_BOJ1916_0530 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	static int[][] bus;
	static int[] costs;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		bus = new int[N + 1][N + 1];
		//������ �׷��� �������� ����.
		
		
		costs = new int[N + 1];
		//�ּ� ������ ������ �迭.
		
		
		Arrays.fill(costs, 100000000);
		//�ʱ� ���� ��� ������ �ִ� ������� �ٴ� ���� 100000000���� �ʱ�ȭ
		
		
		for(int i = 0;i<N+1;i++) {
			Arrays.fill(bus[i], 100000000);
			//���� ���� �ʱ�ȭ
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			bus[a][b] = Math.min(bus[a][b], cost);
			
		}

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		find(a, b, 0);
		System.out.println(costs[b]);

	}

	static void find(int start, int dest, int cost) {
		PriorityQueue<cost> pq = new PriorityQueue<>((e1,e2)->{
			//���ͽ�Ʈ�� ����� �켱���� ť -> Ŭ������ ���ϱ� ���� �� �Լ� ����
			if(e1.cost>e2.cost) {
				return e1.cost-e2.cost;
			}else {
				return e2.cost-e1.cost;
			}
		}); 
		
		pq.add(new cost(start,0));
		while(!pq.isEmpty()) {
			//���ͽ�Ʈ��
			cost c = pq.poll();
			for(int i =1;i<=N;i++) {
				int dist = c.cost+bus[c.num][i];
				if(costs[i]>dist) {
					costs[i]=dist;
					pq.add(new cost(i,dist));
				}
			}
		}
		
	}
	
	static class cost{
		int num;
		int cost;
		cost(int num, int cost){
			this.num = num;
			this.cost = cost;
		}
	}
}