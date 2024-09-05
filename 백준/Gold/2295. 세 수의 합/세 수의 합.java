import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[] arr;
    static List<Integer> sum = new ArrayList<>();
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        max=0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<n; i++) {
        	for(int j=i; j<n; j++) {
        		sum.add(arr[i]+arr[j]);
        	}
        }
        Arrays.toString(arr);
        Collections.sort(sum);
        for(int i = n-1; i >=0; i--) {
        	for (int j=0; j<i; j++) {
        		int temp = arr[i]-arr[j];
        		if(solve(temp) && arr[i] > max) {
        			max = arr[i];
        		}
        	}
        }
        System.out.println(max);

       
    }

    static boolean solve(int temp){
        int start = 0;
        int end = sum.size()-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(temp == sum.get(mid)){
                return true;
            }
            else if(sum.get(mid)<temp){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return false;
   
    


    }

}
