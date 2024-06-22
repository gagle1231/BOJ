import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        int cnt = 0;
        for(int i = 0; i < n; i++){
            int s = 0, e = n-1;
            long k = arr[i];
            while(s < e){
                long sum = arr[s]+arr[e];
                if(k == sum){
                    if(i!=s && i!=e){
                        cnt++; break;
                    }else if(i==s){
                        s++;
                    }else if(i==e){
                        e--;
                    }
                }else if(k<sum) e--;
                else s++;
            }
        }
        System.out.println(cnt);
    }
}