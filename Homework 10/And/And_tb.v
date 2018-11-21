//-----------------------------------------------------
// Design Name : And Testbench
// File Name   : And_tb.v
// Function    : Testbench for And gate
// Coder       : Raul Aguilar
//-----------------------------------------------------
module And_tb;
	/*VARIABLE SETUP */
	reg a, b; //inputs are registers
	wire out; //outputs are wires, one bit default

	//create chip instance and connect it
	And and1 (
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