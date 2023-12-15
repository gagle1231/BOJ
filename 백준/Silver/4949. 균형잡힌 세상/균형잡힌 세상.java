import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<String> stack;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        while(!(s = br.readLine()).equals(".")){
            stack = new Stack<>();
            String result = "yes";
            for(char c: s.toCharArray()){
                if(c == '(') stack.push("(");
                else if(c == '[') stack.push("[");
                else if(c == ')'){
                    if(stack.isEmpty() || !(stack.pop()).equals("(")){
                        result = "no";
                        break;
                    }
                }
                else if(c == ']'){
                    if(stack.isEmpty() || !(stack.pop()).equals("[")){
                        result = "no";
                        break;
                    }
                }
            }
            if(!stack.isEmpty()) result = "no";
            bw.write(result+"\n");
        }
        bw.flush();
    }
}
