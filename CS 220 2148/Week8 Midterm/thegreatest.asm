@7
D = A
@R1
M = D

@11
D = A
@R2
M = D

@5
D = A
@R3
M = D

// R1 - R2 < 0
@R1
D = M
@R2
D = D - M

@ELSEIF
D;JLT

// R1 - R3 < 0
@R1
D = M
@R3
D = D - M

@ELSE1
D;JLT

// R0 = R1
@R1
D = M
@R0
M = D
@END
0;JMP

(ELSE1)
@R3
D = M
@R0
M = D
@END
0;JMP

(ELSEIF)
// R2 - R3 < 0
@R2
D = M
@R3
D = D - M
@ELSE2
D;JLT

// R0 = R2
@R2
D = M
@R0
M = D
@END
0;JMP

(ELSE2)
// R0 = R3
@R3
D = M
@R0
M = D

(END)
@END
0;JMP