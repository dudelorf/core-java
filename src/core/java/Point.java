package core.java;

/**
 *
 * @author eric
 */
public class Point {
    
    protected double x;
    protected double y;
    
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public Point translate(double x, double y){
        this.x += x;
        this.y += y;
        
        return this;
    }
    
    public Point scale(double factor){
        this.x *= factor;
        this.y *= factor;
        
        return this;
    }
    
    @Override
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}
