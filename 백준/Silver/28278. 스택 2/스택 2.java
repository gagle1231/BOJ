import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int c = sc.nextInt();
            int result = 0;
            switch (c){
                case 1:
                    int x = sc.nextInt();
                    stack.push(x);
                    continue;
                case 2:
                    result = !stack.isEmpty()? stack.pop():-1;
                    break;
                case 3:
                    result = stack.size();break;
                case 4:
                    result = stack.isEmpty()? 1: 0;break;
                case 5:
                    result = !stack.isEmpty()?stack.peek():-1;break;
            }
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }
}
