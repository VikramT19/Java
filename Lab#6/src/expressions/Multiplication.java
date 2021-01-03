package expressions;

public class Multiplication extends Expression {
	
	int l;
	int r;
	
	Multiplication(int left, int right){
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
		value = l*r;
	}
}
