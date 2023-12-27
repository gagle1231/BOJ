import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while(n>0){
            int i = n%b;
            if(i >= 10){
                sb.append((char)(i+55));
            }else {
                sb.append(i);
            }
            n = n/b;
        }
        System.out.println(sb.reverse());
    }
}