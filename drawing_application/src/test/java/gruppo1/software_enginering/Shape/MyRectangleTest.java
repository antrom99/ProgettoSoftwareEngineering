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
        Pane drawingSurface = new Pane();
        Rectangle rectangle = new Rectangle();
        MyRectangle actual = new MyRectangle(rectangle);
        actual.draw(drawingSurface);
        boolean isDraw = drawingSurface.getChildren().contains(rectangle);

        assertEquals(true, isDraw);

    }

    @Test
    void testSetHeight() {
        Rectangle rectangle = new Rectangle();
        MyRectangle actual = new MyRectangle(rectangle);
        double width = -10;
        actual.setHeight(width);
        assertEquals(0, actual.myRectangle.getHeight());
        width = 30;
        actual.setHeight(width);
        assertEquals(30, actual.myRectangle.getHeight());
        width = 1000;
        actual.setHeight(width);
        assertEquals(670, actual.myRectangle.getHeight());

    }


    @Test
    void testSetWidth() {
        Rectangle rectangle = new Rectangle();
        MyRectangle actual = new MyRectangle(rectangle);
        double width = -10;
        actual.setWidth(width);
        assertEquals(0, actual.myRectangle.getWidth());
        width = 30;
        actual.setWidth(width);
        assertEquals(30, actual.myRectangle.getWidth());
        width = 1000;
        actual.setWidth(width);
        assertEquals(773, actual.myRectangle.getWidth());


    }

    @Test
    void testUpdateAttribute() {
        Rectangle rectangle = new Rectangle();
        MyRectangle actual = new MyRectangle(rectangle);
        double x = 5.0, y = 7.0;
        actual.updateAttribute(x, y);

        assertEquals(y,actual.myRectangle.getHeight());
        assertEquals(x,actual.myRectangle.getWidth()); 
        
    }

    @Test
    void testView() {

        Rectangle rectangle = new Rectangle();
        MyRectangle expect = new MyRectangle(rectangle);
        Rectangle actual = expect.view();

        assertEquals(expect.myRectangle.getX()-3,actual.getX());
        assertEquals(expect.myRectangle.getY()-3,actual.getY());
        assertEquals(expect.myRectangle.getWidth()+6,actual.getWidth());
        assertEquals(expect.myRectangle.getHeight()+6,actual.getHeight());

    }

    @Test
    void testCloneShape(){
        Rectangle rectangle = new Rectangle();
        MyRectangle expect = new MyRectangle(rectangle);
        MyRectangle actual = expect.cloneShape();

        assertEquals(expect.myRectangle.getX(),actual.myRectangle.getX());
        assertEquals(expect.myRectangle.getY(),actual.myRectangle.getY());
        assertEquals(expect.myRectangle.getWidth(),actual.myRectangle.getWidth());
        assertEquals(expect.myRectangle.getHeight(),actual.myRectangle.getHeight());
        assertEquals(expect.myRectangle.getStroke(),actual.myRectangle.getStroke());
        assertEquals(expect.myRectangle.getFill(),actual.myRectangle.getFill());
        assertEquals(expect.myRectangle.getStrokeWidth(),actual.myRectangle.getStrokeWidth());

    }
}
