import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> mapScore = new HashMap<>(){{
            put("A+", 4.5);
            put("A0", 4.0); put("B+", 3.5); put("B0", 3.0); put("C+", 2.5); put("C0", 2.0);
            put("D+", 1.5); put("D0", 1.0); put("F", 0.0);
        }};

        double avg = 0;
        int total = 0;
        for(int i=0; i<20; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            Double gpa = Double.valueOf(st.nextToken());
            String grade = st.nextToken();
            if(grade.equals("P")) continue;
            avg += gpa*mapScore.get(grade);
            total+=gpa;
        }
        System.out.printf("%.6f", avg/total);
    }
}