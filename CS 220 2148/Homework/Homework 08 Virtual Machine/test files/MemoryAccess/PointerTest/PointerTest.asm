@256
D = A
@SP
M = D
@RETURN_LABEL1
D = A
@SP
M = M + 1
A = M - 1
M = D
@LCL
D = M
@SP
M = M + 1
A = M - 1
M = D
@ARG
D = M
@SP
M = M + 1
A = M - 1
M = D
@THIS
D = M
@SP
M = M + 1
A = M - 1
M = D
@THAT
D = M
@SP
M = M + 1
A = M - 1
M = D
@SP
D = M
@5
D = D - A
@0
D = D - A
@ARG
M = D
@SP
D = M
@LCL
M = D
@Sys.init
0;JMP
(RETURN_LABEL1)
@3030
D = A
@SP
M = M + 1
A = M - 1
M = D
@SP
AM = M - 1
D = M
@THIS
M = D
@3040
D = A
@SP
M = M + 1
A = M - 1
M = D
@SP
AM = M - 1
D = M
@THAT
M = D
@32
D = A
@SP
M = M + 1
A = M - 1
M = D
@SP
AM = M - 1
D = M
@THIS
A = M + 1
A = A + 1
M = D
@46
D = A
@SP
M = M + 1
A = M - 1
M = D
@SP
AM = M - 1
D = M
@THAT
A = M + 1
A = A + 1
A = A + 1
A = A + 1
A = A + 1
A = A + 1
M = D
@THIS
D = M
@SP
M = M + 1
A = M - 1
M = D
@THAT
D = M
@SP
M = M + 1
A = M - 1
M = D
@SP
AM = M - 1
D = M
A = A - 1
M = M + D
@THIS
A = M + 1
A = A + 1
D = M
@SP
M = M + 1
A = M - 1
M = D
@SP
AM = M - 1
D = M
A = A - 1
M = M - D
@6
D = A
@THAT
A = D + M
D = M
@SP
M = M + 1
A = M - 1
M = D
@SP
AM = M - 1
D = M
A = A - 1
M = M + D
(END)
@END
0;JMP
