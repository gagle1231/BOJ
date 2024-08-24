#include <iostream>
#include <unordered_set>

int main() {
    std::ios_base::sync_with_stdio(false); // C++ I/O를 C 스타일 I/O와 동기화하지 않음
    std::cin.tie(NULL); // std::cin과 std::cout의 묶음을 풀어줌

    int n, m;
    std::cin >> n;
    std::unordered_set<int> set;
    set.reserve(n); // 입력받을 요소 수에 맞춰 set의 메모리를 미리 할당

    for (int i = 0; i < n; i++) {
        int num;
        std::cin >> num;
        set.insert(num);
    }

    std::cin >> m;

    for (int i = 0; i < m; i++) {
        int k;
        std::cin >> k;
        if (set.find(k) != set.end()) {
            std::cout << 1 << "\n";
        } else {
            std::cout << 0 << "\n";
        }
    }

    return 0;
}
