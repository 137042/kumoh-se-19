#include <stdio.h>
#include <string.h>

void reverse(char str[])
{
    int len;
    char c;

    len = strlen(str); 
    for (int i = 0; i < len / 2; i++)
	{
        c = str[i];
        str[i] = str[len -i -1];
        str[len - i - 1] = c;
    }
 }

int main()
{
    char str[1024];
    printf("Give me a word to reverse:");
    scanf("%s", str);
    reverse(str);
    printf("REVERSED:%s\n", str);
	return 0;
}
