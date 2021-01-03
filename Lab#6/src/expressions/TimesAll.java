package expressions;

public class TimesAll extends ExpressionCollector {
	TimesAll() {
		super();
	}

	@Override
	public Object getValue() {
		return super.getValue();
	}

	@Override
	void evaluate() {
		Integer result = 1;
		for (Expression ex : expressions) {
			ex.evaluate();
			result *= (Integer) ex.getValue();
		}
		value = result;
	}
}