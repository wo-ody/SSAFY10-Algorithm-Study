class Solution {
    public int solution(String s) {
        
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};  
        
        //숫자가 0~9까지 10개로 정해져 있으므로 i<10
        for(int i=0; i<10; i++){
            if(s.contains(num[i])) {
                s = s.replace(num[i], Integer.toString(i));
            }
        }
        
        int answer = Integer.parseInt(s);
        
        return answer;
    }
}
