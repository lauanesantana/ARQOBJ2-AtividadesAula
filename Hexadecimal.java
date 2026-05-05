
public enum Hexadecimal {
	A(10),
	B(11),
	C(12),
	D(13),
	E(14),
	F(15);
	
	private Integer numbers; 
	
	Hexadecimal (Integer numbers) { 
		this.numbers = numbers; 
	}
	Integer getHexadecimal() { 
		return numbers; 
	}
}


