class Solution {
    static int answer=0;
    public int solution(int[] numbers, int target) {
        
        dfs(-numbers[0],1,numbers,target);
        dfs(numbers[0],1,numbers,target);
        
        return answer;
    }
    public static void dfs(int num, int order, int[] numbers, int target){
        if(order == numbers.length) {
            if(num == target){
                answer++;
            }
        }else{
            dfs(num-numbers[order],order+1,numbers,target);
            dfs(num+numbers[order],order+1,numbers,target);
        }
    }
}
