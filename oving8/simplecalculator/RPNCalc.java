package oving8.simplecalculator;

import java.util.Stack;
import java.util.ArrayList;

/***
 * 
 * @author junjun Oppgaven handler om å lage en RPN-kalkulator (RPN=Reverse
 *         Polish Notation). Denne oppgaven kommer til å ta i bruk en stack og
 *         utføre matematiske operasjoner. Du kan enten begynne fra scratch
 *         eller ta i bruk deler av løsningene til Calculator-oppgave og Stack
 *         for tilfeldige String-objekter.
 * 
 *         Her er en forklaring av hvordan en RPN-kalkulator fungerer:
 * 
 * 
 *         The RPN calculator differs from a normal calculator in that its
 *         syntax is completely different: It uses postfix notation instead of
 *         infix notation.
 * 
 *         Reverse polish notation, or postfix notation, is a notation where the
 *         operators (+, -, *, /, ...) appear after the operands (1.0, 3.14,
 *         2.187, 42, …). As an example, consider the expressions “2 – 1” and “9
 *         + 3*4”. In RPN, this would be “2 1 -” and “9 3 4 * +”, as the
 *         operator shall appear after the operands. If the last example is
 *         confusing, think of it as “9 (3 4 *) +” instead.
 * 
 *         The main advantage of this is notation is that we can avoid
 *         parentheses and avoid determining which calculation to perform first.
 *         In infix, operator precedence is a problem: In the expression “9 +
 *         3*4”, we first have to multiply, even though the plus operator
 *         appears first. In RPN, we simply take the first operator we see and
 *         apply it on the last two numbers we've seen, and replace the operator
 *         and operands with the result. For the multiplication and addition
 *         example:
 * 
 *         “9 3 4 * +” - the first operator we see is *, so we apply that to the
 *         two last seen values, 3 and 4, and replace those elements with the
 *         result, 12 “9 12 +” - the next operator we see is +, so we apply that
 *         to 9 and 12 “21” - We are finished, as there are no more operators in
 *         the expression
 * 
 *         For the more complex expression “(9 + 7) / (5 – 3)”, this will be
 *         written as “9 7 + 5 3 - /” in RPN. Notice how we can avoid
 *         parentheses and still calculate what we want without any issues:
 * 
 *         “9 7 + 5 3 - /” - the first operator is +, so we perform “9 + 7” and
 *         replace those elements with the result “16 5 3 - /” - the next
 *         operator is -, so we perform the operation “5 – 3”, as those are the
 *         last two elements “16 2 /” - we perform the last operation, division:
 *         “8” - We are done, as there are no more operators left.
 * 
 *         Most RPN calculators have a stack of numbers, giving them control
 *         over which numbers to do operations on when they see the next
 *         operand. Whenever they see an operand, they push it on the stack. If
 *         they see an operator, they pop off the numbers required, perform the
 *         operation, and push the result on top of the stack again.
 * 
 *         As an example of how this will work, consider the example “9 3 4 * +”
 *         once more. Here, an RPN calculator will first push 9, 3 and 4 on the
 *         stack. The stack will now look like this: [9, 3, 4], where 4 is the
 *         top of the stack. Then, when the calculator see the operator *, it
 *         then pops 4 off the stack, pops 3 off the stack, and pushes 3 * 4 on
 *         top of the stack. The stack which now contains [9, 12]. Then, when
 *         the RPN calculator sees the operator *, it pops off 12 and 9 off the
 *         stack, and performs the operation 9 + 12, and pushes it back on top
 *         of the (now empty) stack. The stack will now contain [21]. Tilstanden
 *         i RPNCalc-objekter velger du selv, men det er naturlig å bruke en
 *         Stack eller ArrayList med Double-objekter.
 * 
 *         RPNCalc-klassen skal ha følgende metoder:
 * 
 *         void push(double) - legg argumentet på toppen av stacken.
 * 
 *         double pop() - returner verdien på toppen av stacken. Verdien skal
 *         også fjernes fra stacken. Dersom stacken er tom, så skal Double.NaN
 *         returneres.
 * 
 *         double peek(int) - returner verdien i stacken som står på plassen
 *         gitt i argumentet, telt fra toppen. Det vil si, peek(0) skal
 *         returnere verdien på toppen av stacken, peek(1) skal returnere
 *         verdien nest øverst i stacken osv. Verdien skal ikke fjernes av
 *         stacken. Dersom det er for få elementer på stacken, så skal
 *         Double.NaN returneres.
 * 
 *         int getSize() - returner antallet elementer i stacken. void
 *         performOperation(char) - utfør den angitte operasjonen på de to
 *         øverste verdiene i stacken. De to verdiene skal fjernes fra stacken
 *         og resultatet skal legges øverst. Bruk eksisterende metoder for å
 *         utføre dette der det er mulig. Metoden må støtte '+' (pluss), '-'
 *         (minus), '*' (multiplikasjon) og '/' (divisjon), men kan også støtte
 *         andre operatorer, f.eks. '~' (swap) for å bytte de to øverste
 *         operandene, 'p' eller 'π' (pi) for å legge pi på stacken (bruker
 *         ingen operander), '|' (absolutt-verdi, bruker én operand). Prøv å
 *         håndtere manglende operander på en måte som gir mening for
 *         operasjonen.
 */

public class RPNCalc {
	protected Stack<Double>		stack	= new Stack<Double>();
	protected ArrayList<Double>	list	= new ArrayList<Double>();

	public void push(double tall) {
		stack.push(tall);
	}

	public double pop() {
		return (double) stack.pop();
	}

	public double peek(int tall) {
		if (stack.empty() || tall < 0 || tall >= stack.size())
			return Double.NaN;
		else {
			toList();
			return list.get(tall);
		}
	}

	public void toList() {
		list.clear();
		while (!stack.empty()) {
			list.add(stack.pop());
		}
		for (int i = 0; i < list.size(); i++) {
			push(list.get(list.size() - i - 1));
		}
	}

	public int getSize() {
		if (stack.empty())
			return 0;
		toList();
		return list.size();
	}

	public String toString() {
		String ut = "";
		for (int i = 0; i < getSize(); i++)
			ut += peek(i) + "" + '\n';
		return ut;
	}

	public void performOperation(char operator) {
		double firstOperand = pop();
		double secondOperand = pop();
		switch (operator) {
			case '+':
				push(firstOperand + secondOperand);
				break;
			case '-':
				push(secondOperand - firstOperand);
				break;
			case '*':
				push(firstOperand * secondOperand);
				break;
			case '/': {
				if (secondOperand == 0) {
					push(secondOperand);
					push(firstOperand);
				} else
					push(secondOperand / firstOperand);
			}
				break;
			case '%':
				push(firstOperand % secondOperand);
				break;
			case '~': {
				push(firstOperand);
				push(secondOperand);
			}
				;
				break;
			case 'π':
			case 'p': {
				push(secondOperand);
				push(firstOperand);
				push(Math.PI);
			}
				break;
			case '|': {
				push(secondOperand);
				push(Math.abs(firstOperand));
			}
				break;
		}
	}
}
