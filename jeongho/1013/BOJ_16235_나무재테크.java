package algorithm2023.oct.day12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16235_나무재테크 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N,M,K,map[][], A[][];
	static LinkedList<Tree> tree = new LinkedList<>();
	static ArrayDeque<Tree> dead = new ArrayDeque<>();
	
	static int[] dx = {-1,-1,-1,0,1,1,1,0};
	static int[] dy= {-1,0,1,1,1,0,-1,-1};
	
	static class Tree{
		int x,y,z;

		public Tree(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public String toString() {
			return "Tree [x=" + x + ", y=" + y + ", z=" + z + "]";
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		//땅의 기본 양분은 5
		for(int i = 0;i<N;i++) {
			Arrays.fill(map[i], 5);
		}
		//S2D2가 땅에 공급할 양분 정보
		A = new int[N][N];
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j= 0;j<N;j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//나무의 정보
		for(int i =0;i<M;i++) {
			
			// 좌표 x,y정보와 나이 z
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			tree.add(new Tree(x,y,z));
		}
		
		
		
		for(int i = 0;i<K;i++) {
			
			//나이가 작은 나무부터 보기 위해 정렬
			Collections.sort(tree,(o1,o2)->{
				return o1.z-o2.z;
			});
			
			//봄
			//나무가 자신의 나이만큼 양분을 먹고 나이가 1 증가, 한칸에 여러 나무가 있다면 나이가 어린 나무부터
			spring();
			
			//여름
			//봄에 죽은 나무가 양분으로 변함. 죽은 나무의 나이 / 2 가 나무가 있던 칸에 양분으로 추가.
			summer();
			
			//가을
			//나이가 5의 배수인 나무 번식
			//인접한 8개의 칸에 나이가 1인 나무 생성
			fall();
			
			//겨울
			//S2D2가 땅에 양분 추가. 각 칸에 추가되는 양분은 A[r][c]
			winter();
			
		}
		System.out.println(tree.size());
	}
	
	static void spring() {
		//나무를 나이가 어린 순으로 순회
		//해당하는 칸에 양분이 있다면 먹고 칸의 양분 감소
		//없다면 죽은것으로 기록
		Iterator<Tree> iter = tree.iterator();
		
		while(iter.hasNext()) {
			Tree t = iter.next();
			int x = t.x;
			int y = t.y;
			int z = t.z;
			
			 if(map[x][y]>=z) {
				 map[x][y]-=z;
				 t.z++;
			 }else {
				 dead.add(t);
				 iter.remove();
			 }
		}
		
		
		
	}
	static void summer() {
		//죽은 나무를 순회하며 양분으로 추가
		while(!dead.isEmpty()) {
			Tree t = dead.poll();
			int x = t.x;
			int y = t.y;
			int z = t.z;
			
			map[x][y]+=z/2;
		}
	}
	static void fall() {
		Queue<Tree> q  =new LinkedList<>();
		//모든 나무를 순회하며 나이가 5의 배수인지 확인
		//맞다면 번식
		Iterator<Tree> iter = tree.iterator();
		while(iter.hasNext()) {
			Tree t = iter.next();
			if(t.z%5==0) {
				for(int d= 0;d<8;d++) {
					int nx = t.x+dx[d];
					int ny = t.y+dy[d];
					if(isValid(nx,ny)) {
						q.add(new Tree(nx,ny,1));
					}
				}
			}
		}
		while(!q.isEmpty()) {
			tree.add(q.poll());
		}
	}
	static void winter() {
		//A배열의 값만큼 map에 값 추가
		
		for(int i= 0;i<N;i++) {
			for(int j =0;j<N;j++) {
				map[i][j]+=A[i][j];
			}
		}
		
	}
	
	static boolean isValid(int x, int y) {
		if(x<0||y<0||x>=N||y>=N)return false;
		return true;
	}
}
