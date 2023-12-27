import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] arr = new String[n*2];

        for(int i=0; i<n*2; i++){
            arr[i] = br.readLine();
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<n; i++){
            st=  new StringTokenizer(arr[i]);
            StringTokenizer st2 = new StringTokenizer(arr[i+n]);
            for(int j=0; j<m; j++){
                sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st2.nextToken()) + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}