import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		byte[] b = new byte[7000];
		System.in.read(b);
		System.out.println(new String(b).trim());
	}
}
