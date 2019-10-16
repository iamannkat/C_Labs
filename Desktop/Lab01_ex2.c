#include <stdio.h>
char c;
int counter = 0;
char num[30];

int main() {
	printf("Please type some characters: ");

	while (counter <= 30 && c!= "$")
		scanf("%c", &c);

		if (c > 64 && c < 91) {
			printf("%c\n", c+32);
		}else if(c > 96 && c < 123){
			printf("%d\n", c-96);
		}else if(c > 47 && c <58){

		}

	return 0;
}