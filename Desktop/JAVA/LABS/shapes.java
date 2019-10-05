
interface ShapeProperties
{
	public double perimeter();

	public double area();

	public double areaToPerimeterRatio();
}

abstract class Shape implements ShapeProperties
{
	private String name;
	
	public Shape(String name){
		this.name = name;
	} 

	public abstract double perimeter();

	public abstract double area();

	public double areaToPerimeterRatio(){
		return area()/perimeter();
	}
	public void print(){
		System.out.println(name + ": "+ perimeter() +" " + area() +" "+ areaToPerimeterRatio());
	}
	
}
class RightTriangle extends Shape
{
	private double vertice1;
	private double vertice2;

	public RightTriangle(String name, double vertice1, double vertice2){
		super(name);
		this.vertice1 = vertice1;
		this.vertice2 = vertice2; 
	}

	public double perimeter(){
		return Math.sqrt(Math.pow(vertice1, 2) + Math.pow(vertice2, 2));
	}	
	public double area(){
		return (vertice1 * vertice2)/2;
	}
}

class Circle extends Shape 
{
	private double radius;

	public Circle(String name , double radius){
		super(name);
		this.radius = radius;
	}

	public double perimeter(){
		return 2* Math.PI * radius;
	}	
	public double area(){
		return Math.PI * (Math.pow(radius, 2));
	}

}

class ShapeTest
{
	public static void main(String[] args){
		ShapeProperties[] shape = new ShapeProperties[4];
		shape[0] = new RightTriangle("triangle1", 3 , 4 );
		shape[1] = new RightTriangle("triangle2", 5 , 4 );
		shape[2] = new Circle("circle1", 6);
		shape[3] = new Circle("circle2", 8);	
		double x = 0;
		Shape best=null; //for objects
		for (int i =0; i<shape.length ; i++){
			Shape myShape = (Shape) shape[i] ;
			myShape.print();
			if (myShape.areaToPerimeterRatio() > x){
				x = myShape.areaToPerimeterRatio();
				best = myShape;
			}
		
		}
		System.out.print("The biggest ratio is: "+x+" of shape: ");
		best.print();
		
	}

}
