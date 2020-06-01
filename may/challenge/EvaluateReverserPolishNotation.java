package practiceJava.leetcode.may.challenge;

/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.

 */
public class EvaluateReverserPolishNotation {

	public static void main(String[] args) {
		EvaluateReverserPolishNotation e = new EvaluateReverserPolishNotation();
		String[] tokens = new String[] {"2", "1", "+", "3", "*"}; 
		long start, end;
		
		start = System.nanoTime();
		System.out.println(e.evalRPN(tokens)); 
		end = System.nanoTime();
		System.out.println(" time taken for evalRPN " + (end-start) );
		

		start = System.nanoTime();
		System.out.println(e.evalRPN1(tokens)); 
		end = System.nanoTime();
		System.out.println(" time taken for evalRPN1 " + (end-start) );

	}
	
	//its based on assumption that the expression would always be valid, so no pre check done
	public int evalRPN(String[] tokens) {
		 int[] results = new int[tokens.length/2+1];   // there will be half -1 amount of operators as operators are binary 
		 											//so min two operatnds are required for operation, there could be a possibility that all the operands are together, so we would need half+1 space
		    int index = 0;
		    for (String token : tokens) {
		        switch (token) {  					// calculate the result of last two tokens in 2nd last array space
		            case "+":						// otherwise, add the next integer in array space
		                results[index - 2] = results[index - 2] + results[index - 1];   
		                index--;
		                break;
		            case "-":
		                results[index - 2] = results[index - 2] - results[index - 1];
		                index--;
		                break;
		            case "*":
		                results[index - 2] = results[index - 2] * results[index - 1];
		                index--;
		                break;
		            case "/":
		                results[index - 2] = results[index - 2] / results[index - 1];
		                index--;
		                break;
		            default:
		                results[index++] = Integer.parseInt(token);
		                break;
		        }
		    }
		    return results[0];    // finally all the results would be calcualtated back in the first space
		}

	public int evaluate(String[] tokens, int []p) {
        String c = tokens[p[0]];
        if ("+-*/".contains(c)) {
            p[0] = p[0]-1;
            int a = evaluate(tokens, p);
            p[0] = p[0]-1;
            int b = evaluate(tokens, p);
            
            switch(c) {
                case "+": return b+a;
                case "-": return b-a;
                case "*": return b*a;
                case "/": return b/a;
                default: break;
            }
        }
        return Integer.valueOf(c);
    }
    
    public int evalRPN1(String[] tokens) {
        int n = tokens.length;
        int p[] = {n-1};
        return evaluate(tokens, p);
    }
}
