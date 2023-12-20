import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        int turn = 1;
        String rslt = "Nice";
        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            //System.out.println("input: "+a+", turn: "+ turn);
            if(a==turn){
                turn++;
            }else if(!stack.isEmpty()){
                while(!stack.isEmpty() && stack.peek() == turn){
                    stack.pop();
                    turn++;
                }
                if(!stack.isEmpty() && stack.peek() < a){
                    rslt = "Sad";
                    break;
                }else{
                    stack.push(a);
                }
            }else{
                stack.push(a);
            }
            //System.out.println(stack);
        }

        while(!stack.isEmpty()){
            //System.out.println(turn);
            if(stack.pop() != turn){
                rslt = "Sad";
                break;
            }
            turn++;
        }
        System.out.println(rslt);
    }
}