import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        float sum = 0;
        int max = 0;
        for(int i=0; i<n; i++){
           int num = Integer.parseInt(st.nextToken());
           sum += num;
           max = max < num ? num : max;
        }
        System.out.println(sum/max*100/n);
    }
}