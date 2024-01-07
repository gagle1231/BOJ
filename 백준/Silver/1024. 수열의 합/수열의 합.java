import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int k = 0;
        int a = -1;
        for(int i=0; i<l; i++){
            k+=i;
        }

        for(int i=l; i<=100; i++){
            if(n<k) break;
            if((n-k)%i == 0){
                a = i;
                break;
            }
            k+=i;
        }
        if(a==-1){
            System.out.println(-1);
        }else{
            StringBuilder sb = new StringBuilder();
            n = (n-k) / a;
            for(int i=0; i<a; i++){
                sb.append(n+i +" ");
            }
            System.out.println(sb);
        }
    }
}