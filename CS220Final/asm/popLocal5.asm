// Initialize SP to 20
@20
D = A
@SP
M = D

// Initialize LCL to 10
@10
D = A
@LCL
M = D

// Push 113 to stack
@113
D = A

// Set RAM[20] to 113
@SP
AM = M + 1      // Increment SP by 1
A = A - 1       // Go back to RAM[20]
M = D           // RAM[20] = 113

// Pop 113 into local 5
@SP
AM = M - 1
D = M
@LCL
A = M + 1
A = A + 1
A = A + 1
A = A + 1
A = A + 1
M = D

// Infinite Loop
(END)
@END
0;JMP