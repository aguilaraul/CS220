// check if R0 or R1 is 0, if so skip to end
// otherwise continue
	@2			// reset answer
	M=0

	@0			// A = 0
	D=M			// check if RAM[0] == 0 (D = data in RAM[0])
	@END
	D;JEQ		// skip to end if zero

	@1			// A = 1
	D=M			// check if RAM[1] == 0 (D = data in RAM[1])
	@END
	D;JEQ		// skip to end if 0
	
(LOOP)
	@0			// set A to where dividend is being stored (A = R0)
	D=M			// take the dividend (D = RAM[0])
	@1			// go to stored divisor
	D=D-M		// and sub it from the dividend (M-D)
	@0
	M=D			// store the difference back into R0
	@END
	D;JLT		// if difference was < 0 then end division
	@2
	M=M+1		// otherwise increment how many times the divisor goes into the dividend/difference
	@LOOP
	D;JGT		// and do it again

(END)			// infinite loop to end program
	@END
	0;JMP