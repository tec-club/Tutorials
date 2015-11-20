/**
 * Created by ryan on 10/29/15.
 */

//Abstract classes are classes that have methods that are to be overridden in subclasses
public abstract class Shape {
    String name;
    int numSides;
        public Shape(String shapeName, int shapeSides) {
            name=shapeName;
            shapeSides=numSides;

        }

    //To be overridden in a subclass
    public abstract double getArea();

    public int getNumSides() {
        return numSides;
    }



    public String getName() {
        return name;
    }

}
