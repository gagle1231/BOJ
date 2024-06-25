import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int b[] = new int[n+1];
        for(int i=1; i<=n; i++){
            b[i] = Integer.parseInt(br.readLine());
        }

        int a[] = new int[k+1];
        a[0] = 1;
        for(int i=1; i<=n; i++){
            for(int j=b[i]; j<=k; j++){
                a[j]+=a[j-b[i]];
            }
        }
        System.out.println(a[k]);
    }
}