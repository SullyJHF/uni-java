public class Calculator {
	int a, b, c;
	
	// Constructors
	public Calculator(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public Calculator(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	// Calculator methods
	public int sum() {
		return this.a + this.b;
	}
	
	public int difference() {
		return this.a - this.b;
	}

	public int product() {
		return this.a * this.b;
	}
	
	public float quotient() {
		return (float)this.a / (float)this.b;
	}
	
	public int modulus() {
		return this.a % this.b;
	}
	
	public double[] quadratic() {
		double d = this.b * this.b - 4 * this.a * this.c;
		if (d < 0){
		   // System.out.println("Discriminant < 0, no real solutions" );
		   return null;
		}

		double x1 = (-this.b - Math.sqrt(d)) / (2 * this.a);
		double x2 = (-this.b + Math.sqrt(d)) / (2 * this.a);
		double[] x = {x1, x2};

		return x;
	}
}
