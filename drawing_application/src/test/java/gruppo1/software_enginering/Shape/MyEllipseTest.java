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

        System.out.println("\n--------  TEST DRAW   --------\n");

        Pane drawingSurface = new Pane();
        Ellipse ellipse = new Ellipse();
        MyEllipse actual = new MyEllipse(ellipse);
        System.out.println("MyEllipse created : "+actual.getShape());

        System.out.println("--call function Draw: --");
        actual.draw(drawingSurface);
        System.out.println("Number of shapes on the drawingSurface : "+drawingSurface.getChildren().size());
        boolean isDraw = drawingSurface.getChildren().contains(ellipse);
        assertEquals(true, isDraw);
        System.out.println("The drawingSurface contains MyEllipse?: "+drawingSurface.getChildren().contains(ellipse));

    }

    @Test
    void testSetRadiusX() {

        System.out.println("\n--------  TEST SetRadiusX   --------\n");

        Ellipse ellipse = new Ellipse();
        MyEllipse actual = new MyEllipse(ellipse);
        System.out.println("MyEllipse created : "+actual.getShape());

        double radius = 30;
        System.out.println("New RadiusX: " +radius);
        actual.setRadiusX(radius);
        assertEquals(radius/2, actual.getMyEllipse().getRadiusX());
        System.out.println("MyEllipse modified : "+actual.getShape());
        System.out.println("[RadiusX expected: " +radius/2 +"]");

        System.out.println();

        radius = -10;
        System.out.println("New RadiusX: " +radius);
        actual.setRadiusX(radius);
        assertEquals(0, actual.getMyEllipse().getRadiusX());
        System.out.println("MyEllipse modified : "+actual.getShape());
        System.out.println("[RadiusX expected: " +0.0 +"]");

        System.out.println();

        radius = 1000;
        System.out.println("New RadiusX: " +radius);
        actual.setRadiusX(radius);
        assertEquals(773.0/2, actual.getMyEllipse().getRadiusX());
        System.out.println("MyEllipse modified : "+actual.getShape());
        System.out.println("[RadiusX expected: " +773.0/2 +"]");

    }

    @Test
    void testSetRadiusY() {

        System.out.println("\n--------  TEST SetRadiusY   --------\n");

        Ellipse ellipse = new Ellipse();
        MyEllipse actual = new MyEllipse(ellipse);
        System.out.println("MyEllipse created : "+actual.getShape());

        double radius = 30;
        System.out.println("New RadiusY: " +radius);
        actual.setRadiusY(radius);
        assertEquals(radius/2, actual.getMyEllipse().getRadiusY());
        System.out.println("MyEllipse modified : "+actual.getShape());
        System.out.println("[RadiusY expected: " +radius/2 +"]");

        System.out.println();

        radius = -10;
        System.out.println("New RadiusY: " +radius);
        actual.setRadiusY(radius);
        assertEquals(0.0, actual.getMyEllipse().getRadiusY());
        System.out.println("MyEllipse modified : "+actual.getShape());
        System.out.println("[RadiusY expected: " +0.0 +"]");

        System.out.println();

        radius = 1000;
        System.out.println("New RadiusY: " +radius);
        actual.setRadiusY(radius);
        assertEquals(670.0/2, actual.getMyEllipse().getRadiusY());
        System.out.println("MyEllipse modified : "+actual.getShape());
        System.out.println("[RadiusY expected: " +715.0/2 +"]");

    }


    @Test
    void testUpdateAttribute() {

        System.out.println("\n--------  TEST UpdateAttribute   --------\n");

        Ellipse ellipse = new Ellipse();
        MyEllipse actual = new MyEllipse(ellipse);
        System.out.println("MyEllipse created : "+actual.getShape());

        double x = 5.0, y = 7.0;
        System.out.println("Drag Point x : "+x + "  Drag Point y :" +y);
        actual.updateAttribute(x, y);

        assertEquals(y/2,actual.getMyEllipse().getRadiusY());
        assertEquals(x/2,actual.getMyEllipse().getRadiusX()); 
        System.out.println("Update Width and Height of MyEllipse: ");
        System.out.println("MyEllipse modified : "+actual.getShape());
        System.out.println("Expected :[RadiusX : "+x + "  RadiusY :" + y+"]");

    }

    @Test
    void testView() {

        System.out.println("\n--------  TEST View   --------\n");

        Ellipse ellipse = new Ellipse();
        MyEllipse expect = new MyEllipse(ellipse);
        System.out.println("MyEllipse created : "+expect.getShape());

        Rectangle actual = expect.view();
        System.out.println("View of MyRectangle created : "+actual);

        assertEquals(expect.getMyEllipse().getCenterX()-expect.getMyEllipse().getRadiusX()-3, actual.getX());
        assertEquals(expect.getMyEllipse().getCenterY()-expect.getMyEllipse().getRadiusY()-3, actual.getY());
        assertEquals(expect.getMyEllipse().getRadiusX()*2+6, actual.getWidth());
        assertEquals(expect.getMyEllipse().getRadiusY()*2+6, actual.getHeight());
    }

    @Test
    void testCloneShape(){

        System.out.println("\n--------  TEST CloneShape   --------\n");

        Ellipse ellipse = new Ellipse();
        MyEllipse expect = new MyEllipse(ellipse);
        System.out.println("MyEllipse created :\t\t\t"+expect.getShape());

        MyEllipse actual = (MyEllipse) expect.cloneShape();
        System.out.println("CloneShape of MyEllipse created :  "+actual.getShape());


        assertEquals(expect.getMyEllipse().getCenterX(),actual.getMyEllipse().getCenterX());
        assertEquals(expect.getMyEllipse().getCenterY(),actual.getMyEllipse().getCenterY());
        assertEquals(expect.getMyEllipse().getRadiusX(),actual.getMyEllipse().getRadiusX());
        assertEquals(expect.getMyEllipse().getRadiusY(),actual.getMyEllipse().getRadiusY());
        assertEquals(expect.getMyEllipse().getStroke(),actual.getMyEllipse().getStroke());
        assertEquals(expect.getMyEllipse().getFill(),actual.getMyEllipse().getFill());
        assertEquals(expect.getMyEllipse().getStrokeWidth(),actual.getMyEllipse().getStrokeWidth());

    }
}
