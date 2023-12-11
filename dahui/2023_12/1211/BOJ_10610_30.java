import java.io.*;
import java.util.*;

public class Main {
	static String num;
	static Integer[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		num = br.readLine(); 
        arr = new Integer[num.length()];
        boolean zero = false;

        for(int i=0 ; i<num.length(); i++){
          arr[i] = (int)(num.charAt(i)-'0');
          if(arr[i] == 0) zero = true;
        }
        
        if(!zero) {
            System.out.println(-1);
        }else{
          int sum = 0;
          for(int i=0 ; i<num.length(); i++){
            sum += arr[i];
          }
            
            if(sum % 3 !=0){
            System.out.println(-1);
            }else{
                String ans = "";
               Arrays.sort(arr, Comparator.reverseOrder());
                for(int i=0 ; i<num.length(); i++){
                  ans += Integer.toString(arr[i]);
                }
                System.out.println(ans);
            }
        }
        
        
    }
}
