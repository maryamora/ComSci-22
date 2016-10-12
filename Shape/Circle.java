package GeoObj;

/**
 * Created by Acal, Amora and Hernandez on 10/10/2016.
 */
public class Circle implements GeometricObject {

    protected double radius = 1.0;

    public Circle(double radius){
        this.radius = radius;
    }

    public double getPerimeter(){
        return 2*Math.PI*radius;
    }
    public double getArea(){
        return (radius*radius)*Math.PI;
    }

}
