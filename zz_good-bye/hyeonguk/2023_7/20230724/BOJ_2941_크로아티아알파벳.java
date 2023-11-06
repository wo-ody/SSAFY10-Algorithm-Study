import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] words = br.readLine().toCharArray();
		int wordLength = words.length;
		int cnt = 0;
		
		for(int i=0; i<wordLength; i++) {
			if (words[i]=='c') {
				if((i+1)< wordLength){
					if(words[i+1] == '=') {
						cnt +=1;
						i += 1;
						continue;
					}
					else if(words[i+1] == '-') {
						cnt +=1;
						i += 1;
						continue;
					}
				}
				cnt += 1;
			} else if(words[i]=='d') {
				if((i+1)<wordLength) {
					if(words[i+1] == '-') {
						cnt +=1;
						i += 1;
						continue;
					} else if((i+2)< wordLength) {
						if(words[i+1] == 'z' && words[i+2] == '=') {
							cnt +=1;
							i += 2;
							continue;
						}
					}
				} 
				cnt += 1;
			} else if(words[i]== 'l') {
				if((i+1)<wordLength) {
					if(words[i+1] == 'j') {
						cnt +=1;
						i += 1;
						continue;
					}
				} 
				cnt += 1;
			} else if(words[i]== 'n') {
				if((i+1)<wordLength) {
					if(words[i+1] == 'j') {
						cnt +=1;
						i += 1;
						continue;
					}
				} 
				cnt += 1;
			} else if(words[i]== 's') {
				if((i+1)<wordLength) {
					if(words[i+1] == '=') {
						cnt +=1;
						i += 1;
						continue;
					}
				} 
				cnt += 1;
			} else if(words[i]== 'z') {
				if((i+1)<wordLength) {
					if(words[i+1] == '=') {
						cnt +=1;
						i += 1;
						continue;
					}
				} 
				cnt += 1;
			} else {
				cnt += 1;
			}
		}
		System.out.println(cnt);
	}
}
