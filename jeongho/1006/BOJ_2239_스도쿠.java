package algorithm2023.oct.day05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2239_스도쿠 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int[][] board = new int[9][9];
	static ArrayList<Node> blank = new ArrayList<>();
	
	static boolean isComplete ;
	
	//칸의 좌표를 저장할 클래스
	static class Node{
		int y,x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
		
	}
	
	public static void main(String[] args) throws Exception{
		
		//입력, 0이면 빈칸배열에 저장
		for(int i =0;i<9;i++) {
			String[] s = br.readLine().split("");
			for(int j= 0;j<9;j++) {
				board[i][j] = Integer.parseInt(s[j]);
				if(board[i][j]==0)blank.add(new Node(i,j));
			}
		}
		sudoku(0);
	}
	
	
	//빈칸배열을 탐색하며 채울 수 있는 칸 채우며 반복
	static void sudoku(int idx) {
		//한번 출력했다면 더이상 실행 X ( 답이 여러개 일 때 사전순 앞서는거 출력이므로)
		if(isComplete)return;
		//모든 빈칸을 채운 경우
		if(idx==blank.size()) {
			//프린트
			print();
			//이미 출력했음을 기록
			isComplete = true;
			return;
		}
		
		Node node = blank.get(idx);
		
		//1부터 9까지의 수 중에 기록 가능한 수로 기록 후 다음 인덱스 탐색, 탐색 후에는 다시 0으로 갱신
		for(int i= 1;i<=9;i++) {
			if(isValid(node.y,node.x,i)) {
				board[node.y][node.x]= i;
				sudoku(idx+1);
				board[node.y][node.x] = 0;
			}
		}
	}
	
	static void print() {
		for(int i =0;i<9;i++) {
			
			for(int j= 0;j<9;j++) {
			System.out.print(board[i][j]);	
			}
			System.out.println();
		}
	}
	
	//n이라는 값이 y,x위치에 들어올 수 있는지 판단
	static boolean isValid(int y, int x, int n) {
		for(int i = 0;i<9;i++) {
			if(board[i][x]==n)return false;
			if(board[y][i]==n)return false;
		}
		int a = y/3*3;
		int b =x/3*3;
		for(int i =a;i<a+3;i++) {
			for(int j= b;j<b+3;j++) {
				if(board[i][j]==n)return false;
			}
		}
		
		return true;
		
	}
}
