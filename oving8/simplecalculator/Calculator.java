package oving8.simplecalculator;

public class Calculator {
	protected double	firstOperand;
	protected double	secondOperand;
	protected char		operator;

	public Calculator(double firstOperand, double secondOperand, char operator) {
		this.firstOperand = firstOperand;
		this.secondOperand = secondOperand;
		this.operator = operator;
	}

	public Calculator() {

	}

	public void setFirstOperand(double firstOperand) {
		this.firstOperand = firstOperand;
	}

	public void setSecondOperand(double secondOperand) {
		this.secondOperand = secondOperand;
	}

	protected void setOperator(char operator) {
		this.operator = operator;
	}

	public double calculateResult() throws IllegalArgumentException {
		if (!sjekk()) {
			throw new IllegalArgumentException("feil operasjon! " + firstOperand
					+ " " + operator + " " + secondOperand);
		}
		switch (operator) {
			case '+':
				return firstOperand + secondOperand;
			case '-':
				return firstOperand - secondOperand;
			case '*':
				return firstOperand * secondOperand;
			case '/':
				return firstOperand / secondOperand;
			case '%':
				return firstOperand % secondOperand;
		}
		return 0;
	}

	public boolean sjekk() {
		if (operator == '/' & secondOperand == 0)
			return false;
		if (operator == '+' || operator == '-' || operator == '/'
				|| operator == '*' || operator == '%')
			return true;
		else
			return false;
	}

	public String toString() {
		return firstOperand + "+" + secondOperand + "=" + calculateResult();
	}

	public void calculateAndSetFirstOperand() {

	}
}
