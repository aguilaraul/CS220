//int sum = 0;
@sum
M = 0

// int i = 2;
@2
D = A
@i
M = D

// while(i<=100)
(LOOP)
@100
D = A
@i
D = M - D

@ENDLOOP
D;JGT

// sum += i
@i
D=M
@sum
M=M+D

// i += 2
@2
D=A
@i
M=M+D

@LOOP
0;JMP

(ENDLOOP)