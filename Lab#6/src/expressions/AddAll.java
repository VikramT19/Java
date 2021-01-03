package expressions;

public class AddAll extends ExpressionCollector {

	AddAll(){
		super();
	}
	
	@Override
	Object getValue() {
		return super.getValue();
	}
	
	@Override
	void evaluate() {
		Integer result = 0;
		for (Expression ex : expressions) {
			ex.evaluate();
			result += (Integer) ex.getValue();
		}
		value = result;
	}	
}