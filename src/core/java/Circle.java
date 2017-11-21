package core.java;

/**
 *
 * @author eric
 */
public class Circle extends Shape{
    
    private double radius;
    
    public Circle(Point center, double radius){
        super(center);
        this.radius = radius;
    }
    
    @Override
    public Point getCenter(){
        return this.center;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Point newCenter = new Point(center.getX(), center.getY());
        return new Circle(newCenter, radius);
    }
}
