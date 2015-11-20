/**
 * Created by ryan on 10/29/15.
 */
import java.lang.Math;
public class Circle extends Shape {
    double radius;
    public Circle(double circleRadius) {
        super("Circle", 0); //Circles don't have sides
        radius=circleRadius;

    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius; //formula for circle area
    }

    public double getCircumference() {

        return 2*Math.PI*radius;

    }
}
