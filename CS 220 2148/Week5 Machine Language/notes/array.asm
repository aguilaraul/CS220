//int size = 10
@10
D=A
@size
M=D

// Declare an array at location 20
// int[] arr = new int[size]
// Create an array of size 10
// Reserve 10 registers in RAM where avaliable
@20
D=A
@arr
M=D

// int i = 0;
@i
M=0

(LOOP)
//i - size >= 0
// JUMP TO ENDLOOP
@i
D=M
@size
D = D - M

@ENDLOOP
D;JGE

@i
D = M		// D = i = 0

// arr[i]
@arr		// RAM[17] = 20
A = M + D

// arr[i] = i;
M = D

// i++
@i
M = M + 1

@LOOP
0;JMP

(ENDLOOP)