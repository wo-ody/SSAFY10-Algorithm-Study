import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        boolean[] visited = new boolean[n];
        for(int j: stations){
            getMapping(j, visited, w, n);
        }
        
        int cnt = 0;
        int result = 0;
        int size = 2*w + 1;
        for(int i = 0; i < n; i++){
            if(cnt == 0 && visited[i]) continue;
            if(visited[i]) {
                // System.out.println(i + " " + cnt + " " + Math.ceil(cnt/size));
                int quotient = cnt/size;
                int div = (cnt % size) > 0 ? 1 : 0;
                result += quotient + div;
                cnt = 0;
                continue;
            }
            cnt++;            
        }
        int quotient = cnt/size;
        int div = (cnt % size) > 0 ? 1 : 0;
        result += quotient + div;
                        
        return (int) result;
    }
    
    public void getMapping(int index, boolean[] visited, int w, int length){
        for(int z = index-1-w; z <= index-1+w; z++) {
            if(z < 0 || z >= length) continue; 
            visited[z] = true;
        }
    }
}
