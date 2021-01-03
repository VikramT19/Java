package expressions;

public class Subtraction extends Expression {
	
	int l;
	int r;
	
	Subtraction(int left, int right){
		super(left,right);
		l = left;
		r = right;
	}
	
	@Override
	Object getValue() {
		return super.getValue();
	}
	
	@Override
	void evaluate() {
		value = l - r;
	}
}