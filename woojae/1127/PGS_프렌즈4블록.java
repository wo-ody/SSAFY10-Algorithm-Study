import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class pgs_프렌즈4블록 {
	public static void main(String[] args) {
		int m = 4, n = 5;
		String[] board = {
				"CCBDE", 
				"AAADE", 
				"AAABF", 
				"CCBBF"};
		Solution problem = new Solution();
		System.out.println(problem.solution(m, n, board));

	}

}

class Solution {
	static int[][] direction = {{1, 0}, {1, 1}, {0, 1}};
	static List<int[]> target, blocks;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] temp_board = new char[m][n];
        for(int i = 0; i < m; i++)
        	temp_board[i] = board[i].toCharArray();
        target = new ArrayList<>();
        
        while(true) {
	        search(m, n, temp_board);  // 제거될 블록 탐색
	        if(target.isEmpty())  // 더 이상 제거할 블록이 없다면
	        	break;  // 게임 종료
	        eliminate(temp_board);  // 블록 제거
	        move(m, n, temp_board);  // 남은 블록 이동
        }
        
        for(int i = 0; i < m; i++)  // 사라진 블록의 수 카운팅
        	for(int j = 0; j < n; j++)
        		if(temp_board[i][j] == '0')
        			answer += 1;
        return answer;
    }
    
    static void search(int m, int n, char[][] board) {  // 탐색
    	for(int i = 0; i < m-1; i++) {  // 탐색 범위를 고려해서 각각 -1만큼 보정
    		for(int j = 0; j < n-1; j++) {
    			blocks = new ArrayList<>();  // 4블록을 구성하는 블록들을 저장할 리스트
    			blocks.add(new int[] {i, j});  // 현재 블록 추가
    			for (int[] d : direction)  // 4블록인지 판별하기 위해서는 현재 블록 기준 하단, 우측 하단 대각, 우측을 확인하면 됨 
					if(board[i][j] != '0' && board[i][j] == board[i + d[0]][j + d[1]])  // 블록이 존재하고 현재 블록과 같은 블록이라면
						blocks.add(new int[] {i + d[0], j + d[1]});  // 해당 위치의 블록 추가
    			if(blocks.size() == 4) {  // 방금의 탐색에서 4블록을 달성했다면
    				target.addAll(blocks);  // 제거하기 위해 리스트에 블록의 위치들을 추가
    				blocks.clear();  // 다음 탐색을 위해 리스트 초기화
    			}	
    		}
    	}
    }
    
    static void eliminate(char[][] board) {  // 제거
    	for (int[] c : target)  // 제거할 블록들의 위치를 순회하며
			board[c[0]][c[1]] = '0';  // 제거됐다는 의미로 0으로 변경 => 주어진 문제에서는 블록을 대문자 알파벳을 사용
    	target.clear();  // 현재 게임에서의 블록들은 다 제거했으므로 다음 게임을 위해 리스트 초기화
    }
    
    static void move(int m, int n, char[][] board) {  // 이동
    	Stack<Character> s = new Stack<>();  // 제거되고 남은 블록들을 위에서 아래로 이동시킴
    	for(int i = 0; i < n; i++) {  // x축
    		for(int j = 0; j < m; j++)  // y축
    			if(board[j][i] != '0')  // 남은 블록이라면 스택에 저장
    				s.add(board[j][i]);
    		for(int j = m-1; j >= 0; j--)  // 스택에 저장이 다 끝나면 아래에서부터 다시 블록을 채움
    			board[j][i] = !s.isEmpty() ? s.pop() : '0';  // 이때 스택이 비었다면 더 이상 내릴 블록이 없다는 의미이므로 0으로 변경
    	}
    }
}
