
import java.util.Stack;

/* Points to remember:
 * 1. The operands appear in the same order.
 * 2. The higher precedence operator is always on the top of the stack.
 * 3. Precedence from left to right when operators are of same hierarchy
*/
public class InfixToPostfix {
	
	public static void main(String[] args) {
		String expression = "A-B*C+D*E";
		infixToPostFix(expression);
	}

	public static void infixToPostFix(String expression) {
		StringBuilder postfix = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<expression.length(); i++) {
			Character c = expression.charAt(i);			
			if(!c.toString().equals("*") && !c.toString().equals("+") && !c.toString().equals("-")) {
				postfix.append(c);
			} else {
				while(!stack.isEmpty() && higherPrecedence(stack.peek(), c)){
					postfix.append(stack.pop());
				}
				stack.push(c);
			}			
		}
		while(!stack.isEmpty()) {
			postfix.append(stack.pop());
		}
		System.out.println(postfix);
	}
	
	private static boolean higherPrecedence(Character stackChar, Character expChar) {
		int stackCharPriority = getPriority(stackChar);
		int expCharPriority = getPriority(expChar);
		if(stackCharPriority >= expCharPriority) {
			return true;
		}
		return false;
	}
	
	private static int getPriority(Character operator) {
		if(operator.toString().equals("*")) {
			return 3;
		}
		if(operator.toString().equals("+")) {
			return 2;
		}
		if(operator.toString().equals("-")) {
			return 2;
		}
		return -1;
	}
}
