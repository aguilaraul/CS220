//-----------------------------------------------------
// Design Name : Or Testbench
// File Name   : Or.v
// Function    : Testbench for Or gate
// Coder       : Raul Aguilar
//-----------------------------------------------------
module Or_tb;
	/*VARIABLE SETUP */
	reg a, b; //inputs are registers
	wire out; //outputs are wires, one bit default

	//create chip instance and connect it
	Or or1 (
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
		// initial values
		a = 0;
		b = 0;
		// test values
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
	
endmodule