

public class Square extends Rectangle {

	public Square(double length) {
	super(length , length);
	}
	public double area() {
		return width*width;
	}
	public double perimeter() {
		return 4*width;
		
	}
	
	
	public void setWidth(double w) {
		if(w>0){width=w;height=w;}
		else {width=1;height=1;}
	}
	
	public void setHeight(double h) {
		if(h>0) {height=h;width=h;}
		else {height=1;width=1;}
	}
	
	
	public String toString() {
		return"Square: length = "+width;
	}

}
