package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CalculatorInput {
	BufferedReader stream;
	CalculatorEngine engine;
	
	CalculatorInput(CalculatorEngine e){
		InputStreamReader input = new InputStreamReader(System.in);
		stream = new BufferedReader(input);
		engine = e;
	}
	
	void run() {
		for (;;) {
			System.out.print("[" + engine.display() + "]");
			String m;

			try {
				m = stream.readLine();
			
				if (m == null) break;
				if (m.length() > 0) {
				char c = m.charAt(0);
				if (c == '+') engine.add();
				else if (c == '-') engine.subtract();
				else if (c == '*') engine.multiply();
				else if (c == '/') engine.divide();
				else if (c >= '0' && c <= '9') engine.digit(c - '0');
				else if (c == '=') engine.compute();
				else if (c == 'c' || c == 'C') engine.clear();
				}
			} catch (IOException e) {
				engine.clear();
			}
		}
	}
	
	public static void main(String arg[]) throws Exception {
		CalculatorEngine e = new CalculatorEngine();
		CalculatorInput x = new CalculatorInput(e);
		x.run();
	}
}