class Solution {
    int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[2];
        int length = arr.length;
        press(arr, 0, 0, length);
        return answer;
    }
    // y2 > y1
    // x2 > x1
    void press(int[][] arr, int y, int x, int length){
        if(search(arr, y, x, length, arr[y][x])){
            if(arr[y][x] == 1) answer[1]++;
            else answer[0]++;
            return;
        }

        press(arr, y, x, length/2);
        press(arr, y, x+length/2, length/2);
        press(arr, y + length/2, x, length/2);
        press(arr, y + length/2, x + length/2, length/2);
    }

    boolean search(int[][] arr, int y, int x, int length, int value){
        for(int i = y; i < y + length; i++){
            for(int j = x; j < x + length; j++){
                if(arr[i][j] == value) continue;
                return false;
            }
        }
        return true;
    }

}