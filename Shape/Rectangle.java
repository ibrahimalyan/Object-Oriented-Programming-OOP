

public class Rectangle extends Shape {

	protected double width;
	protected double height;
	
	
	public Rectangle(double w, double h) {
		if (w >0 ) {
			width =w;
			
		}
		else {
			width =1;
			
			
		}
		if (h >0 ) {
			
			height =h;
		}
		else {
			
			height =1;
			
		}
		
	}

	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}

	public void setWidth(double w) {
		if (w >0) {
		this.width = w;}
		else {
			this.width =1;}
	}

	

	public void setHeight(double  h) {
		if ( h >0) {
			this. height = h;}
			else {
				this.height =1;
				
			}
	}
	public double area() {
		return width*height;
	}
	public double perimeter() {
		return 2*(width+height);
		
	}
	
	
	public String toString() {
		return"Rectangle: width ="+this.width+", height ="+this.height;
	}
	
	
	
	
	
	
	
	
	
	
	

}
