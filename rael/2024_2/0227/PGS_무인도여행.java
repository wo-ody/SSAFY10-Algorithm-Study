import java.util.*;

class Solution {
    static int[][] map;
    static boolean[][] visit;
    static List<Integer> cnts;
    static int cnt=0;
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        
        // 2차원 배열로 바꿀까...
        map = new int[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++){
            char[] arr = maps[i].toCharArray();
            for(int j=0; j<arr.length; j++){
                if(arr[j] == 'X')
                    map[i][j] = 0;
                else
                    map[i][j] = arr[j] - '0';
            }
        }
        // 이미 존재한 곳 -1로 바꾸기 아님 visit 쓰던가
        // bfs 돌리면서 cnt 늘리기
        cnts = new ArrayList<>();
        visit = new boolean[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                //방문 체크 및 섬 체크
                if(!visit[i][j] && map[i][j] > 0){
                    dfs(j, i);
                    cnts.add(cnt);
                    cnt=0;
                }
            }
        }
        
        if(cnts.isEmpty()){
            return new int[] {-1};
        }
        
        // 오름차순 정렬
        Collections.sort(cnts);
        answer = new int[cnts.size()];
        for(int i=0; i<cnts.size(); i++){
            answer[i] = cnts.get(i);
        }
        
        return answer;
    }
    
    public static void dfs(int x, int y){
        cnt += map[y][x];
        visit[y][x] = true;
        
        for(int d=0; d<4; d++){
            int ny = y + dy[d];
            int nx = x + dx[d];
           
            if(nx<0 || ny<0 || nx>=map[0].length || ny>= map.length)
                continue;
            
            if(!visit[ny][nx] && map[ny][nx]>0) dfs(nx, ny);
       }
    }
}
