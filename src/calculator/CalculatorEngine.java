package calculator;

public class CalculatorEngine {
	int value;
	int keep;
	char toDo;
	
	void binaryOperation(char op){
		keep = value;
		value = 0;
		toDo = op;
	}
	
	void add() 		{ binaryOperation('+'); }
	void subtract() { binaryOperation('-'); }
	void multiply() { binaryOperation('*'); }
	void divide() 	{ binaryOperation('/'); }
	
	void compute() {
		if (toDo == '+')
			value = keep + value;
		else if (toDo == '-')
			value = keep - value;
		else if (toDo == '*')
			value = keep * value;
		else if (toDo == '/')
			value = keep / value;
		keep = 0;
	}
	
	void  clear() {
		value = 0;
		keep = 0;
	}
	
	void digit(int x) {
		value = value*10 + x;
	}
	
	int display() {
		return(value);
	}
	
	CalculatorEngine() { clear(); }
	
	public static void main(String arg[]) {
		CalculatorEngine c = new CalculatorEngine();
		c.digit(1);
		c.digit(3);
		c.add();
		c.digit(1);
		c.digit(1);
		c.compute();
		System.out.println(c.display());
	}
}