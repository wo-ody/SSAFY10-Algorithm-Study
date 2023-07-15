public class PGS_첫_번째로_나오는_음수 {
    public static void main(String[] args) {
        int[] num_list = {12, 4, 15, 46, 38, -2, 15};
        PGS_첫_번째로_나오는_음수_Solution solution = new PGS_첫_번째로_나오는_음수_Solution();
        System.out.println(solution.solution(num_list));
    }
}

class PGS_첫_번째로_나오는_음수_Solution {
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
