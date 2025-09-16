import java.util.Objects;

public class Point {
    private double x;
    private double y;
    
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Point(){
        this(0.0, 0.0);    
    }

    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        // check other object if null or diff class
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        // move object to poin and compare field
        Point point = (Point) o;
        return point.getX() == x && point.getY() == y;
    }   

    @Override
    public int hashCode(){
        return Objects.hash(x,y);
    }

    @Override
    public String toString(){
        return "("+ x + ", " + y + ")";
    }
}