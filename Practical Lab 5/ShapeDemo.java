abstract class Shape
{
    abstract public double area();
}
class Circle extends Shape
{
    int r;
    Circle(int r)
    {
        this.r = r;
    }
    public double area()
    {
        return 3.14*r*r;
    }
}
class Rectangle extends Shape
{
    int l;
    int b;
    Rectangle(int l,int b)
    {
        this.l = l;
        this.b = b;
    }
    public double area()
    {
        return l*b;
    }
}
class Triangle extends Shape
{
    int h;
    int b;
    Triangle(int h,int b)
    {
        this.h=h;
        this.b=b;
    }
    public double area()
    {
        return 0.5*b*h;
    }
}
public class ShapeDemo
{
    public static void main(String[] args)
    {
        Shape[] shapes= {
        new Circle(10),
        new Rectangle(2, 2),
        new Triangle(10, 5)
    };
    double total =0;
    double largest =-1;
    String lable ="";
    for(Shape s:shapes)
    {
        System.out.println(s.area());
        total += s.area();
        if(largest<s.area())
        {
            largest=s.area();
            lable=s.getClass().getSimpleName();
        }
    }
    System.out.println("The total area is:"+ total);
     System.out.println("The largest area is:"+ largest + " of shape "+lable);
    }
    
}
