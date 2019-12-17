//-----------------------------------------------------
// Design Name : DMux
// File Name   : DMux.v
// Function    : DMux chip (parameterized)
// Coder       : Raul Aguilar
//-----------------------------------------------------
module DMux(
	input in, sel,
	output a, b
);
	reg a, b;
	always @( sel or in)
		begin
			if(sel == 1'b0) begin
				a = in;
				b = 1'b0;
			end else begin
				a = 1'b0;
				b = in;
			end
		end

endmodule