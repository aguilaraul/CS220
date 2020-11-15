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
@17
D = A
@SP
M = M + 1
A = M - 1
M = D
@17
D = A
@SP
M = M + 1
A = M - 1
M = D
@SP
AM = M - 1
D = M
A = A - 1
D = D - M
@_2
D;JEQ
@_3
D = 0
0;JMP
(_2)
D = -1
(_3)
@SP
A = M - 1
M = D
@17
D = A
@SP
M = M + 1
A = M - 1
M = D
@16
D = A
@SP
M = M + 1
A = M - 1
M = D
@SP
AM = M - 1
D = M
A = A - 1
D = D - M
@_4
D;JEQ
@_5
D = 0
0;JMP
(_4)
D = -1
(_5)
@SP
A = M - 1
M = D
@16
D = A
@SP
M = M + 1
A = M - 1
M = D
@17
D = A
@SP
M = M + 1
A = M - 1
M = D
@SP
AM = M - 1
D = M
A = A - 1
D = D - M
@_6
D;JEQ
@_7
D = 0
0;JMP
(_6)
D = -1
(_7)
@SP
A = M - 1
M = D
@892
D = A
@SP
M = M + 1
A = M - 1
M = D
@891
D = A
@SP
M = M + 1
A = M - 1
M = D
@SP
AM = M - 1
D = M
A = A - 1
D = D - M
@_8
D;JGT
@_9
D = 0
0;JMP
(_8)
D = -1
(_9)
@SP
A = M - 1
M = D
@891
D = A
@SP
M = M + 1
A = M - 1
M = D
@892
D = A
@SP
M = M + 1
A = M - 1
M = D
@SP
AM = M - 1
D = M
A = A - 1
D = D - M
@_10
D;JGT
@_11
D = 0
0;JMP
(_10)
D = -1
(_11)
@SP
A = M - 1
M = D
@891
D = A
@SP
M = M + 1
A = M - 1
M = D
@891
D = A
@SP
M = M + 1
A = M - 1
M = D
@SP
AM = M - 1
D = M
A = A - 1
D = D - M
@_12
D;JGT
@_13
D = 0
0;JMP
(_12)
D = -1
(_13)
@SP
A = M - 1
M = D
@32767
D = A
@SP
M = M + 1
A = M - 1
M = D
@32766
D = A
@SP
M = M + 1
A = M - 1
M = D
@SP
AM = M - 1
D = M
A = A - 1
D = D - M
@_14
D;JLT
@_15
D = 0
0;JMP
(_14)
D = -1
(_15)
@SP
A = M - 1
M = D
@32766
D = A
@SP
M = M + 1
A = M - 1
M = D
@32767
D = A
@SP
M = M + 1
A = M - 1
M = D
@SP
AM = M - 1
D = M
A = A - 1
D = D - M
@_16
D;JLT
@_17
D = 0
0;JMP
(_16)
D = -1
(_17)
@SP
A = M - 1
M = D
@32766
D = A
@SP
M = M + 1
A = M - 1
M = D
@32766
D = A
@SP
M = M + 1
A = M - 1
M = D
@SP
AM = M - 1
D = M
A = A - 1
D = D - M
@_18
D;JLT
@_19
D = 0
0;JMP
(_18)
D = -1
(_19)
@SP
A = M - 1
M = D
@57
D = A
@SP
M = M + 1
A = M - 1
M = D
@31
D = A
@SP
M = M + 1
A = M - 1
M = D
@53
D = A
@SP
M = M + 1
A = M - 1
M = D
@SP
AM = M - 1
D = M
A = A - 1
M = M + D
@112
D = A
@SP
M = M + 1
A = M - 1
M = D
@SP
AM = M - 1
D = M
A = A - 1
M = M - D
@SP
A = M - 1
M = -M
@SP
AM = M - 1
D = M
A = A - 1
M = D&M
@82
D = A
@SP
M = M + 1
A = M - 1
M = D
@SP
AM = M - 1
D = M
A = A - 1
M = D|M
@SP
A = M - 1
M = !M
(END)
@END
0;JMP
