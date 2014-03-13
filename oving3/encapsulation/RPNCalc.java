package oving3.encapsulation;

import java.util.Stack;
import java.util.ArrayList;



public class RPNCalc {
	private Stack<Double> stack=new Stack<Double>();
	private ArrayList<Double> list=new ArrayList<Double>();
	//private så variabler blir ikke enderes utenfor
	
	public void push(double tall){
		stack.push(tall);
	}
	public double pop(){
		return (double)stack.pop();
	}
	public double peek(int tall){
		if (stack.empty())
			return Double.NaN;
		else{
			toList();
			return list.get(tall);
		}
	}
	public void toList(){
		list.clear();
		while(!stack.empty()){
			list.add(stack.pop());
		}
		for(int i=0;i<list.size();i++){
			push(list.get(list.size()-i-1));
		}
	}
	public int getSize(){
		if (stack.empty())
			return 0;
		toList();
		return list.size();
	}
	public String toString(){
		String ut="";
		for(int i=0; i<getSize(); i++)
			ut+=peek(i)+""+'\n';
		return ut;
	}
	public void performOperation(char operator){
		double firstOperand=pop();
		double secondOperand=pop();
		switch (operator){
		case '+': push(firstOperand + secondOperand);
		break;
		case '-': push(firstOperand - secondOperand);
		break;
		case '*': push(firstOperand * secondOperand);
		break;
		case '/': {
			if (secondOperand==0){
				push(secondOperand);
				push(firstOperand);
			}
			else
				push(firstOperand / secondOperand);
		}
		break;
		case '%': push(firstOperand % secondOperand);
		break;
		case '~': {
				push(firstOperand);
				push(secondOperand);
		};
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

