package oving2.Stack;

public class StackTest1 {
	public static void main(String[] args){
		RandomStringGenerator a=new RandomStringGenerator();
		Stack stack=new Stack();
		for(int i=0; i<5;i++){
			//System.out.println(a.getRandomString());
			stack.push(a.getRandomString());
			//stack.push("abck");
			//System.out.println(stack.toString());
		}
		for(int j=0; j<5;j++){
			System.out.println("peek: "+stack.peek(j));
			System.out.println(stack.toString());
			System.out.println(stack.getSize());
			stack.pop();
			System.out.println(stack.toString());
			stack.pop();
		}
	}
}
