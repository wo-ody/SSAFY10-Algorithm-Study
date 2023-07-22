class Solution {
    public int solution(int[] num_list) {
        String odd = "";
        String even = "";
        
        for (int num : num_list) {
            if (num % 2 != 0)
                odd += String.valueOf(num);
            else
                even += String.valueOf(num);
        }
        return Integer.valueOf(odd) + Integer.valueOf(even);
    }
}
