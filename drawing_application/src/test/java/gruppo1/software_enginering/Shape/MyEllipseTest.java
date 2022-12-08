package gruppo1.software_enginering.Shape;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class MyEllipseTest {
    

    /**
     * This test checks the function: draw
     * Controls whether the element passed to the "draw" is added 
     * to the Drawing Surface element of type Pane
     */
    @Test
    void testDraw() {

        Pane drawingSurface = new Pane();
        Ellipse ellipse = new Ellipse();
        MyEllipse actual = new MyEllipse(ellipse);
        actual.draw(drawingSurface);
        boolean isDraw = drawingSurface.getChildren().contains(ellipse);

        assertEquals(true, isDraw);
    }

    @Test
    void testSetRadiusX() {

        Ellipse ellipse = new Ellipse();
        MyEllipse actual = new MyEllipse(ellipse);
        double radius = -10;
        actual.setRadiusX(radius);
        assertEquals(0, actual.getMyEllipse().getRadiusX());
        radius = 30;
        actual.setRadiusX(radius);
        assertEquals(15, actual.getMyEllipse().getRadiusX());
        radius = 1000;
        actual.setRadiusX(radius);
        assertEquals(773.0/2, actual.getMyEllipse().getRadiusX());

    }

    @Test
    void testSetRadiusY() {

        Ellipse ellipse = new Ellipse();
        MyEllipse actual = new MyEllipse(ellipse);
        double radius = -10;
        actual.setRadiusY(radius);
        assertEquals(0, actual.getMyEllipse().getRadiusY());
        radius = 30;
        actual.setRadiusY(radius);
        assertEquals(15, actual.getMyEllipse().getRadiusY());
        radius = 1000;
        actual.setRadiusY(radius);
        assertEquals(715.0/2, actual.getMyEllipse().getRadiusY());
    }


    @Test
    void testUpdateAttribute() {
        Ellipse ellipse = new Ellipse();
        MyEllipse actual = new MyEllipse(ellipse);
        double x = 5.0, y = 7.0;
        actual.updateAttribute(x, y);

        assertEquals(y/2,actual.getMyEllipse().getRadiusY());
        assertEquals(x/2,actual.getMyEllipse().getRadiusX()); 

    }

    @Test
    void testView() {

        Ellipse ellipse = new Ellipse();
        MyEllipse expect = new MyEllipse(ellipse);
        Rectangle actual = expect.view();

        assertEquals(expect.getMyEllipse().getCenterX()-expect.getMyEllipse().getRadiusX()-3, actual.getX());
        assertEquals(expect.getMyEllipse().getCenterY()-expect.getMyEllipse().getRadiusY()-3, actual.getY());
        assertEquals(expect.getMyEllipse().getRadiusX()*2+6, actual.getWidth());
        assertEquals(expect.getMyEllipse().getRadiusY()*2+6, actual.getHeight());
    }

    @Test
    void testCloneShape(){
        Ellipse ellipse = new Ellipse();
        MyEllipse expect = new MyEllipse(ellipse);
        MyEllipse actual = (MyEllipse) expect.cloneShape();

        assertEquals(expect.getMyEllipse().getCenterX(),actual.getMyEllipse().getCenterX());
        assertEquals(expect.getMyEllipse().getCenterY(),actual.getMyEllipse().getCenterY());
        assertEquals(expect.getMyEllipse().getRadiusX(),actual.getMyEllipse().getRadiusX());
        assertEquals(expect.getMyEllipse().getRadiusY(),actual.getMyEllipse().getRadiusY());
        assertEquals(expect.getMyEllipse().getStroke(),actual.getMyEllipse().getStroke());
        assertEquals(expect.getMyEllipse().getFill(),actual.getMyEllipse().getFill());
        assertEquals(expect.getMyEllipse().getStrokeWidth(),actual.getMyEllipse().getStrokeWidth());

    }
}
