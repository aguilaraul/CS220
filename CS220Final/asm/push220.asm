// Initialize SP to 20
@20
D = A
@SP
M = D

// Get 220
@220
D = A

// Set RAM[20] to 220
@SP
AM = M + 1      // Increment SP by 1
A = A - 1       // Go back to RAM[20]
M = D           // RAM[20] = 220

// Infinite Loop
(END)
@END
0;JMP