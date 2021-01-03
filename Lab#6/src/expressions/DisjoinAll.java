package expressions;

public class DisjoinAll extends ExpressionCollector {
	
	DisjoinAll() {
		super();
	}

	@Override
	public Object getValue() {
		return super.getValue();
	}

	@Override
	void evaluate() {
		Boolean result = false;
		for (Expression ex : expressions) {
			ex.evaluate();
			result |= (Boolean) ex.getValue();
		}
		value = result;
	}
}