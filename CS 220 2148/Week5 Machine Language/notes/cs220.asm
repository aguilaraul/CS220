@50
D = A
@n
M = D

@i
M = 1
(FOR)
@i
D = M
@n
D = D - M
@END
D;JGT

@SCREEN
A = A + D
M=-1

@i
M = M + 1

@FOR
0;JMP

(END)
@END
0;JMP