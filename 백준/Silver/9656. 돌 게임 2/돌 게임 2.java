import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
	
		if (n%2 == 1) {
			System.out.println("CY");
		}else {
			System.out.println("SK");
		}
		
	}
}
