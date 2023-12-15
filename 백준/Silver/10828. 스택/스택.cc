#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
int main()
{
	int n;
	char ans[10];
	int cnt = -1;
	int mcnt = 0;

	scanf("%d", &n); 

	int* stack = (int*)malloc(sizeof(int) * n);
	int* mem = (int*)malloc(sizeof(int) * n);

	for (int i = 0; i < n; i++)
	{
		scanf("%s", ans);

		if (!strcmp("push", ans))//push
		{
			int num;
			scanf("%d", &num);
			stack[++cnt] = num;
		}
		else if (!strcmp(ans, "pop")) //pop
		{
			if (cnt == -1)
				mem[mcnt++] = -1;
			else
				mem[mcnt++] = stack[cnt--];
		}
		else if (!strcmp(ans, "size"))//size
		{
			mem[mcnt++] = cnt + 1;
		}
		else if (!strcmp(ans, "empty")) //empty 
		{
			if (cnt == -1)
				mem[mcnt++] = 1;
			else
				mem[mcnt++] = 0;
		}
		else //top
		{
			if (cnt == -1)
				mem[mcnt++] = -1;
			else
				mem[mcnt++] = stack[cnt];
		}
	}
	
	for (int i = 0; i < mcnt; i++)
		printf("%d\n", mem[i]);

	free(mem);
	free(stack);
}