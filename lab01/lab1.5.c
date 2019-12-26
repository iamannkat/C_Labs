// Endeiktiki Lysi tis Askisis 1.5 - Ak. Etos 2019-2020

#include <stdio.h>

void printbin(unsigned int num)
{
	int digits[32];
	int i, ndig = 0;        /* Number of digits */

	if (num == 0)           /* Special case */
		printf("0");

	while (num != 0)
	{
		digits[ndig] = num % 2;
		num = num / 2;
		ndig++;
	}

	for (i = ndig-1; i >= 0; i--)   /* Print in correct order */
		printf("%d", digits[i]);
	printf("\n");
}

int main(void)
{
	unsigned int n;

	do
	{
		printf("Enter a number (502 stops the program): ");
		scanf("%d", &n);

		if(n == 502)
			break;

		printbin(n);
	}
	while (1);

	return 0;
}
