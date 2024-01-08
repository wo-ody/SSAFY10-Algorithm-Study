import java.util.*;
class Solution {
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    // 연결되어 있는 영역의 번호를 저장
    static int[][] oilNumber;
    // number는 연결되어 있는 영역의 번호를 지정
    static int col, row, number;
    static HashMap<Integer, Integer> map = new HashMap<>();
    public int solution(int[][] land) {
        int answer = 0;
        col = land.length;
        row = land[0].length;

        oilNumber = new int[col][row];
        boolean[][] visited = new boolean[col][row];

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(land[c][r] == 1 && !visited[c][r]){
                    // 석유의 배열과 방문처리할 boolean 배열, x,y 좌표 전달
                    oil(land, visited, new Node(c, r));
                }
            }
        }

        for(int r = 0; r < row; r++){
            int temp = 0;
            // set을 for문 바깥에 하지 않고 내부에서 한 이유는
            // for문을 돌릴때마다 해당 열을 전부 확인해줘야 하고
            // 해당 열은 전에 확인한 열과 연관이 없기 때문에
            // 열이 바뀔때마다 set을 초기화 시켜줘야 한다.
            HashSet<Integer> set = new HashSet<>();
            for(int c = 0; c < col; c++){
                // 이번 위치의 해당되는 석유 번호를 저장
                int notDup = oilNumber[c][r];
                // notDup이 0이라면 석유가 아님
                // notDup이 set에 저장 있지 않다면 해당 석유 값에 해당되는 석유의 양을 temp에 저장
                // 만일 notDup이 set에 저장되어 있다면 이미 해당 위치에 존재하는 석유를 이미 더했기 때문에 pass
                if(!set.contains(notDup) && notDup != 0) {
                    set.add(notDup);
                    temp += map.get(notDup);
                }
            }
            answer = Math.max(answer, temp);
        }
        return answer;
    }

    void oil(int[][] pLand, boolean[][] visited, Node getNode){
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(getNode);
        int getY = getNode.y;
        int getX = getNode.x;
        // number는 0부터 시작하기 때문에 시작위치를 ++ 한 후 위치 지정
        oilNumber[getY][getX] = ++number;
        visited[getY][getX] = true;
        int result = 1;

        while(!dq.isEmpty()){
            Node node = dq.poll();
            int y = node.y;
            int x = node.x;
            for(int d = 0; d < 4; d++){
                int ny = y + dy[d];
                int nx = x + dx[d];
                if(ny < 0 || nx < 0 || ny >= col || nx >= row) continue;
                if(visited[ny][nx] || pLand[ny][nx] == 0) continue;
                // 연결되어 있는 모든 지점을 bfs를 돌기 시작한 number로 지정
                oilNumber[ny][nx] = number;
                dq.add(new Node(ny, nx));
                visited[ny][nx] = true;
                result++;
            }
        }
        // 연결되어 있는 지점의 크기를 Map에 저장
        map.put(number, result);
    }
}

class Node{
    int y, x;
    public Node(int y, int x){
        this.y = y;
        this.x = x;
    }
}
