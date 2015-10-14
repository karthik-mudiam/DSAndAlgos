
import java.util.Stack;

/*Can be extended for other operators such as division(/)*/
public class PostfixEvaluation {
	
	public static void main(String[] args) {
		evaluate("2 3 1 * + 9 - 4 +");		
	}
	
	public static void evaluate(String expression) {
		Stack<Integer> stack = new Stack<Integer>();
		for(String s : expression.split(" ")) {	
			if(s.equals("*")) {
				Integer i1 = stack.pop();
				Integer i2 = stack.pop();				
				stack.push(i2 * i1);
			}
			else if(s.equals("+")) {
				Integer i1 = stack.pop();
				Integer i2 = stack.pop();				
				stack.push(i2 + i1);
			}
			else if(s.equals("-")) {
				Integer i1 = stack.pop();
				Integer i2 = stack.pop();				
				stack.push(i2 - i1);
			}
			else {
				Integer i = Integer.parseInt(s);
				stack.push(i);
			}
		}
		System.out.println(stack);
	}
}
