import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        StringBuilder sb = new StringBuilder();
        
        List<int[]> list = new ArrayList<>();
        
        for(int i = 0; i < m.length(); i++){
            
            if(i < m.length()-1){
                if(m.charAt(i) != '#' && m.charAt(i+1) == '#'){
                    sb.append(String.valueOf(m.charAt(i)).toLowerCase());
                    i++;
                }else{
                    sb.append(m.charAt(i));
                }
            }else{
                if(m.charAt(i) != '#'){
                    sb.append(m.charAt(i));
                }
            }
        }
        
        
        
        for(int i = 0; i < musicinfos.length; i++){
            String[] split = musicinfos[i].split(",");
            
            String startTime = split[0];
            String endTime = split[1];
            String title = split[2];
            String sing = split[3];
            
            String[] starths = startTime.split(":");
            String[] endhs = endTime.split(":");
            
            int startHour = Integer.parseInt(starths[0]);
            int endHour = Integer.parseInt(endhs[0]);
            
            int startSec = Integer.parseInt(starths[1]);
            int endSec = Integer.parseInt(endhs[1]);
            
            int term = (endHour*60 + endSec) - (startHour*60 + startSec);
            
            StringBuilder sing2 = new StringBuilder();
            
            int idx = 0;
            for(int j = 0; j < term; j++){
                if(idx > sing.length()-1){
                    idx = 0;
                }
                
                if(idx < sing.length()-1){
                    if(sing.charAt(idx) != '#' && sing.charAt(idx+1) == '#'){
                        sing2.append(String.valueOf(sing.charAt(idx)).toLowerCase());
                        idx++;
                    }else{
                        if(sing.charAt(idx) != '#'){
                            sing2.append(sing.charAt(idx));
                        }
                    }
                }else{
                    sing2.append(sing.charAt(idx));
                }
                
                idx++;
            }
            
            
            for(int j = 0; j < m.length(); j++){
                if((sing2.toString()).contains(sb.toString())){
                    int[] a = new int[2];
                    a[0] = term;
                    a[1] = i;
                    list.add(a);
                }
                
            }
            
        }
        
        Collections.sort(list, (o1, o2) -> {
            if(o1[0] < o2[0]){
                return 1;
            }else if(o1[0] > o2[0]){
                return -1;
            }else{
                return Integer.compare(o1[1], o2[1]);
            }
        });
        
        if(list.size() != 0){
            answer = musicinfos[list.get(0)[1]].split(",")[2];
        }
        
        return answer;
    }
}
