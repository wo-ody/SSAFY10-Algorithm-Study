//재귀?? 인가?? 일단 DFS

class Solution {
    static boolean[] visit; //방문 체크
    static int[][] d;
    static int max;
    
    public int solution(int k, int[][] dungeons) {        
        //변수 초기화
        visit = new boolean[dungeons.length];
        d = dungeons;
        max = 0;
        
        dfs(0, k);  //depth, 현재 피로도
        
        return max;
    }
    
    public static void dfs(int depth, int hp){
        //일단 계산부터? 하고 생각
        for(int i=0; i<d.length; i++){
            //최소 조건 만족하는지, 방문 체크 --> 거르기
            if(d[i][0] > hp || visit[i]) continue;
            
            //방문 체크 후 다음으로 이동
            visit[i] = true;
            dfs(depth+1, hp - d[i][1]);
            visit[i] = false;
        }
        //최대 비교
        max = Math.max(max, depth);
    }
}
