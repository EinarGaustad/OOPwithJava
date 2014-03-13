package oving2.RPNCalc;
import java.util.Scanner;


public class RPNCalcTest1 {
	public static void main(String[]args){
		RPNCalc calculator= new RPNCalc();
		/**
		for(int i=0; i<4;i++){
			calculator.push(i+2);
			//System.out.println("peek: "+calculator.peek(i));
		}
		System.out.println(calculator.toString());
		**/
		//System.out.println("peek: :"+calculator.peek(3));
		//System.out.println("get size: "calculator.getSize());
		//calculator.performOperation('+');
		//calculator.performOperation('-');
		//calculator.performOperation('*');
		//calculator.performOperation('/');
		//calculator.performOperation('%');
		//calculator.performOperation('p');
		//calculator.performOperation('|');
		//System.out.println(calculator.toString());
		
		System.out.println("skvive inn tall bruke <mellom rom> å skille to tall");
		Scanner inn = new Scanner(System.in);
		String sinn = inn.nextLine();
		Scanner indata=new Scanner(sinn);

		System.out.println("skvive inn operandorene, trenger ikke å skille");
		Scanner inOp = new Scanner(System.in);
		String operator = inOp.nextLine();		
		
		while(indata.hasNext()){
			calculator.push((indata.nextDouble()));
		}
		inn.close();
		indata.close();
		
		System.out.println("stack: "+'\n'+calculator.toString());
		
		for (int i=0;i<operator.length();i++){
			calculator.performOperation(operator.charAt(i));
			System.out.println("etter operator: "+operator.charAt(i));
			System.out.println(calculator.toString());
		}
		inOp.close();
	}
}
