package gruppo1.software_enginering.Shape;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class MyLineTest {

    /**
     * This test checks the function: draw
     * Controls whether the element passed to the "draw" is added 
     * to the Drawing Surface element of type Pane
     */

    @Test
    void testDraw(){
        Pane drawingSurface = new Pane();
        Line line = new Line();
        MyLine actual = new MyLine(line);
        actual.draw(drawingSurface);
        boolean isDraw = drawingSurface.getChildren().contains(line);

        assertEquals(true, isDraw);

    }

    
    @Test
    void testSetEndY() {
        Line line = new Line();
        MyLine actual = new MyLine(line);
        double y = -10;
        actual.setEndY(y);
        assertEquals(0, actual.getMyLine().getEndY());
        y = 30;
        actual.setEndY(y);
        assertEquals(30, actual.getMyLine().getEndY());
        y = 1000;
        actual.setEndY(y);
        assertEquals(670, actual.getMyLine().getEndY());

    }

    @Test
    void testSetEndX() {
        Line line = new Line();
        MyLine actual = new MyLine(line);
        double x = -10;
        actual.setEndX(x);
        assertEquals(0, actual.getMyLine().getEndX());
        x = 30;
        actual.setEndX(x);
        assertEquals(30, actual.getMyLine().getEndX());
        x = 1000;
        actual.setEndX(x);
        assertEquals(773, actual.getMyLine().getEndX());

    }


    @Test
    void testUpdateAttribute() {
        Line line = new Line();
        MyLine actual = new MyLine(line);
        double x = 5.0, y = 7.0;
        actual.updateAttribute(x, y);

        assertEquals(x,actual.getMyLine().getEndX());
        assertEquals(y,actual.getMyLine().getEndY()); 
        
    }

    @Test
    void testView() {

        Line line = new Line();
        MyLine expect = new MyLine(line);
        Rectangle actual = expect.view();
        
        assertEquals(Math.min(expect.getMyLine().getStartX(), expect.getMyLine().getEndX())-3, actual.getX());
        assertEquals(Math.min(expect.getMyLine().getStartY(), expect.getMyLine().getEndY())-3, actual.getY());
        assertEquals(Math.abs(expect.getMyLine().getStartX()-expect.getMyLine().getEndX())+6, actual.getWidth());
        assertEquals(Math.abs(expect.getMyLine().getStartY()-expect.getMyLine().getEndY())+6, actual.getHeight());

    }

    @Test
    void testCloneShape(){
        Line line = new Line();
        MyLine expect = new MyLine(line);
        MyLine actual = expect.cloneShape();

        assertEquals(expect.getMyLine().getStartX(),actual.getMyLine().getStartX());
        assertEquals(expect.getMyLine().getStartY(),actual.getMyLine().getStartY());
        assertEquals(expect.getMyLine().getEndX(),actual.getMyLine().getEndX());
        assertEquals(expect.getMyLine().getEndY(),actual.getMyLine().getEndY());
        assertEquals(expect.getMyLine().getStroke(),actual.getMyLine().getStroke());
        assertEquals(expect.getMyLine().getStrokeWidth(),actual.getMyLine().getStrokeWidth());

    }
}
