// Initialize SP to 20
@20
D = A
@SP
M = D

// Push 113 to stack
@113
D = A

// Set RAM[20] to 113
@SP
AM = M + 1      // Increment SP by 1 == RAM[21]
A = A - 1       // Go back to RAM[20]
M = D           // RAM[20] = 113

// Push 107 to stack
@107
D = A
@SP
AM = M + 1      // Increment SP by 1 == RAM[22]
A = A - 1       // Go back to RAM[21]
M = D           // RAM[21] = 107

// Add 113 + 107
@SP             // RAM[22]
AM = M - 1      // RAM[21]
D = M           // RAM[21] Get 107
A = A - 1       // RAM[20]
M = M + D       // RAM[20] + 107 == 113 + 107

// Infinite Loop
(END)
@END
0;JMP