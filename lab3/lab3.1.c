// Endeiktiki Lysi tis Askisis 3.1 - Ak. Etos 2019-2020

/* Simple calculator  */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	int result, i;
	
	if (argc < 4)    /* Xreiazomaste toulaxiston 4 orismata */
		return 1;
	
	/* Sigkrinw to prwto orisma me ta simvola twn praksewn +, -, x, / */
	if (strcmp(argv[1], "+") == 0)
	{
		result = 0;

		/* Prosthetw ta orismata */
		for (i=2; i<argc; i++)
			result += atoi(argv[i]);
	}
	else if (strcmp(argv[1], "-") == 0)
	{
		result = atoi(argv[2]);
		
		/* Afairw ta ipoloipa orismata apo to deutero */
		for (i=3; i<argc; i++)
			result -= atoi(argv[i]);
	}
	else if (strcmp(argv[1], "x") == 0)
	{
		result = 1;
		
		/* Pollaplasiazw ta orismata */
		for (i=2; i<argc; i++)
			result *= atoi(argv[i]);
	}
	else if (strcmp(argv[1], "/") == 0)
	{
		result = atoi(argv[2]);
		
		/* Diairw ta ipoloipa orismata apo to deutero */
		for (i=3; i<argc; i++)
			result /= atoi(argv[i]);
	}
	else
	{
		/* An den dothike swsta i praksi */
		printf("Wrong syntax!\n");
		return 1;
	}
	
	printf("Result = %d\n", result);
	return 0;
}
