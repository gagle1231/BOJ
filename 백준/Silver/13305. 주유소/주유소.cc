#include <stdio.h>
#include <stdlib.h>
int main()
{
	int n, i;
    long long p, cost = 0;
	scanf("%d", &n);
    
	long long* d = (long long*)malloc(sizeof(long long) * (n - 1));
	long long* c = (long long*)malloc(sizeof(long long) * n);
	
	for (i = 0; i < n - 1; i++)
		scanf("%lld", &d[i]);
	
	for (i = 0; i < n; i++)
		scanf("%lld", &c[i]);

	p = c[0];
	for (i = 0; i < n - 1; i++) {
		if (p > c[i])
			p = c[i];
		cost += p * d[i];
	}
	printf("%lld", cost);
    free(d); free(c);
}