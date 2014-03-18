package oving8.simplecalculator;

import java.util.ArrayList;

/***
 * 
 * @author junjun Oppgaven handler om å lage en enkel kalkulator og en
 *         RPN-kalkulator som arver fra den. Denne oppgaven inneholder elementer
 *         fra oppgavene Calculator og RPN-kalkulator under Tilstand og
 *         oppførsel. Formålet med oppgaven er å bli kjent med mekanismen for
 *         arv. Du skal implementere en SimpleCalculator som fungerer som en
 *         vanlig enkel kalkulator. Denne skal også brukes some en superklasse
 *         for en RPN-kalkulator. Når kalkulatorprogrammer starter, skal det
 *         spørre brukeren om hvilken type kalkulator som skal brukes.
 * 
 *         Del 1: SimpleCalculator-klassen Implementer en klasse
 *         SimpleCalculator med metodene:
 * 
 *         protected void setLeftOperand(double operand): skal sette venstre
 *         operand protected void setRightOperand(double operand): skal sette
 *         høyre operand protected void setOperator(char operator): skal sette
 *         operatoren til en av '+', '-', '*', '/' protected double getResult():
 *         skal returnere resultatet av utregningen public void
 *         takeInputNumber(double number): brukes til å ta inn et tall skrevet
 *         inn public void takeInputOperator(char operator): brukes til å ta inn
 *         en operator skrevet inn public boolean hasOutput(): returnerer om det
 *         er på tide å lese av et svar public double getOutput(): returnerer
 *         svaret SimpleCalculator skal fungere slik: Når det kommer inn et
 *         tall, og det forrige som kom inn ikke var en operator, skal tallet
 *         tas til å være venstre operand. Når det kommer inn et tall, og der
 *         forrige som kom inn var en operator, skal tallet tas til å være høyre
 *         operand, og inntil noe annet kommer kommer inn, skal hasOutput
 *         returnere true og getOutput skal være resultatet av utregningen.
 *         Resultatet skal også tas til å være venstre operand til neste gang.
 *         Når det kommer inn en operator, skal det selfølgelig tas til å være
 *         operatoren skal skal brukes i utregningen.
 */
public class SimpleCalculator extends Calculator {

	private ArrayList<String>	list	= new ArrayList<String>();

	protected void setLeftOperand(double operand) {
		super.setFirstOperand(operand);
	}

	protected void setRightOperand(double operand) {
		super.setSecondOperand(operand);
	}

	protected void setOperator(char operator) {
		super.setOperator(operator);
	}

	protected double getResult() {
		return super.calculateResult();
	}

	public void takeInputNumber(double number) {	
		list.add(number + "");
		if (list.size() == 1){
			setLeftOperand(number);
		}
		else if (list.size() > 1 && !("+-*/%".contains(list.get((list.size() - 2))))) {
			setLeftOperand(number);
		} else if (list.size() > 1
				&& ("+-*/%".contains(list.get((list.size() - 2))))) {
			setRightOperand(number);
		}
		else{
			System.out.println("erro her!");
		}
	}

	public void takeInputOperator(char operator) {
		setOperator(operator);
		list.add(operator + "");
	}

	public boolean hasOutput() {
		int l = list.size();
		boolean hasoutput;
		boolean hasoutput1;
		try {
			Double.parseDouble(list.get(l - 1));
			hasoutput = true;
		} catch (NumberFormatException e) {
			hasoutput = false;
		}
		try {
			Double.parseDouble(list.get(l - 2));
			hasoutput1 = false;
		} catch (NumberFormatException e) {
			hasoutput1 = true;
		}
		if (hasoutput && hasoutput1) {
			return true;
		}
		return false;
	}

	public double getOutput() {
		double result = 0.0;
		if (hasOutput()) {
			result = getResult();
			setLeftOperand(result);
			list.add(result + "");
			return result;
		}
		return result;
	}
}
