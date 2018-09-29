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

// while @KBD doesn't equal 0 peform while-loop
// make a counter
	@counter			// make a counter
	M = 0				// set counter to 0

(LOOP)
	@KBD
	D = A
	@WHITE
	D; JEQ
	@BLACK
	0; JMP

// paints first screen pixel black
	@SCREEN   			// set A to 16384
	M=-1        		// set first pixel memory address to -1 (black)
	@counter
	M = M+1				// increment counter to next screen pixel memory


// make a while loop to increment screen address while key is held
(BLACK)
	@counter		// call current count
	D = M			// set D to counter
	@8191			// The range of screen addresses
	D = D-A			// subtract current count from range
	@InfiniteLoop	 
	D; JGT			// Jump if greater than 0
	@counter		// recalling counter
	D = M			// set D to current count
	@SCREEN			// set A to SCREEN address
	A = A+D			// add count to screen address to get current position
	M = -1			// set screen to black
	@counter		// call counter
	M = M+1			// increment counter
	@BLACK
	D; JGT
	
(WHITE)
	@counter		// recalling counter
	D = M			// set D to current count
	@SCREEN			// set A to SCREEN address
	A = A+D			// add count to screen address to get current position
	M = 0			// set screen to black
	@counter		// call counter
	M = M+1			// increment counter
	@BLACK
	D; JGT

// infinite loop to end program
(InfiniteLoop)
	@InfiniteLoop
	0; JMP