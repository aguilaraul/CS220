//-----------------------------------------------------
// Design Name : And
// File Name   : And.v
// Function    : And chip (parameterized)
// Coder       : Raul Aguilar
//-----------------------------------------------------
module And#(parameter WIDTH = 16)
(
	input[WIDTH-1:0] a, b,
	output[WIDTH-1:0] out
);
	assign out[WIDTH-1:0] = a[WIDTH-1:0] & b[WIDTH-1:0];

endmodule