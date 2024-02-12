import java.util.Arrays;
import java.util.Scanner; 
public class Main {    
  public static void main(String[] args) {        
    // Input        
    Scanner sc = new Scanner(System.in);        
    int N = sc.nextInt();        
    int[] N_arr = new int[N];        
    
    for (int i = 0; i < N; i++) {  
      // 두번째줄 배열에 넣기            
      N_arr[i] = sc.nextInt();        
    }        
    
    int M = sc.nextInt();        
    int[] M_arr = new int[M]; 
    
    for (int i = 0; i < M; i++) {  
      // 네번째줄 배열에 넣기           
      M_arr[i] = sc.nextInt();        
    }        
    
    int[] answer = new int[M];        
    Arrays.sort(N_arr); // 이분 탐색을 위해 N 배열 정렬      
    // Logic       
    for (int i = 0; i < M_arr.length; i++) {           
      answer[i] = BS(N_arr, M_arr[i]) ? 1 : 0; // 이분탐색 호출       
    }         
    for (int s : answer) {           
      System.out.printf("%d ", s);        
    }  
    sc.close(); 
  }     
  
  public static boolean BS(int[] arr, int n) {       
    int left = 0;        
    int right = arr.length - 1;         
    int mid;         
    
    while (left <= right) { 
      mid = (left + right) / 2;       
      
      if (arr[mid] < n) {                
        left = mid + 1;
      }
      else if (arr[mid] > n) { 
        right = mid - 1;            
      } 
      else {                    
        return true;           
      }      
    }        
    return false;                    
  }
}
