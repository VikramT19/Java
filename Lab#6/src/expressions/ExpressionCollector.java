package expressions;

import java.util.ArrayList;
import java.util.List;

public class ExpressionCollector {
	 
	protected List<Expression> expressions;
	protected Object value;
	 
	ExpressionCollector() {
		expressions = new ArrayList<>();
	}
	
	/**
	 * Add a new expression (to the end of the collection)
	 * @param e an expression
	 */
	void addExpression(Expression e) {
		expressions.add(e);
	}
	
	/**
	 * Add a new expression (to the end of the collection)
	 * @param left integer value of the left operand 
	 * @param op operator (i.e., "+", "-", "*", ">", "<", "==")
	 * @param right integer value of the right operand
	 */
	void addExpression(int left, String op, int right) {
		
		if(op.equals("+")) {
			expressions.add(new Addition(left, right));
		}
		
		else if(op.equals("-")) {
			expressions.add(new Subtraction(left, right));
		}
		
		else if(op.equals("*")) {
		    expressions.add(new Multiplication(left, right));
	      
		}
		
		else if(op.equals(">")) {
			 expressions.add(new GreaterThan(left, right));
		}
		
		else if(op.equals("<")) {
			 expressions.add(new LessThan(left, right));
		}
		
		else if(op.equals("==")) {
			 expressions.add(new Equal(left, right));
		}	 
	}
	
	/**
	 * sub-routine that can be used to check if this is type correct
	 * true if e is one of the three classes, or their subclasses (if any)
	 * so use instanceof, instead of getClassName()
	 */
	private boolean isArithmetic(Expression e) {
		return 
				e instanceof Addition 
			||	e instanceof Subtraction
			|| 	e instanceof Multiplication;
	}
	
	/**
	 * sub-routine that can be used to check if this is type correct
	 * true if e is one of the three classes, or their subclasses (if any)
	 */
	private boolean isRelation(Expression e) {
		return 
				e instanceof Equal 
			||	e instanceof GreaterThan
			|| 	e instanceof LessThan;
	}
	
	/**
	 * If this collector is AddAll or TimesAll, then all stored expressions must be integer expressions
	 * (i.e., Addition, Subtraction, Multiplication).
	 * If this collection is ConjoinAll or DisjoinAll, then all stored expressions must be boolean expressions
	 * (i.e., GreaterThan, LessThan, Equal)
	 * @return whether it is possible to evaluate the stored collection of expressions.   
	 */
	boolean isTypeCorrect() {		
		boolean b = true;
		if(this instanceof AddAll || this instanceof TimesAll) {
			for(int i = 0; i < expressions.size(); i++) {
				b = b && this.isArithmetic(expressions.get(i));
	        }
		}
		else if(this instanceof ConjoinAll || this instanceof DisjoinAll){
			for(int i = 0; i < expressions.size(); i++) {
				b = b && this.isRelation(expressions.get(i));
			}
		}
	    else {
	    	b = false;
	    }
	    return b;
	}
	
	/**
	 * Get the result of the latest evaluation (i.e., after the latest call to `evaluate()`).
	 * @return the last evaluation result.
	 */
	Object getValue() {
		return value;
	}
	
	/**
	 * Obtain the list of stored expressions, as an array.
	 * @return all stored expressions as an array
	 */
	Expression[] getExpressions() {
		Expression[] ex = new Expression[expressions.size()];
	    for(int i = 0; i < expressions.size(); i++) {
	    	ex[i] = expressions.get(i);
	    }
	    return ex;
	}
	
	/**
	 * Given that this expression collector is type correct (see `isTypeCorrect()`),
	 * evaluate it. Store the evaluation result so that it can be returned by `getValue()`. 
	 */
	void evaluate() {
		// COMPLETE THIS
		// Hint: Leave this method as is, and override it in all subclasses such as Addition, GreaterThan.
		System.out.println("I am printing some aribritary words here, should not be on screen");
	}
	
	/**
	 * Override the equals method. Two expression collectors are equals if:
	 * 1) They are both type correct 2) Their evaluation results are identical
	 * @return whether or not the two expression collectors are equal.
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		ExpressionCollector other = (ExpressionCollector) obj;
		if(this.isTypeCorrect() && other.isTypeCorrect()) {
			this.evaluate();
	        other.evaluate();
	        if(this.getValue().equals(other.getValue())) {
	        	return true;
	        }
	        else {
	        	return false;
	        }
		}
	    else {
	    	return false;
		}		 
	}	
}