import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies){
        ArrayList<Integer> lst = new ArrayList<>();
        StringTokenizer st = null;
        int len = privacies.length;
        String[] todays = today.split("\\.");
        
        int todayYear = Integer.parseInt(todays[0]);
        int todayMonth = Integer.parseInt(todays[1]);
        int todayDay = Integer.parseInt(todays[2]);
        
        for(int i = 0; i < len; i++){
            st = new StringTokenizer(privacies[i]);            
            String registerTime = st.nextToken();
            char privacie = st.nextToken().charAt(0);
            
            String[] endDate = registerTime.split("\\.");        
            int term = getTerm(privacie, terms);
            int year = Integer.parseInt(endDate[0]);
            int month = Integer.parseInt(endDate[1]);
            int day = Integer.parseInt(endDate[2]);
            
            if(month + term > 12){
                if((month + term)%12 == 0)year += (month+term)/12-1;
                else year += (month+term)/12;
                month = (month + term)%12;
                if(month == 0) month = 12;
            }
            else month += term;
            if(todayYear > year){
                lst.add(i+1);
                continue;  
            } 
            if(todayYear < year) continue;
            if(todayMonth > month ){
                lst.add(i+1);
                continue; 
            }
            if(todayMonth < month) continue;
            if(todayDay >= day) lst.add(i+1);
            
        }
        return lst.stream().mapToInt(Integer::intValue).toArray();
    }
    int getTerm(char chr, String[] terms){
        int result = 0;
        StringTokenizer st = null;
        for(String str : terms){
            st = new StringTokenizer(str);
            if(st.nextToken().charAt(0) == chr) {
                result = Integer.parseInt(st.nextToken());
                break;
            }
        }
        return result;
    }    
    
}
