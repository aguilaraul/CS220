//-----------------------------------------------------
// Design Name : Or8Way Testbench
// File Name   : Or8Way.v
// Function    : Testbench for Or gate
// Coder       : Raul Aguilar
//-----------------------------------------------------
module Or8Way_tb;
	/*VARIABLE SETUP */
	reg[7:0] in; //inputs are registers
	wire out; //outputs are wires, one bit default

	//create chip instance and connect it
	Or8Way or8way1 (
		.in		(in),
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
		in = 8'b0000_0000;
		// test values
		# 1 in = 8'b1111_1111;
		# 1 in = 8'b0001_0000;
		# 1 in = 8'b0000_0001;
		# 1 in = 8'b0010_0110;
		# 1 $stop; //stop after last timestep
	end 


	/* RUN TEST */
	//display happens only once
	//monitor runs whenever variables change
	initial begin
		$display("| %8s | %s |", "in", "out"); 
		$monitor("| %8b |  %b  |", in, out); 
	end
	
endmodule