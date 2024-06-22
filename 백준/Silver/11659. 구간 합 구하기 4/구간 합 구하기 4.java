import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] sub = new int[n+1];
        sub[0] = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            sub[i] = Integer.parseInt(st.nextToken()) + sub[i-1];
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(sub[e]-sub[s-1] + "\n");
        }
        System.out.println(sb);
    }
}