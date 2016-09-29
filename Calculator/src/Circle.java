
public class Circle {
	float r, p, a;
	
	public Circle(float r) {
		this.r = r;
		this.p = calculatePerimiter(this.r);
		this.a = calculateArea(this.a);
	}
	
	private float calculatePerimiter(float r) {
		return (float) (2 * r * Math.PI);
	}
	
	private float calculateArea(float a) {
		return (float) (Math.pow(Math.PI * r, 2));
	}
	
	public void printState(){
		System.out.printf("Radius: %.2f%n", this.r);
		System.out.printf("Perimiter: %.2f%n", this.p);
		System.out.printf("Area: %.2f%n", this.a);
	}
}
