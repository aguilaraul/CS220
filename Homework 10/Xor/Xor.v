//-----------------------------------------------------
// Design Name : Xor
// File Name   : Xor.v
// Function    : Xor chip (parameterized)
// Coder       : Raul Aguilar
//-----------------------------------------------------
module Xor#(parameter WIDTH = 16)
(
	input[WIDTH-1:0] a, b,
	output[WIDTH-1:0] out
);
	assign out[WIDTH-1:0] = (a[WIDTH-1:0] ^ b[WIDTH-1:0]);

endmodule