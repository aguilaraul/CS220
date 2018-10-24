// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Mult.asm

// Multiplies R0 and R1 and stores the result in R2.
// (R0, R1, R2 refer to RAM[0], RAM[1], and RAM[2], respectively.)

// Put your code here.

// if R0 or R1 is equal to 0 skip to end
// else continue
    @2              // set A to 2
    M = 0           // set RAM[2] = 0
    @0              // set A to 0
    D = M           // sets D to data in RAM[0]
    @END            // Jumps to END if D = 0
    D; JEQ
    @1              // sets A to 1
    D = M           // sets D to data in RAM[1]
    @END            // Jumps to END if D = 0
    D; JEQ

(LOOP)
    @2              // sets A to 2
    D = M           // D = RAM[2]
    @0              // sets A to 0
    A = M           // sets A to data in RAM[0]
    D = D+A         // adds RAM[2] + RAM[0]

    @2              // sets a to 2
    M = D           // stores D in RAM[2]

    @1              // set A to 1
    D = M           // set D to data in RAM[1]
    MD = D-1        // decrements 1 from RAM[1] and assigns new value to D and RAM[1]
    @END
    D; JEQ          // jumps to END if D = 0
    @LOOP
    D; JGT          // else continues mulitplying
(END)
    @END
    0; JMP          // infinite loop to end program
