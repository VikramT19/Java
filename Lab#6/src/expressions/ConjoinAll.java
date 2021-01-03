package expressions;

public class ConjoinAll extends ExpressionCollector {

	ConjoinAll() {
		super();
	}

	@Override
	public Object getValue() {
		return super.getValue();
	}

	@Override
	void evaluate() {
		Boolean result = true;
		for (Expression ex : expressions) {
			ex.evaluate();
			result &= (Boolean) ex.getValue();
		}
		value = result;
	}
}