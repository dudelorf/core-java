package core.java;

/**
 *
 * @author eric
 */
public class Rectangle extends Shape{
    
    double width;
    double height;
    Point topLeft;
    
    public Rectangle(Point topLeft, double width, double height){
        super(new Point((topLeft.getX() + width) / 2, (topLeft.getY() + height) / 2));
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }
    
    public Point getCenter(){
        return center;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Point newTopLeft = new Point(topLeft.getX(), topLeft.getY());
        return new Rectangle(newTopLeft, this.width, this.height);
    }
    
    
}
