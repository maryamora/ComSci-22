package GeoObj;

/**
 * Created by Acal, Amora and Hernandez on 10/10/2016.
 */
public class TestResizable{
    public static void main(String[] arg){
        Circle circs = new ResizableCircle(100);
        System.out.println(((ResizableCircle)circs).resize(-5));
        System.out.println(((ResizableCircle)circs).resize(5));

    }
}
