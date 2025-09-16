import java.util.Scanner;
public class TestPolygon {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        

        int TestFail = 0;
        // Test vector #1: Create a 3-sided polygon Polygon[(0,0),(3,0),(3,4)]
        Polygon polygon1 = new Polygon();
        Point p1 = new Point();
        Point p2 = new Point(3, 0);
        Point p3 = new Point(3, 4);
        
        polygon1.addPoint(p1);
        polygon1.addPoint(p2);
        polygon1.addPoint(p3);

        System.out.println(polygon1);
        
        double perimeter_p1 = polygon1.perimeter();

        if (Math.abs(perimeter_p1 - 12.0) > 0.001) {
            System.err.println("FAIL: Exception from valid polygon");
            TestFail++;
        } 
        else {
            System.out.println("PASS: Perimeter is 12.");
        }

        // Test vector #2: Try to create a 3-sided polygon Polygon[(0,0),(3,0),(0,0)]
        Polygon polygon2 = new Polygon();
        p1 = new Point();
        p2 = new Point(3, 0);
        p3 = new Point();
        try{
            polygon2.addPoint(p1);
            polygon2.addPoint(p2);
            polygon2.addPoint(p3);
            System.err.println("FAIL: Duplicate point should throw IllegalArgumentException");
            TestFail++;
        }
        catch (IllegalArgumentException i){
            System.out.println("PASS: Successfully caught IllegalArgumentException");
        }
        catch (Exception e){
            System.err.println("FAIL: Successfully caught unexpected Exception");
            TestFail++;
        }

        // Test vector #3: Create (invalid) 2-sided polygon Polygon[(0,0),(3,0)].
        Polygon polygon3 = new Polygon();
        p1 = new Point();
        p2 = new Point(3, 0);
        polygon3.addPoint(p1);
        polygon3.addPoint(p2);
        try{
            double perimeter = polygon3.perimeter();
            System.err.println("FAIL: Too many points should throw RuntimeException");
            TestFail++;
        }
        catch (RuntimeException r){
            System.out.println("PASS: Successfully caught RuntimeException");

        }
        catch (Exception e){
            System.err.println("FAIL: Successfully caught unexpected Exception");
            TestFail++;
        }
        // Test vector #4: Attempt to create a 13-sided Polygon
        Polygon polygon4 = new Polygon();
        try{
            int i = 1;
            while (i <= 13){
                polygon4.addPoint(new Point(i+2,i+1));
                i++;
            }
            System.err.println("FAIL: Lot of points should throw RuntimeException");
            TestFail++;
        }
        catch (RuntimeException r){
            System.out.println("PASS: Successfully caught RuntimeException");

        }
        catch (Exception e){
            System.err.println("FAIL: Successfully caught unexpected Exception");
            TestFail++;
        }

        if (TestFail > 0){
            System.err.println("FAIL: Result code " + TestFail);
            System.exit(1);
        }
        else {
            System.out.println("PASS:  All PASSED");
            System.exit(0);

        }
        
    }
}