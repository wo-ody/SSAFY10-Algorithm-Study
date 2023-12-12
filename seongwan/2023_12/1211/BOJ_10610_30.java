import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*; 

public class Main {
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
static int total;
static int[] num;
static boolean chk;
static String s; 

public static void main(String[] args) throws Exception { 

s = br.readLine();
num= new int[s.length()]; 

for (int i = 0;i<s.length() ; i++) {
num[i]=s.charAt(i)-'0';
total+=num[i];
if(num[i]==0)
chk=true;} 

if(total%3==0&&chk)
cal();
else
System.out.print(-1);
}
static void cal(){
Arrays.sort(num);
for(int i= s.length()-1;i>=0;i--){
System.out.print(num[i]);
}
}
}
