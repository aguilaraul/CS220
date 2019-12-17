# Homework 5: Machine Language

#### Objective
Get a taste of low-level programming in machine language, and get acquainted
with the Hack computer platform. In the process of working on this project, you
will also become familiar with the assembly process, and you will appreciate
visually how the translated binary code executes on the target hardware.

#### Resources
In this project you will use two tools supplied with the book: An _assembler_,
designed to translate Hack assembly programs into binary code, and a _CPU
emulator_, designed to run binary programs on a simulated Hack platform.

#### Contract
Write and test the two programs described in what follows. When executed on the
CPU emulator, your programs should generate the results mandated by the test
scripts supplied in the project directory.

- _Multiplication Program_ (Mult.asm):
The inputs of this program are the current values stored in R0 and R1 (i.e., the
two top RAM locations). The program computes the product R0 x R1 and stores the
result in R2. We assume (in this program) that R0>=0, R1>=0, and R0xR1<32768.
Your program need not test these conditions, but rather assume that they hold.
The supplied Mult.tst and Mult.cmp scripts will test your program on several
representative data values.

- _I/O-Handling Program_ (Fill.asm):
This program runs an infinite loop that listens to the keyboard input. When a
key is pressed (any key), the program blackens the screen, namely, writes
"black" in every pixel. When no key is pressed, the screen should be cleared.
You may choose to blacken and clear the screen in any spatial order, as long as
pressing a key continuously for long enough will result in a fully blackened
screen and not pressing any key for long enough will result in a cleared screen.
This program has a test script (Fill.tst) but no compare file - it should be
checked by visibly inspecting the simulated screen.
