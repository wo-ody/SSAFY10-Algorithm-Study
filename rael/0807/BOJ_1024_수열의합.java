import java.io.*;
 
class BOJ_1024_수열의합
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] sArr = br.readLine().split(" ");
        long N = Long.valueOf(sArr[0]);
        long L = Long.valueOf(sArr[1]);
        boolean flag = true;
    
        while(L <= 100){
            long start = N / L - (L - 1) / 2;
            if(start < 0)
                break;
                
            if(N == (start * 2 + L - 1) * L / 2){
                for(long i = 0; i < L; i++)
                    sb.append(start+i).append(" ");
                flag = false;
                break;
            }   
            L += 1;
        }
        
        if(flag)
            sb.append("-1");
            
        sb.append("\n");
        System.out.println(sb.toString());
    }
}
