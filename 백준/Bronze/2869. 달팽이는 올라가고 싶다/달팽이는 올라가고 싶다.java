import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int t = a-b;
        int result = 1;
        if(v != a){
            result = (v - b)/ t;
            v = (v-b) % t;
            if(v != 0) result++;
        }

        System.out.println(result);
    }
}