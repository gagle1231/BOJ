import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // int 배열로 변경
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                Comparator.comparingInt((int[] o) -> o[1]).thenComparingInt(o -> o[0])
        );
        
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            queue.add(new int[]{s, e});
        }

        int count = 1;
        int lastTime = queue.poll()[1];
        while (!queue.isEmpty()) {
            int[] e = queue.poll();
            if (e[0] >= lastTime) {
                count++;
                lastTime = e[1];
            }
        }
        System.out.println(count);
    }
}
