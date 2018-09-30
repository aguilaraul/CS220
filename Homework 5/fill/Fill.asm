// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Fill.asm

// Runs an infinite loop that listens to the keyboard input.
// When a key is pressed (any key), the program blackens the screen,
// i.e. writes "black" in every pixel;
// the screen should remain fully black as long as the key is pressed. 
// When no key is pressed, the program clears the screen, i.e. writes
// "white" in every pixel;
// the screen should remain fully clear as long as no key is pressed.

// Put your code here.

(START)
	@counter
	M = 0

(LOOP)
	@KBD				// set A to 24576
	D = M 				// set D to value at RAM[24576]
	@WHITE				// Jump to WHITE if no key is pressed (D=0)
	D; JEQ
	@BLACK				// Jump to BLACK if a key is pressed (D>0)
	D; JGT

(WHITE)	
	@counter			// set A to counter address
	D = M				// set D to counter value
	@SCREEN				// set A to 16384
	A = A+D				// RAM[16384+counter] add the counter to screen address to find current screen address
	M = 0				// RAM[current address], paint screen white (RAM[A] = 0)
	@counter			// set A to counter
	M = M+1				// increment counter
	
	@counter			// set A to counter address
	D = M				// D = 16384 + counter -- to set the current screen pixel
	@8192				// set A to 8192 (the range of screen addresses)
	D = D-A				// D = (current screen address) - 8192
	@START
	D; JEQ				// Restart program if beyond last pixel (D>0)
	@LOOP
	D; JLT				// Go back to loop if not beyond last pixel

(BLACK)
	@counter			// set A to counter value
	D = M				// set D to counter value
	@SCREEN				// set A to 16384
	A = A+D				// RAM[16384+counter] add the counter to screen address to find current screen address
	M = -1				// paint screen black (RAM[A] = -1)
	@counter			// set A to counter
	M = M+1				// increment counter
	
	@counter			// set A to counter value
	D = M				// D = 16384 + counter -- to set the current screen pixel
	@8192				// set A to 8192 (the range of screen addresses)
	D = D-A				// D = (current screen address) - 8192
	@START
	D; JEQ				// Restart program if beyond last pixel (D>0)
	@LOOP
	D; JLT				// Go back to loop if not beyond last pixel

// infinite loop to end program
(EXIT)
	@EXIT
	0; JMP