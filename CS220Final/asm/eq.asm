// Initialize SP to 20
@20
D = A
@SP
M = D

// Push 113 to stack
@113
D = A
@SP
AM = M + 1      // Increment SP by 1
A = A - 1       // Go back to RAM[20]
M = D           // RAM[20] = 113

// Push 220 to stack
@220
D = A
@SP
AM = M + 1      // RAM[22]
A = A - 1       // Go back to RAM[21]
M = D           // RAM[21] = 220

// Compare Equality
@SP             // RAM[22]
AM = M - 1      // Decrement SP and move back 1
D = M           // RAM[21] == 220
A = A - 1       // RAM[20]
D = D - M       // D = 220 - 113
@true
D;JEQ           // if 220 - 133 == 0 then jump to (true)
@else          // else fall through
D = -1          // D = false
0;JMP
(true)
D = 0           // D = true
(else)
@SP             // RAM[21]
A = M - 1       // RAM[20]
M = D           // RAM[20] == false

// Infinite Loop
(END)
@END
0;JMP