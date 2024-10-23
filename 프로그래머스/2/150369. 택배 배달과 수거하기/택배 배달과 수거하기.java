class Solution {
     public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliverLoad = 0; // 트럭의 배달 물량
        int pickupLoad = 0;  // 트럭의 수거 물량

        // 마지막 집부터 역순으로 탐색
        for (int i = n - 1; i >= 0; i--) {
            deliverLoad += deliveries[i];
            pickupLoad += pickups[i];

            // 배달이나 수거가 남아있다면 그 집까지 왕복
            while (deliverLoad > 0 || pickupLoad > 0) {
                deliverLoad -= cap;
                pickupLoad -= cap;
                answer += (i + 1) * 2L; // 왕복 거리 추가
            }
        }

        return answer;
    }
}
