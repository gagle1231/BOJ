import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] answer = new int[n];
        int idx = 0;
        for(String s : br.readLine().split(" ")) {
            arr[idx++] = Integer.parseInt(s);
        }

        Stack<Integer> stack = new Stack<>(); // 인덱스를 담을 스택
        stack.push(0);

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                answer[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < n; i++) {
            bw.write(answer[i] + " ");
        }
        bw.flush(); bw.close();
    }
}