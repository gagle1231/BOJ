import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] sub = new int[n+1][n+1];

        //1행 1열
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                sub[i][j] = sub[i-1][j] + sub[i][j-1] + Integer.parseInt(st.nextToken()) - sub[i-1][j-1];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int as = sub[x2][y2] - (sub[x2][y1]+sub[x1][y2]) + sub[x1][y1];
            sb.append(as).append("\n");
        }
        System.out.println(sb);
    }
}