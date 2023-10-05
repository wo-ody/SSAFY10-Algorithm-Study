
public class 덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] visited = new boolean[n+1];
        for(int i = 0; i<section.length ;i++){
            if(!visited[section[i]]){
                int start = section[i];
                int end =start + m -1;
                if(end > n){
                    int diff = end - n;
                    start -=diff;
                    end -=diff;
                }
                for(int j = start; j<=end; j++){
                    visited[j] = true;
                }
                answer++;
            }
        }
        return answer;
    }
}
