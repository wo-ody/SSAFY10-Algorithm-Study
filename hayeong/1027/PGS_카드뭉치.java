import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        Deque<String> stack1 = new ArrayDeque<>();
        Deque<String> stack2 = new ArrayDeque<>();
        for(int i = cards1.length-1; i >= 0; i--){
            stack1.push(cards1[i]);
        }
        
         for(int i = cards2.length-1; i >= 0; i--){
            stack2.push(cards2[i]);
        }
        
        int lastIdx = goal.length-1;
        int idx = 0;
        while(true){
            if(idx == lastIdx+1) return "Yes";
            
            if(!stack1.isEmpty() && stack1.peek().equals(goal[idx])){
                stack1.pop();
                idx++;
               
            } else if(!stack2.isEmpty() && stack2.peek().equals(goal[idx])){
                stack2.pop();
                idx++;
            } else return "No";
        }
        
    }
}
