//-----------------------------------------------------
// Design Name : Xor Testbench
// File Name   : Xor.v
// Function    : Testbench for Xor gate
// Coder       : Raul Aguilar
//-----------------------------------------------------
module Xor_tb;
	/*VARIABLE SETUP */
	reg a, b; //inputs are registers
	wire out; //outputs are wires, one bit default

	//create chip instance and connect it
	Xor xor1 (
		.a		(a),
		.b		(b),
		.out	(out)
	);
	
	/* PULSING CLOCK FOR TEST
	(changes phase after each timestep) */
	reg clk = 0;
	always #1 clk = !clk;
	
	/* TEST VALUES 
	# 1 means wait one timestep */
	initial begin
		a = 0;//initial values
		b = 0;
		# 1 a = 0;
			b = 1;
		# 1 a = 1;
			b = 0;
		# 1 a = 1;
			b = 1;
		# 1 $stop; //stop after last timestep
	end 


	/* RUN TEST */
	//display happens only once
	//monitor runs whenever variables change
	initial begin
		$display("|  a  |  b  | out |"); 
		$monitor("|  %b  |  %b  |  %b  |", a, b, out); 
	end
	
endmodule //End of Not_tb