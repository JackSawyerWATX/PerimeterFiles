import edu.duke.*;
import java.io.File;

public class PerimeterRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }
    
    public double getFileWithLargestPerimeter() {
        double LargestPerimeter = 0.0;
        File temp = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double getPerim = getPerimeter(s);
                if (getPerim > LargestPerimeter) {
                    LargestPerimeter = getPerim;
                }
        }
        return LargestPerimeter;
    }
    
        public void testFileWithLargestPerimeter() {
        double LargestPerimFile = getFileWithLargestPerimeter();
        System.out.println("File with largest perimeter is " + LargestPerimFile);
    }
    
    public double testPerimeterMultipleFiles() {
        double largestPerimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perim = getPerimeter(s);
                if (largestPerimeter > perim) {
                     largestPerimeter = perim;
                }
        }
        return largestPerimeter;
    }
    
    public double getLargestX (Shape s) {
        double largestX = 0.0;
        Point prevPt = s.getLastPoint();
            for (Point currPt: s.getPoints()) {
                if (currPt.getX() > largestX) {
                    largestX = currPt.getX();
                }
            }   
        return largestX;
    }

    public double getLargestSide (Shape s) {
        double largestSide = 0.0;
        Point prevPt = s.getLastPoint();
            for (Point currPt : s.getPoints()) {
                double lgPt = prevPt.distance(currPt);
                if(lgPt > largestSide){
                    largestSide = lgPt;
                }
            }   
        return largestSide;
    }

    public double getAverageLength (Shape s) {
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        double totalNum = 0.0;
        double average = 0.0;
            for (Point currPt:s.getPoints()) {
                double currDist = prevPt.distance(currPt);
                totalPerim = totalPerim + currDist;
                prevPt = currPt;
                average = totalPerim/totalNum;
            }
        return average;
    }
    
    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        double averageLength = getAverageLength(s);
        double longLen = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println("Perimeter is " + length);
        System.out.println("Average Length is " + averageLength);
        System.out.println("Longest side is " + longLen);
        System.out.println("Largest X point is " + largestX);
    }
    
    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}
