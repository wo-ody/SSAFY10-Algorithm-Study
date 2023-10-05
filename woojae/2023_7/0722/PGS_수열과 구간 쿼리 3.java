class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int idx1 = 0;
        int idx2 = 0;
        int temp = 0;
        for (int[] q: queries) {
            idx1 = q[0];
            idx2 = q[1];
            temp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = temp;
        }
        return arr;
    }
}
