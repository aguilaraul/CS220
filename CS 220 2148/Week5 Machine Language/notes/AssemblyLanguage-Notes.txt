// int x = 5;
@5		// A-instruction: A=5 + selects RAM[5]
D=A		// Store A in D; D=5
@x		// A=16, RAM[16] is selected
M=D		// RAM[16] = D; RAM[16] = 5

// int y = 3
@3
D=A
@y
M=D

// int min = 0
@min
M=0

// int max = 0;
@max
M=0

// if (x-y>=0), jump to else
@x
D=M
@y
D=D-M	// D=5-3 -> D=2
@ELSE
D;JGE
// If code
// min = x
@x		// RAM[16] = 5
D=M		// D = 5
@min	// RAM[18] = 0
M=D		// RAM[18] = 5

// max = y
@y		
D=M
@max
M=D

// Jump to end of If statement
@ENDIF
0;JMP

(ELSE)	// Else code
// min = y
@y
D=M
@min
M=D

// max = x
@x
D=M
@max
M=D

(ENDIF)