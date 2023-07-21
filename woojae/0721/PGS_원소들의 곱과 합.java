class Solution {
    public int solution(int[] num_list) {
        int sum = 0;
        int mul = 1;
        for (int num: num_list) {
            sum += num;
            mul *= num;
        }
        return mul < Math.pow(sum, 2) ? 1 : 0;
    }
}
