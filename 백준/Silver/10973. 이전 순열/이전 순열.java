import java.util.*;
public class Main {
	 public static void swap(int [] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
     public static boolean nextPermutation(int[] a) {
            int i = a.length-1;
            while (i > 0 && a[i-1] < a[i]) {
                i--;
                if(i==0) break;
            }
 
            if (i <= 0) {
                return false;
            }

            int j = a.length-1;
            while (a[j] >= a[i-1]) {
                j--;
            }
            swap(a, i-1, j);
            j = a.length-1;
            while (i < j) {
                swap(a, i, j);
                i += 1;
                j -= 1;
            }
            return true;
        }
        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i=0; i<n; i++) {
                a[i] = sc.nextInt();
            }
            if (nextPermutation(a)) {
                for (int i=0; i<n; i++) {
                    System.out.print(a[i] + " ");
                }
            } 
            else {
                System.out.println("-1");
            }
        }
}
