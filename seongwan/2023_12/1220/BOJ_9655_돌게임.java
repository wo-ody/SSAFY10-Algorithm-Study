import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*; 

public class Main {
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
static int N;
public static void main(String[] args) throws Exception {
N=Integer.parseInt(br.readLine()); 

if(N%2==1)
System.out.print("SK");
else
System.out.print("CY");
}
}
