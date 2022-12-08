package gruppo1.software_enginering.Shape;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class MyRectangleTest {

    /**
     * This test checks the function: draw
     * Controls whether the element passed to the "draw" is added 
     * to the Drawing Surface element of type Pane
     */
    @Test
    void testDraw(){

        System.out.println("\n--------  TEST DRAW   --------\n");

        Pane drawingSurface = new Pane();
        Rectangle rectangle = new Rectangle();
        MyRectangle actual = new MyRectangle(rectangle);

        System.out.println("MyRectangle created : "+actual.getShape());

        System.out.println("--call function Draw: --");
        actual.draw(drawingSurface);
        System.out.println("Number of shapes on the drawingSurface : "+drawingSurface.getChildren().size());

        boolean isDraw = drawingSurface.getChildren().contains(rectangle);
        assertEquals(true, isDraw);
        System.out.println("The drawingSurface contains MyRectangle?: "+drawingSurface.getChildren().contains(rectangle));

    }

    @Test
    void testSetHeight() {

        System.out.println("\n--------  TEST SetHeight   --------\n");

        Rectangle rectangle = new Rectangle();
        MyRectangle actual = new MyRectangle(rectangle);
        System.out.println("MyRectangle created : "+actual.getShape());

        double height = 30;
        System.out.println("New Height: " +height);
        actual.setHeight(height);
        assertEquals(height, actual.myRectangle.getHeight());
        System.out.println("MyRectangle modified : "+actual.getShape());
        System.out.println("[Height expected: " +30.0 +"]");

        System.out.println();

        height = -10;
        System.out.println("New Height: " +height);
        actual.setHeight(height);
        assertEquals(0, actual.myRectangle.getHeight());
<<<<<<< HEAD
        width = 30;
        actual.setHeight(width);
        assertEquals(30, actual.myRectangle.getHeight());
        width = 1000;
        actual.setHeight(width);
        assertEquals(670, actual.myRectangle.getHeight());
=======
        System.out.println("MyRectangle modified : "+actual.getShape());
        System.out.println("[Height expected: " +0.0 +"]");

        System.out.println();

        height = 1000;
        System.out.println("New Height: " +height);
        actual.setHeight(height);
        assertEquals(670, actual.myRectangle.getHeight());
        System.out.println("MyRectangle modified : "+actual.getShape());
        System.out.println("[Height expected: " +670.0 +"]");
>>>>>>> ce1efbd8e5b893edc5965fecb843a11ddb3ffdef

    }


    @Test
    void testSetWidth() {

        System.out.println("\n--------  TEST SetWidth   --------\n");

        Rectangle rectangle = new Rectangle();
        MyRectangle actual = new MyRectangle(rectangle);
        System.out.println("MyRectangle created : "+actual.getShape());

        double width = 30;
        actual.setWidth(width);
        System.out.println("New Height: " +width);
        assertEquals(width, actual.myRectangle.getWidth());
        System.out.println("MyRectangle modified : "+actual.getShape());
        System.out.println("[Height expected: " +30.0 +"]");

        System.out.println();

        width = -10;
        System.out.println("New Height: " +width);
        actual.setWidth(width);
        assertEquals(0, actual.myRectangle.getWidth());
        System.out.println("MyRectangle modified : "+actual.getShape());
        System.out.println("[Height expected: " +0.0 +"]");

        System.out.println();

        width = 1000;
        System.out.println("New Height: " +width);
        actual.setWidth(width);
        assertEquals(773, actual.myRectangle.getWidth());
        System.out.println("MyRectangle modified : "+actual.getShape());
        System.out.println("[Height expected: " +773.0 +"]");


    }

    @Test
    void testUpdateAttribute() {

        System.out.println("\n--------  TEST UpdateAttribute   --------\n");

        Rectangle rectangle = new Rectangle();
        MyRectangle actual = new MyRectangle(rectangle);
        System.out.println("MyRectangle created : "+actual.getShape());

        double x = 5.0, y = 7.0;
        System.out.println("Drag Point x : "+x + "  Drag Point y :" +y);
        actual.updateAttribute(x, y);

        assertEquals(y,actual.myRectangle.getHeight());
        assertEquals(x,actual.myRectangle.getWidth()); 
        
        System.out.println("Update Width and Height of MyRectangle: ");
        System.out.println("MyRectangle modified : "+actual.getShape());
        System.out.println("Expected :[Width : "+x + "  Height :" + y+"]");
    }

    @Test
    void testView() {

        System.out.println("\n--------  TEST View   --------\n");

        Rectangle rectangle = new Rectangle();
        MyRectangle expect = new MyRectangle(rectangle);
        System.out.println("MyRectangle created : "+expect.getShape());

        Rectangle actual = expect.view();
        System.out.println("View of MyRectangle created : "+actual);

        assertEquals(expect.myRectangle.getX()-3,actual.getX());
        assertEquals(expect.myRectangle.getY()-3,actual.getY());
        assertEquals(expect.myRectangle.getWidth()+6,actual.getWidth());
        assertEquals(expect.myRectangle.getHeight()+6,actual.getHeight());

    }

    @Test
    void testCloneShape(){

        System.out.println("\n--------  TEST CloneShape   --------\n");

        Rectangle rectangle = new Rectangle(1.0,5.3,7.9,5.6);
        MyRectangle expect = new MyRectangle(rectangle);
        System.out.println("MyRectangle created :\t\t\t"+expect.getShape());

        MyRectangle actual = expect.cloneShape();
        System.out.println("CloneShape of MyRectangle created :  "+actual.getShape());

        assertEquals(expect.myRectangle.getX(),actual.myRectangle.getX());
        assertEquals(expect.myRectangle.getY(),actual.myRectangle.getY());
        assertEquals(expect.myRectangle.getWidth(),actual.myRectangle.getWidth());
        assertEquals(expect.myRectangle.getHeight(),actual.myRectangle.getHeight());
        assertEquals(expect.myRectangle.getStroke(),actual.myRectangle.getStroke());
        assertEquals(expect.myRectangle.getFill(),actual.myRectangle.getFill());
        assertEquals(expect.myRectangle.getStrokeWidth(),actual.myRectangle.getStrokeWidth());

    }
}
