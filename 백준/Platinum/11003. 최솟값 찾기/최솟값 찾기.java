import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new LinkedList<>();

        int small = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=n; i++) {
            int m = Integer.parseInt(st.nextToken());
            Node newNode = new Node(i, m);
            //1. 덱의 마지막과 비교해서 현재가 더 크면 마지막에 insert, 아니라면 마지막 빼고 insert
            while(!deque.isEmpty() && deque.peekLast().val > m) {
                deque.removeLast();
            }
           deque.addLast(newNode);

            //2. 덱의 처음 인덱스가 i-l+1 보다 작은 값이라면 덱의 처음 제거
            if(deque.peekFirst().idx <= i - l){
                deque.removeFirst();
            }
            //3. 최소갑은 덱의 처음임
            sb.append(deque.peekFirst().val).append(" ");
        }
        System.out.println(sb);
    }
    public static class Node{
        int idx;
        int val;

        public Node(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
}
