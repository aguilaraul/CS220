//-----------------------------------------------------
// Design Name : Not
// File Name   : Not.v
// Function    : Not chip (parameterized)
// Coder       : Raul Aguilar
//-----------------------------------------------------
module Not#(parameter WIDTH = 16)
 (input[WIDTH-1:0] in, output[WIDTH-1:0] out);

	assign out[WIDTH-1:0] = ~in[WIDTH-1:0];

endmodule //End Of Module Not
