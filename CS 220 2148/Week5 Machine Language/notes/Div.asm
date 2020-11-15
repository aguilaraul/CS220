// Initialize R0 = 16
@16			// RAM[16] selected
D = A		// D = 16
@R0			// RAM[0] selected
M = D		// RAM[0] = 16

// Initialize R1 = 3
@3			// RAM[3] selected
D = A		// D = 3
@R1			// RAM[1] selected
M = D		// RAM[1] = 3

// Divide 16 by 3
(LOOP)
@R1			// RAM[1] selected
D = M		// D = 3; store the divisor in D register

@R0			// RAM[0] selected
MD = M - D	// Subtract divisor from dividend(16 - 3), store answer in D reg and memory location

@ENDLOOP
D;JLE		// If dividend <= 0, quotient found so jump to end of loop
			// otherwise, continue

@R2			// RAM[2] selected; where the answer is stored
M = M + 1	// Increment quotient by 1

@LOOP
0;JMP		// Jump back to start of loop

(ENDLOOP)	// Label to jump to the end of the loop
@ENDLOOP
0;JMP		// Infinite loop to end program