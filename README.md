# CS220-HW-Projects
Homework and projects built during CS 220: Computer Architecture and Assembly Language

This course introduces the fundamental physical and structural concepts of assembly language programming. Topics include machine architecture, memory addressing, input/output, interrupts, control structures, compiling, and linking.

Following along with *The Elements of Computing Systems* and https://www.nand2tetris.org/

**Homework 1:** Basic Logic Gates

Build some of the logic gates described in Chapter 1, yielding a basic
chip-set. The only building blocks that you can use in this project are primitive Nand gates and
the composite gates that you will gradually build on top of them.

**Homework 2:** Intermediate Logic Gates

Build the rest of the logic gates described in Chapter 1, yielding a
complete basic chip-set. The only building blocks that you can use in this project are primitive
Nand gates and the composite gates that you will gradually build on top of them in the last
homework and this homework.

**Homework 3:** Combinational Chips (Arithmetic + Logic Unit)

Build the gates described in Chapter 2 (see table below), which will test your
understanding of Boolean Logic and Arithmetic, building the gates that do so.

**Homework 4:** Sequential Chips

Build all gates described in Chapter 3 (see table below), which will test your
understanding of sequential chips for our HACK architecture.

**Homework 5:** Machine Language

Write and test the two programs described in what follows. When executed on the CPU emulator, your programs should generate the results mandated by the test scripts supplied in the project directory.

- _Multiplication Program_ (Mult.asm):
The inputs of this program are the current values stored in R0 and R1 (ie., the two top RAM locations). The program computes the product R0 x R1 and stores the result in R2. We assume (in this program) that R0>=0, R1>=0, and R0xR1<32768. Your program need not test these conditions, but rather assume that they hold. The supplied Mult.tst and Mult.cmp scripts will test your program on several representative data values.
- _I/O-Handling Program_ (Fill.asm):
This program runs an infinite loop that listens to the keyboard input. When a key is pressed (any key), the program blackens the screen, namely, writes "black" in every pixel. When no key is pressed, the screen should be cleared. You may choose to blacken and clear the screen in any spatial order, as long as pressing a key continuously for long enough will result in a fully blackened screen and not pressing any key for long enough will result in a cleared screen. This program has a test script (Fill.tst) but no compare file - it should be checked by visibly inspecting the simulated scree.

**Homework 6:** Computer Architecture

Build the Hack computer platform, culminating in the topmost Computer chip. The computer platform built in this project should be capable of executing programs written in the Hack machine language, specified in chapter 4. Demonstrate this capability by having your Computer chip run the three programs given here.

**Homework 7:** Assembler

Develop an assembler that translates programs written in Hack assembly language into the binary code understood by the Hack hardware platform. The assembler must implement the transaltion specification described in section 6.2.

**Homework 8:** Virtual Machine I: Stack Arithmetic

Build the first part of the VM translator, focusing on the implementation of the stack arithmetic and memory access commands of the VM language.

**Homework 9:** Operating System

Implement a Jack OS as described in the chapter

**Homework 10:** Verilog

Recreate some of the Nand2Tetris Project 1 Elementary Gates in Verilog along with their testbenches, to compare our HDL language against an industry-standard language. The following are the only gates you will recreate:
*Not, Not16, And, And16, Or, Or16, Xor, Xor16, DMux, Or8Way*
