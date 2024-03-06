class Solution {
    int[] answer = {0,0};
    int[][] num;
    
    public int[] solution(int[][] arr) {
        num = arr;
        div(0,0,arr.length);
        return answer;
    }
    
    //같은 수인지 판단
    public boolean check(int x, int y, int size){
        boolean flag = false;
        for(int i=y; i<y+size; i++){
            for(int j=x; j<x+size; j++){
                if(num[i][j] != num[y][x]){
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
    
    //나누기 작업
    public void div(int x, int y, int size){
        if(check(x,y,size)){
            int d_size = size/2;
            div(x, y, d_size);
            div(x+d_size, y, d_size);
            div(x, y+d_size, d_size);
            div(x+d_size, y+d_size, d_size);
        }
        else{
            answer[num[y][x]] += 1;
        }
    }
}
