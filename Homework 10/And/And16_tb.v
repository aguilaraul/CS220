//-----------------------------------------------------
// Design Name : And16 Testbench
// File Name   : And16_tb.v
// Function    : Testbench for And16 gate
// Coder       : Raul Aguilar
//-----------------------------------------------------
module And16_tb;
	/*VARIABLE SETUP */
	reg[15:0] a, b; //inputs are registers
	wire[15:0] out; //outputs are wires, one bit default

	//create chip instance and connect it
	And#(16) and1 (
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
	//initial values
		a = 16'b0000_0000_0000_0000;
		b = 16'b0000_0000_0000_0000;
	//ticks
		# 1 a = 16'b0000_0000_0000_0000;
			b = 16'b1111_1111_1111_1111;
			
		# 1 a = 16'b1111_1111_1111_1111;
			b = 16'b0000_0000_0000_0000;
			
		# 1 a = 16'b1111_1111_1111_1111;
			b = 16'b1111_1111_1111_1111;
			
		# 1 a = 16'b1010_1010_1010_1010;
			b = 16'b0101_0101_0101_0101;
			
		# 1 a = 16'b0011_1100_1100_0011;
			b = 16'b0000_1111_1111_0000;
			
		# 1 a = 16'b0001_0010_0011_0100;
			b = 16'b1001_1000_0111_0110;
		# 1 $stop; //stop after last timestep
	end 


	/* RUN TEST */
	//display happens only once
	//monitor runs whenever variables change
	initial begin
		$display("| %16s | %16s | %16s |", "a", "b", "out"); 
		$monitor("| %16b | %16b | %16b |", a, b, out); 
	end 
	
endmodule