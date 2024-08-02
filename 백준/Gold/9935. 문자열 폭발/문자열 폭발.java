import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bump = br.readLine();
        int n = bump.length();
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            stack.push(c);
            boolean find = true;
            if(stack.size() >= n){
                for(int i=0; i<n; i++){
                    if(bump.charAt(i) != stack.get(stack.size() - n + i)){
                        find = false;
                        break;
                    }
                }
                if(find){
                    for(int i=0; i<n; i++){
                        stack.pop();
                    }
                }
            }
        }
        if(stack.isEmpty()){
            System.out.println("FRULA");
        }else{
            StringBuilder sb = new StringBuilder();
            for(char c: stack){
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}