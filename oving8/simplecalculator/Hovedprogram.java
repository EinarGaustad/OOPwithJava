package oving8.simplecalculator;

import java.util.Scanner;

public class Hovedprogram {
	private SimpleCalculator	calc;

	public void init(SimpleCalculator calc) {
		this.calc = calc;
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Write s for - s: SimpleCalculator" + "\n"
				+ "Write r for - r: RPNCalculator" + "\n");
		if (((String) sc.next()).equalsIgnoreCase("r")) {
			init(new RPNCalculator());
		} else {// if (input.equalsIgnoreCase("s")){
			init(new SimpleCalculator());
		}
		System.out.println("to stop wirte stop!");
		while (true) {
			System.out.println("input:");
			if (sc.hasNextDouble()) {
				calc.takeInputNumber(sc.nextDouble());
			} else {
				String input = sc.next();
				if (input.equalsIgnoreCase("stop")) {
					break;
				} else if ("+-*/%".contains(input)) {
					if (input.length() == 1) {
						calc.takeInputOperator(((char) input.charAt(0)));
					} else {
						System.out.println("erro! Operator");
					}
				} else if (input.equalsIgnoreCase("=")) {

					if (calc.hasOutput()) {
						System.out.println(calc.getOutput());
					} else {
						System.out.println("don't have output!");
					}
				} else {
					System.out.println("ERRO! write again!");
				}
			}
		}
		sc.close();
	}

	public static void main(String[] args) {
		Hovedprogram program = new Hovedprogram();
		program.run();
	}
}
