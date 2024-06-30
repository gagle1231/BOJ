import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>(); //인덱스를 저장할 스택
        stack.push(0);
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer = new int[n];
        for(int i=0; i<n; i++){
            //스택의 상단에 있는 원소보다 현재 원소가 더 크면
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                answer[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }
        StringBuilder sb  =  new StringBuilder();
        for(int i: answer){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

}