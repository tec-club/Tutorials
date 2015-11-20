/**
 * Created by ryan on 10/29/15.
 */
public class Rectangle extends Shape {

    double width, height;

    public Rectangle(double rectWidth, double rectHeight) {
        super("Rectangle", 2);

        width = rectWidth;
        height = rectHeight;
    }

    @Override
    public double getArea() {
    return width*height;
}
}