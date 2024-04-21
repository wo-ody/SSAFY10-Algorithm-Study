class PGS_타겟넘버 {
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers,0,0,target);
        return answer;
    }
    

    //더하는 경우와 빼는 경우 dfs
    public int dfs(int[] numbers, int idx, int ret, int target){
        int cnt = 0;
        if(idx==numbers.length){
            if(ret == target){
                return 1;
            }else{
                return 0;
            }
            
        }
        
        cnt+=dfs(numbers, idx+1, ret+numbers[idx], target);
        cnt+=dfs(numbers, idx+1, ret-numbers[idx], target);
        return cnt;
    }
    
    
}