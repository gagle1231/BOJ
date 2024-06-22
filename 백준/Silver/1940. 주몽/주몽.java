import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //1. 정렬
        Arrays.sort(arr);
        //2. 투 포인터로 접근
        int s=0, e=n-1, cnt=0;
        while(s<e){
            int sum = arr[s] + arr[e];
            if(sum==m){
                cnt++;
                s++;
            }else if(sum < m) s++;
            else e--;
        }
        System.out.println(cnt);
    }
}