import java.io.*;
import java.util.*;
public class Main { 
	static int[] m1;
	static int[] m2;
	static int[] m3;
	static int[] m4;
	static int[] temp;
	static int k;

	public static void main(String[] args) throws IOException{
		m1= new int[8];
		m2= new int[8];
		m3 = new int[8];
		m4= new int[8];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = br.readLine();
		for (int i =0; i<8; i++) {
			m1[i] = (int) (str.charAt(i)-'0');
		}
		str = br.readLine();
		for (int i =0; i<8; i++) {
			m2[i] = (int) (str.charAt(i)-'0');
		}
		str = br.readLine();
		for (int i =0; i<8; i++) {
			m3[i] = (int) (str.charAt(i)-'0');
		}
		str = br.readLine();
		for (int i =0; i<8; i++) {
			m4[i] = (int) (str.charAt(i)-'0');
		}
		k = Integer.parseInt(br.readLine());
		temp = new int[8];
		
		for(int i=0; i<k ; i++) {
			save();
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			num(n,d);		
		}
		
		if(m1[0] == 1) {
			m1[0]= 1;
		}
		if(m2[0] == 1) {
			m2[0] = 2;
		}
		if(m3[0] == 1) {
			m3[0] = 4;
		}
		if(m4[0] == 1) {
			m4[0] = 8;
		}
		System.out.println(m1[0] + m2[0] + m3[0] + m4[0]);
	}
	static void save() {
		temp[0] = m1[6];
	    temp[1] = m1[2];
	    temp[2] = m2[6];
	    temp[3] = m2[2];
	    temp[4] = m3[6];
	    temp[5] = m3[2];
	    temp[6] = m4[6];
	    temp[7] = m4[2];	
	}
	static void num(int n, int d) {
		//n이 1일 경우
		if(n==1) {
			if(d==1) {
				spin(1,1);
			}else {
				spin(1,-1);
			}
			if(temp[1] != temp[2]) {
				if(d==1) {
					
					spin(2,-1);
					if(temp[3] != temp[4]) {
						spin(3,1);
						if(temp[5]!= temp[6]) {
							spin(4,-1);
						}
					}
				}else {
					
					spin(2,1);
					if(temp[3] != temp[4]) {
						spin(3,-1);
						if(temp[5]!= temp[6]) {
							spin(4,1);
						}
					}
				}
			}
		}
		//n이 2일 경우
		if(n==2) {
			if(d==1) {
				spin(2,1);
			}else {
				spin(2,-1);
			}
			if(temp[3]!= temp[4]) {
				if(d == 1) {
					spin(3,-1);
					if(temp[5] != temp[6]) {
						spin(4,1);
					}
				}else {
			
					spin(3,1);
					if(temp[5] != temp[6]) {
						spin(4,-1);
					}
				}
			}
			if(temp[2] != temp[1]) {
				if(d == 1) {
					spin(1,-1);
				}else {
					spin(1,1);
				}
			
			}
			
		}
		//n이 3일 경우
		if(n==3) {
			if(d==1) {
				spin(3,1);
			}else {
				spin(3,-1);
			}
			
			if(temp[4]!= temp[3]) {
				if(d == 1) {
					spin(2,-1);
					if(temp[2] != temp[1]) {
						spin(1,1);
					}
				}else {
					spin(2,1);
					if(temp[2] != temp[1]) {
						spin(1,-1);
					}
				}
			}
			if(temp[5] != temp[6]) {
				if(d == 1) {
					spin(4,-1);
				}else {
					spin(4,1);
				}
				
			}
		}
		//n이 4일 경우
		if(n==4) {
			if(d==1) {
				spin(4,1);
			}else {
				spin(4,-1);
			}
			if(temp[6] != temp[5]) {
				if(d==1) {
					spin(3,-1);
					if(temp[4] != temp[3]) {
						spin(2,1);
						if(temp[2]!= temp[1]) {
							spin(1,-1);
						}
					}
				}else {
					spin(3,1);
					if(temp[4] != temp[3]) {
						spin(2,-1);
						if(temp[2]!= temp[1]) {
							spin(1,1);
						}
					}
				}
			}
		}
		
	}
	static void spin(int n, int d) {
		//1일 경우
		if(n == 1) {
			//시계방향
			if(d == 1) {
				int temp = m1[7];
				for(int i=7; i>0; i--) {
					m1[i] = m1[i-1];
				}
				m1[0] = temp;
			}
			//반시계방향
			else {
				int temp = m1[0];
				for(int i=0; i<7; i++) {
					m1[i] = m1[i+1];
				}
				m1[7] = temp;
			}
		}
		//2일 경우
		if(n == 2) {
			//시계방향
			if(d == 1) {
				int temp = m2[7];
				for(int i=7; i>0; i--) {
					m2[i] = m2[i-1];
				}
				m2[0] = temp;
			}
			//반시계방향
			else {
				int temp = m2[0];
				for(int i=0; i<7; i++) {
					m2[i] = m2[i+1];
				}
				m2[7] = temp;
			}	
				}
		//3일경우
		if(n == 3) {
			//시계방향
			if(d == 1) {
				int temp = m3[7];
				for(int i=7; i>0; i--) {
					m3[i] = m3[i-1];
				}
				m3[0] = temp;
			}
			//반시계방향
			else {
				int temp = m3[0];
				for(int i=0; i<7; i++) {
					m3[i] = m3[i+1];
				}
				m3[7] = temp;
			}
		}
		//4일경우
		if(n == 4) {
			//시계방향
			if(d == 1) {
				int temp = m4[7];
				for(int i=7; i>0; i--) {
					m4[i] = m4[i-1];
				}
				m4[0] = temp;
			}
			//반시계방향
			else {
				int temp = m4[0];
				for(int i=0; i<7; i++) {
					m4[i] = m4[i+1];
				}
				m4[7] = temp;
			}
		}
	}
}