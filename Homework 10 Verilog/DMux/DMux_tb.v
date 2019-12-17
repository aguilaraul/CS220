//-----------------------------------------------------
// Design Name : DMux Testbench
// File Name   : DMux.v
// Function    : Testbench for DMux gate
// Coder       : Raul Aguilar
//-----------------------------------------------------
module DMux_tb;
	/*VARIABLE SETUP */
	reg in, sel; //inputs are registers
	wire a, b; //outputs are wires, one bit default

	//create chip instance and connect it
	DMux dmux1 (
		.in		(in),
		.sel	(sel),
		.a		(a),
		.b		(b)
	);
	
	/* PULSING CLOCK FOR TEST
	(changes phase after each timestep) */
	reg clk = 0;
	always #1 clk = !clk;
	
	/* TEST VALUES 
	# 1 means wait one timestep */
	initial begin
		//initial values
		in = 0;
		sel = 0;
		//test values
		# 1 sel = 1;
		# 1 in = 1;
			sel = 0;
		# 1 sel = 1;
		# 1 $stop; //stop after last timestep
	end 


	/* RUN TEST */
	//display happens only once
	//monitor runs whenever variables change
	initial begin
		$display("|  in  |  sel  |  a  |  b  |"); 
		$monitor("|   %b  |   %b   |  %b  |  %b  |", in, sel, a, b); 
	end
	
endmodule