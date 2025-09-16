
public class Polygon {

    final public static int MAX_SIDES = 12;
    private int numSides;
    private Point[] points = new Point[MAX_SIDES];

    public void addPoint(Point point){
        
            if (numSides >= MAX_SIDES){
                throw new RuntimeException("Polygon is full");
            }
        //check for dup
        int i = 0;
        while (i < numSides) {
            if (points[i].equals(point)) {
                throw new IllegalArgumentException("Duplicate point:" + point);
            }
            // if pass condition above increase side
            i++;
        }
        points[numSides] = point;
        numSides++;
    }

    private static double lineLength(Point p1, Point p2){
        // difference
        double x = p2.getX() - p1.getX();
        double y = p2.getY() - p1.getY();
        
        return Math.sqrt(x*x + y*y);

    }

    public double perimeter(){
        if (numSides < 3){
            throw new RuntimeException("Polygons required 3+ sides!");
        }
        double total = 0;
        for (int i = 0; i < numSides - 1; i++){
            total+= lineLength(points[i], points[i+1]); //first to second las
        }
            total+= lineLength(points[numSides - 1], points[0]); //last back to first
        return total;
    }
    
    @Override
    public String toString(){
        String s = "Polygon[";
        int i = 0;
        while (i < numSides){
            s += points[i].toString();
            if (i < numSides - 1){
                s += ",";
            }
            i++;
        }
        s += "]";
        return s;
    }
}