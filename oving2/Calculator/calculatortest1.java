package oving2.Calculator;
import java.util.Scanner;
public class calculatortest1 {
	public static void main(String[] args){
		Calculator regne = new Calculator();
		System.out.println("skvive inn!");
		Scanner indata = new Scanner(System.in);
		String in = indata.next();
		indata.close();
		String stall="";
		double [] tall=new double[99];
		char [] operator=new char [98];
		int a=0;
		int b=0;
		for (int i=0; i<in.length(); i++){
			if (!sjekk(in.charAt(i)))
				stall+=in.charAt(i);
			else{
				if(sjekk(in.charAt(i))){
					tall[a]=Double.parseDouble(stall);
					a+=1;
					operator[b]=in.charAt(i);
					b+=1;
				}
				stall="";
			}
		}
			int j=0;
			for (int mer=0; mer<in.length();mer++){
				if(sjekk(operator[j]));
				j+=1;
			}
			double result=0;
			char [] restOperator = new char [j];
			for (int l=0; l<j; l++)
				restOperator[l]=operator[l];
			double [] restTall=new double[j+1];
			for (int v=0;v<j+1;v++)
				restTall[v]=tall[v];
			int restTabelLengde=j;
			for (int m=0; m<j;m++){
				//operator order
				for (int n=0; n<restTabelLengde;n++){
					if (!firstOperater(restOperator[n])){
						regne.setFirstOperand(restTall[n]);
						regne.setSecondOperand(restTall[n+1]);
						regne.setOperator(restOperator[n]);
						result=regne.calculateResult();
						restOperator=nyOpTabel(restOperator,n);
						restTall=nyTallTabel(restTall,n,result);
						System.out.println(regne.toString());
						restTabelLengde--;
						continue;
					}
				}
			}
			
			for (int regnRest=0;regnRest<(restOperator.length)-1;regnRest++){
				regne.setFirstOperand(restTall[0]);
				regne.setSecondOperand(restTall[1]);
				regne.setOperator(restOperator[0]);
				result=regne.calculateResult();
				restOperator=nyOpTabel(restOperator,0);
				restTall=nyTallTabel(restTall,0,result);
				System.out.println(regne.toString());
			}
			regne.setFirstOperand(restTall[0]);
			regne.setSecondOperand(restTall[1]);
			regne.setOperator(restOperator[0]);
			result=regne.calculateResult();
			
			System.out.println(result);
		}
		
		

	public static boolean sjekk(char operator){
		if (operator=='+'|| operator=='-'|| operator=='/'||
				operator=='*'|| operator=='%')
			return true;
		return false;
	}
	public static boolean firstOperater(char operator){
		if (operator!='+' || operator!='-')
			return false;
		return true;
	}
	public static char [] nyOpTabel(char [] t, int nr){
		int l=t.length;
		char [] tabel=new char[l-1];
		for (int i=0; i<nr; i++){
			tabel[i]=t[i];
		}
		for (int j=nr;j<l-1;j++){
			tabel[j]=t[nr+1];
		}
		return tabel;
	}
	public static double [] nyTallTabel(double [] t, int nr, double r){
		int l=t.length;
		double [] tabel=new double[l-1];
		for (int i=0; i<nr; i++){
			tabel[i]=t[i];
		}
		for (int j=nr+1;j<l-1;j++){
			tabel[j]=t[j+1];
		}
		tabel[nr]=r;
		return tabel;
	}
}
