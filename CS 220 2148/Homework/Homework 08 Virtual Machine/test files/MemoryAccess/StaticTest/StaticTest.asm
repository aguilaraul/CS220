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
@111
D = A
@SP
M = M + 1
A = M - 1
M = D
@333
D = A
@SP
M = M + 1
A = M - 1
M = D
@888
D = A
@SP
M = M + 1
A = M - 1
M = D
@SP
AM = M - 1
D = M
@StaticTest.8
M = D
@SP
AM = M - 1
D = M
@StaticTest.3
M = D
@SP
AM = M - 1
D = M
@StaticTest.1
M = D
@StaticTest.3
D = M
@SP
M = M + 1
A = M - 1
M = D
@StaticTest.1
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
@StaticTest.8
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
