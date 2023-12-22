import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        * 1 X: 정수 X를 덱의 앞에 넣는다. (1 ≤ X ≤ 100,000)
2 X: 정수 X를 덱의 뒤에 넣는다. (1 ≤ X ≤ 100,000)
3: 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
4: 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
5: 덱에 들어있는 정수의 개수를 출력한다.
6: 덱이 비어있으면 1, 아니면 0을 출력한다.
7: 덱에 정수가 있다면 맨 앞의 정수를 출력한다. 없다면 -1을 대신 출력한다.
8: 덱에 정수가 있다면 맨 뒤의 정수를 출력한다. 없다면 -1을 대신 출력한다.
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int result;
            switch (c){
                case 1: deque.push(Integer.parseInt(st.nextToken())); break;
                case 2: deque.add(Integer.parseInt(st.nextToken())); break;
                case 3: result = deque.isEmpty() ? -1 : deque.pollFirst();
                    sb.append(result+"\n");break;
                case 4: result = deque.isEmpty() ? -1 : deque.pollLast();
                    sb.append(result+"\n");break;
                case 5: sb.append(deque.size() + "\n"); break;
                case 6: result = deque.isEmpty() ? 1 : 0;
                sb.append(result +"\n"); break;
                case 7: result = deque.isEmpty() ? -1 : deque.peekFirst();
                sb.append(result+"\n"); break;
                case 8: result = deque.isEmpty() ? -1 : deque.peekLast();
                    sb.append(result+"\n"); break;
                default: break;
            }
        }
        System.out.print(sb);
    }
}