
import java.io.*;
import java.util.*;
public class Main {
    static int[] arr1;
    static int[] arr2;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        arr1 = new int[a];
        arr2 = new int[b];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<a; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<b; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        arr1 = Arrays.stream(arr1).distinct().sorted().toArray();
        arr2 = Arrays.stream(arr2).distinct().sorted().toArray();
        solve();
    }
    static void solve(){
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<arr1.length; i++){
            int start = 0;
            int end = arr2.length-1;
            while(start<=end){
                int mid = (start+end)/2;
                if(arr1[i]==arr2[mid]){
                    break;
                }
                else if(arr1[i]>arr2[mid]){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            if(start>end){
                list.add(arr1[i]);
            }
        }
        System.out.println(list.size());
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");
        }

    }

}
