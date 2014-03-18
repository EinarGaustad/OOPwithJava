package oving8.simplecalculator;

import java.util.Stack;

/***
 * 
 * @author JunJunGuo Del 2: Subklasser Lag en subklasse RPNCalculator. Denne
 *         skal arve fra SimpleCalculator, og skal redefinere takeInputNumber,
 *         takeInputOperator, hasOutput og getOutput. Her skal du gjenbruke
 *         resten av metodene fra SimpleCalculator.
 * 
 *         RPNCalculator skal fungere slik: Når det kommer inn et tall, skal det
 *         gå på stacken. Når det kommer inn en operator, skal operandene komme
 *         av stakken, og hasOutput returnere true og getOutput skal være
 *         resultatet av utregningen inntil noe annen kommer inn. Resultatet
 *         skal også inn på toppen av stakken.
 */
public class RPNCalculator extends SimpleCalculator {

	private Stack<Double>	stack		= new Stack<Double>();

	@Override
	public void takeInputNumber(double number) {
		stack.add(number);
	}
	@Override
	public void takeInputOperator(char operator) {	
			setOperator(operator);		
	}
	@Override
	public boolean hasOutput() {
		System.out.println(stack.size()+"stacks");
		if (stack.size()>=2) {// && firstOperand!=0.0 && secondOperand !=0.0){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public double getOutput() {
		if (stack.size() <= 1) {
			System.out.println("not enough number to operate! "+stack.size());
			//throw new IllegalArgumentException("illegal format!");
		} else {
			setRightOperand(stack.pop());
			setLeftOperand(stack.pop());
		}
		double r = calculateResult();
		this.stack.add(r);
		return r;
	}
}
