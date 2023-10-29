

public class Circle extends Shape {

	protected double radius;
	
	
	public Circle(double r) {
		if (r > 0) {
			radius = r;
		}
		else {
			radius = 1;
		}
		
		
	}


	public double getRadius() {
		return radius;
	}


	public void setRadius(double r) {
		if (r > 0) {
			this.radius = radius;
		}
		else {
			this.radius = 1;
		}
		
	}
	
	public double area() {
		return radius*radius*3.14;
	}
	public double perimeter() {
		return 2*radius*3.14;
		
	}
	
	
	public String toString() {
	return "Circle: radius ="+this.radius;
	}
	
	
	
	
	
	
	
}
