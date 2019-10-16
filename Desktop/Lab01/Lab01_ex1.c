#include <stdio.h>

int A=0;
int PR1=5;
int PR2=7;
float TE = 8;
float BE = 0;
float GR =0;

int computeA(int numOfAbsenses){
	if (numOfAbsenses >= 2){
		return 0;
	}
	if (numOfAbsenses == 1){
		return 5;
	}
	if (numOfAbsenses == 0){
		return 10;
	}
	return -1;
}

float computeBE(int A, int PR1, int PR2){
	return A*(20/100.0) + PR1*(40/100.0) + PR2*(40/100.0) ; 
}

int main(){
	int test = 0;
	A = computeA(test);
	BE = computeBE(A, PR1, PR2);
	printf("%f\n", BE );

	if (BE < 4.5){
		printf("Failed Lab\n");
		return 0;
	}

	if (TE < 4.5){
		printf("Failed Final Exam\n");
		return 0;
	}

	GR = BE*(40/100.0 ) + TE*(60/100.0);
	printf("Lesson Passes with %f", GR);
	return 0;
}