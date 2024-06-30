import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            int m = Integer.parseInt(br.readLine());
            while (num<=m){
                stack.push(num++);
                sb.append("+\n");
            }
            if(stack.peek() == m){
                stack.pop();
                sb.append("-\n");
            }else{
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }

}