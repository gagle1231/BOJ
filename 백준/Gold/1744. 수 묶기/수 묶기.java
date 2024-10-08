import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> positive = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();
        int sum=0;
        for(int i=0; i<n; i++) {
            int k = sc.nextInt();
            if(k==1){
                sum++;
            }else if(k<=0){
                negative.add(k);
            }else {
                positive.add(k);
            }
        }
        sum = sum + getSub(positive) + getSub(negative);
        System.out.println(sum);
    }

    public static int getSub(PriorityQueue<Integer> queue) {
        int sum = 0;
        while(queue.size() > 1) {
            sum+=queue.poll() * queue.poll();
        }
        if(!queue.isEmpty()) {
            sum += queue.poll();
        }
        return sum;
    }
}
