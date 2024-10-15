import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static int[] unionSet;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 사람의 수
        int M = sc.nextInt(); // 파티의 수

        unionSet = new int[N+1];
        for (int i = 0; i < N; i++) {
            unionSet[i] = i;
        }

        int K = sc.nextInt(); // 진실을 아는 사람의 수
        int[] knowPeople = new int[K];
        for (int i = 0; i < K; i++) {
            knowPeople[i] = sc.nextInt();
        }

        List<Integer> parites = new ArrayList<Integer>();
        for (int i = 0; i < M; i++) {
            int number = sc.nextInt();
            int before = sc.nextInt();
            parites.add(before);
            for(int j=1; j<number; j++) {
                int now = sc.nextInt();
                union(before, now); // 같은 파티에 참석한 사람들은 같은 집합으로 묶음
                before = now;
            }
        }

        int cnt = 0;
        for(Integer i : parites) {
            boolean isPossible = true;
            for(int j=0; j<knowPeople.length; j++) {
                if(find(knowPeople[j]) == find(i)) {
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if(parentA != parentB) {
            unionSet[parentB] = parentA;
        }
    }

    public static int find(int a) {
        if(unionSet[a] == a) {
            return a;
        }else{
            return unionSet[a] = find(unionSet[a]);
        }
    }

}
