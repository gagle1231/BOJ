import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n+1];
        int[] sub = new int[n+1];

        arr[0] = sub[0] = 0;
        for(int i=1; i<=n; i++){
            arr[i] = sc.nextInt();
            sub[i] = sub[i-1] + arr[i];
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            int s = sc.nextInt() - 1;
            int e = sc.nextInt();
            sb.append(sub[e]-sub[s] + "\n");
        }
        System.out.println(sb);
    }
}