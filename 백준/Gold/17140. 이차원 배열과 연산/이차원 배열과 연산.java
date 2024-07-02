import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // r, c, k 값 읽기
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        // 3x3 배열 초기화
        int[][] arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 문제 해결 및 결과 출력
        System.out.println(solve(arr, r, c, k));
    }

    // 문제 해결 함수
    public static int solve(int[][] arr, int r, int c, int k) {
        int time = 0;
        while (time <= 100) {
            // 주어진 위치에 목표 값이 있는지 확인
            if (r - 1 < arr.length && c - 1 < arr[0].length && arr[r - 1][c - 1] == k) {
                return time; // 목표 값이 있으면 현재 시간 반환
            }

            // 행의 개수가 열의 개수보다 많거나 같으면 R 연산, 그렇지 않으면 C 연산
            if (arr.length >= arr[0].length) {
                arr = operateR(arr);
            } else {
                arr = operateC(arr);
            }

            time++;
        }
        return -1; // 100초가 넘어도 목표 값을 찾지 못하면 -1 반환
    }

    // R 연산 함수
    public static int[][] operateR(int[][] arr) {
        int maxColLen = 0;
        List<int[]> rows = new ArrayList<>();

        // 각 행에 대해 숫자와 빈도를 계산하여 정렬
        for (int[] row : arr) {
            Map<Integer, Integer> counter = new HashMap<>();
            for (int num : row) {
                if (num == 0) continue; // 0은 무시
                counter.put(num, counter.getOrDefault(num, 0) + 1);
            }

            List<int[]> pairs = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
                pairs.add(new int[] {entry.getKey(), entry.getValue()});
            }

            // 빈도수와 숫자 순으로 정렬
            pairs.sort((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

            List<Integer> newRow = new ArrayList<>();
            for (int[] pair : pairs) {
                newRow.add(pair[0]);
                newRow.add(pair[1]);
            }

            maxColLen = Math.max(maxColLen, newRow.size());
            rows.add(newRow.stream().mapToInt(Integer::intValue).toArray());
        }

        // 새로운 배열 생성 및 행 길이 맞추기
        int[][] newArr = new int[rows.size()][maxColLen];
        for (int i = 0; i < rows.size(); i++) {
            for (int j = 0; j < rows.get(i).length; j++) {
                newArr[i][j] = rows.get(i)[j];
            }
        }

        return newArr;
    }

    // C 연산 함수
    public static int[][] operateC(int[][] arr) {
        int rowCount = arr.length;
        int colCount = arr[0].length;
        int[][] transposed = new int[colCount][rowCount];

        // 배열 전치
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                transposed[j][i] = arr[i][j];
            }
        }

        transposed = operateR(transposed);

        int[][] newArr = new int[transposed[0].length][transposed.length];
        // 다시 전치하여 원래 형태로 복구
        for (int i = 0; i < transposed.length; i++) {
            for (int j = 0; j < transposed[i].length; j++) {
                newArr[j][i] = transposed[i][j];
            }
        }

        return newArr;
    }
}
