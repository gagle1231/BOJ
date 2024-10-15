import java.util.*;

public class Main {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

         int n = sc.nextInt(); // 학생수
         int m = sc.nextInt(); // 비교 입력 수
         List<Integer>[] list = new ArrayList[n+1]; // 그래프 저장
         int[] incomeLink = new int[n + 1]; //들어오는 엣지 수 저장

         for (int i = 1; i <= n; i++) {
             list[i] = new ArrayList<>();
         }

         for (int i = 1; i <= m; i++) {
             int s = sc.nextInt();
             int e = sc.nextInt();
             list[s].add(e);
             incomeLink[e]++;
         }

         Queue<Integer> queue = new LinkedList<>();
         for (int i = 1; i <= n; i++) {
             if (incomeLink[i] == 0) {
                 queue.add(i);
             }
         }

         StringBuilder sb = new StringBuilder();
         while (!queue.isEmpty()) {
             int s = queue.poll();
             sb.append(s).append(" ");
             for(int e: list[s]) {
                 incomeLink[e]--;
                 if (incomeLink[e] == 0) {
                     queue.add(e);
                 }
             }
         }
         System.out.println(sb);
    }
}
