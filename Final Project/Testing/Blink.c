/**********************************************************************
* Filename    : Blink.c
* Description : Basic usage of GPIO. Let led blink.
* auther      : www.freenove.com
* modification: 2019/12/26
**********************************************************************/
#include <wiringPi.h>
#include <stdio.h>

#define  ledPin1    0	//define the led pin number
#define  ledPin2    21

void main(void)
{	
	printf("Program is starting ... \n");
	
	wiringPiSetup();	//Initialize wiringPi.
	
	pinMode(ledPin1, OUTPUT);//Set the pin mode
	pinMode(ledPin2, OUTPUT);

	printf("Using pin%d\n",ledPin1);	//Output information on terminal
	printf("Using pin%d\n",ledPin2);
	int i = 0;
	while(i < 30) {
		digitalWrite(ledPin1, HIGH);  //Make GPIO output HIGH level
		printf("led turned on >>>\n");		//Output information on terminal
		delay(1000);						//Wait for 1 second
		digitalWrite(ledPin1, LOW);  //Make GPIO output LOW level
		printf("led turned off <<<\n");		//Output information on terminal
		delay(1000);						//Wait for 1 second
		if(i == 10) {
			digitalWrite(ledPin2, HIGH);
		}
		if(i == 20) {
			digitalWrite(ledPin2, LOW);
		}
		i = i + 1;
	}
}

