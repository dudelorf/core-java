package core.java;

/**
 *
 * @author eric
 */
abstract public class Shape {
    
    Point center;
    
    public Shape(Point center){
        this.center = center;
    }
    
    public void moveBy(double dx, double dy){
        center.translate(dx, dy);
    }
    
    abstract public Point getCenter();
}
