# Homework 6: Computer Architecture
#### Objective
Build the Hack computer platform, culminating in the topmost Computer chip.

#### Resources
The only tools that you need for completing this project are the hardware
simulator supplied with the book and the test scripts described here. The
computer platform should be implemented in the HDL language specified in
appendix A.

#### Contract
The computer platform built in this project should be capable of executing
programs written in the Hack machine language, specified in chapter 4.
Demonstrate this capability by having your Computer chip run the three programs
given here.

#### Component Testing
We supply test scripts and compare files for unit-testing the Memory and CPU
chips in isolation. It's important to complete the testing of these chips
before building and testing the overall Computer chip.

#### Test Programs
A natural way to test the overall Computer chip implementation is to have it
execute some sample programs written in the Hack machine language. In order to
run such a test, one can write a test script that loads the Computer chip into
the hardware simulator, loads a program from an external text file into its ROM
chip, and then runs the clock enough cycles to execute the program. We supply
all the files necessary to run three such tests, as follows:

1. Add.hack: Adds the constants 2 and 3 and writes the result in RAM[0]
2. Max.hack: Computes the maximum of RAM[0] and RAM[1] and writes the result in
RAM[2].
3. Rect.hack: Draws a rectangle of width 16 pixels and length RAM[0] at the top
left of the screen.

Before testing your Computer chip on any one of the above programs, read the
test script associated with the program and be sure to understand the
instructions given to the simulator.
