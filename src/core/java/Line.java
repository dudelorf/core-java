package core.java;

/**
 *
 * @author eric
 */
public class Line extends Shape{
    
    Point from;
    Point to;
    
    public Line(Point from, Point to){
        super(new Point(
            from.getX() + ( ( to.getX() - from.getX() ) / 2 ),
            from.getY() + ( ( to.getY() - from.getY() ) / 2 ) 
        ));
        this.from = from;
        this.to = to;
    }
    
    public Point getCenter(){
        return center;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Point newFrom = new Point(from.getX(), from.getY());
        Point newTo = new Point(to.getX(), to.getY());
        return new Line(newFrom, newTo);
    }
}
