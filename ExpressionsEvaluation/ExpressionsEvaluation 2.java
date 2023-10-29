import java.util.Stack;
import java.util.ArrayDeque;
public class ExpressionsEvaluation {
	


	

	public static String toPostfix(String exp) {

		Stack<String> stack = new Stack<String>();
		ArrayDeque<String> queue = new ArrayDeque<String>();
		
		String[] expr = exp.split(" ");
		int depth = 0;
		String out = " ";
		for (int i = 0; i < expr.length; i++) {

			String c = expr[i];

			if (c.equals("*") || c.equals("/") || c.equals("+") || c.equals("-") || c.equals(" ")) {

				if (c != " ") {
					if (stack.isEmpty()) {

						if (c.equals("*")) {
							depth = 2;
							stack.push(c);

						}

						if (c.equals("/")) {
							depth = 2;
							stack.push(c);

						}
						if (c.equals("+")) {
							depth = 1;
							stack.push(c);

						}
						if (c.equals("-")) {

							depth = 1;
							stack.push(c);

						}

					} else {

						if (c.equals("*") && depth == 2) {

							stack.push("*");

						}
						if (c.equals("*") && depth == 1) {

							stack.push("*");
							depth = 2;

						}
						if (c.equals("/") && depth == 2) {

							stack.push("/");

						}
						if (c.equals("/") && depth == 1) {

							stack.push("/");
							depth = 2;

						}
						if (c.equals("+") && depth == 1) {

							stack.push("+");

						}
						if (c.equals("+") && depth == 2) {

							while (stack.peek() == "*" || stack.peek() == "/") {
								queue.add(stack.pop());

							}
							depth = 1;

							stack.push("+");

						}
						if (c.equals("-") && depth == 1) {

							stack.push("-");

						}
						if (c.equals("-") && depth == 2) {

							while (stack.peek() == "*" || stack.peek() == "/") {
								queue.add(stack.pop());

							}

							stack.push("-");
							depth = 1;

						}

					}

				}
			}

			else {
				queue.add(c);
			}

		}
		while (!stack.isEmpty()) {

			queue.add(stack.pop());
		}
		for (String i : queue) {
			out += i;
			out += ' ';
		}

		return out;

	}
	
	public static double calculatePost(String exp) {
		
		Stack<String> stack = new Stack<>();
		
		String[] expr = exp.split(" ");
		
		for ( int i = 0 ; i < expr.length ; i ++ ) {
			
			String c = expr[i];
			
			if ( c.equals(" ")) {
				continue;
			}
			
			
			if (c.equals("*") || c.equals("/") || c.equals("+") || c.equals("-")) {
				
				
				double num2 = Double.parseDouble(stack.pop());
				double num1 = Double.parseDouble(stack.pop());
				
				double res;
				
				String op = c;
				
				if (op.equals("+")) {
					res = num1 + num2;
				}else if (op.equals("*")) {
					res = num1 * num2;
				}else if (op.equals("-")) {
					res = num1 - num2;
				}else{
					res = num1 / num2;
				}
				
				stack.push(res + "");
				
			}else {
				
				stack.push(c);
			}
			
		}
		
		return Double.parseDouble(stack.pop());
		
	}
}