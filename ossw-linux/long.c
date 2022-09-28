#include <stdio.h>
#include <string.h>

#define MAXLINE 100

void copy(char from[], char to[]);
char line[MAXLINE];
char shortest[MAXLINE];
char longest[MAXLINE];

int main()
{
	int len, index=1, max=0, min = 100;
	
	printf("[%d] ", index++);
	fgets(line, MAXLINE, stdin);

	while(strlen(line) > 1)
	{
		len = strlen(line);
		if(len < min)
		{
			min = len;
			copy(line, shortest);
		}
		if(len > max)
		{
			max = len;
			copy(line, longest);
		}
		printf("[%d] ", index++);
		fgets(line, MAXLINE, stdin);
	}
	if(min < 100)
		printf("shortest:%s length:%d\n", shortest, min);
	if(max > 0)
		printf("longest:%s length:%d\n", longest, max);
	return 0;
}

void copy(char from[], char to[])
{
	int i = 0;
	while ((to[i] = from[i]) != '\0')
		i++;
}
