import java.util.*;

class Solution {
    
    public ArrayList<Integer> solution(String s) {
        
        ArrayList<Integer> answer = new ArrayList<>();
        s = s.substring(2,s.length());
        s = s.substring(0,s.length()-2).replace("},{","-");
        String str[] = s.split("-");        
      
        Arrays.sort(str,new Comparator<String>(){
            public int compare(String o1, String o2){
                
                return Integer.compare(o1.length(), o2.length());
            }
        });
        
        for(String x : str){
            String[] temp = x.split(",");
            for(int i = 0 ; i < temp.length;i++){
                int n = Integer.parseInt(temp[i]);
                if(!answer.contains(n))
                    answer.add(n);
            }
        }
        
        return answer;
    }
}
