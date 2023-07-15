class Solution2 {
    public int solution(int[] num_list) {
        int answer = 0;
        for(int num: num_list) {
            if (num < 0) {
                return answer;
            }
            answer += 1;
        }
        return -1;
    }
}