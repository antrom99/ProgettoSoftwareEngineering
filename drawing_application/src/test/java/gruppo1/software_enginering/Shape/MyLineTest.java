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

        System.out.println("\n--------  TEST DRAW   --------\n");

        Pane drawingSurface = new Pane();
        Line line = new Line();
        MyLine actual = new MyLine(line);

        System.out.println("MyLine created : "+actual.getShape());

        System.out.println("--call function Draw: --");
        actual.draw(drawingSurface);
        System.out.println("Number of shapes on the drawingSurface : "+drawingSurface.getChildren().size());

        boolean isDraw = drawingSurface.getChildren().contains(line);
        assertEquals(true, isDraw);
        System.out.println("The drawingSurface contains MyRectangle?: "+drawingSurface.getChildren().contains(line));

    }

    
    @Test
    void testSetEndY() {

        System.out.println("\n--------  TEST SetEndY   --------\n");

        Line line = new Line();
        MyLine actual = new MyLine(line);
        System.out.println("MyLine created : "+actual.getShape());

        double y = 30;
        System.out.println("New EndY : " +y);        
        actual.setEndY(y);
        assertEquals(y, actual.getMyLine().getEndY());
        System.out.println("MyLine modified : "+actual.getShape());
        System.out.println("[EndY  expected: " +y +"]");

        System.out.println();

        y = -10;
        System.out.println("New EndY : " +y);
        actual.setEndY(y);
        assertEquals(0.0, actual.getMyLine().getEndY());
        System.out.println("MyLine modified : "+actual.getShape());
        System.out.println("[EndY  expected: " +0.0 +"]");

        System.out.println();

        y = 1000;
        System.out.println("New EndY : " +y);
        actual.setEndY(y);
        assertEquals(670, actual.getMyLine().getEndY());
<<<<<<< HEAD
=======
        System.out.println("MyLine modified : "+actual.getShape());
        System.out.println("[EndY  expected: " +670.0 +"]");

>>>>>>> ce1efbd8e5b893edc5965fecb843a11ddb3ffdef

    }

    @Test
    void testSetEndX() {

        System.out.println("\n--------  TEST SetEndX   --------\n");

        Line line = new Line();
        MyLine actual = new MyLine(line);
        System.out.println("MyLine created : "+actual.getShape());

        double x = 30;
        System.out.println("New EndX : " +x);      
        actual.setEndX(x);
        assertEquals(x, actual.getMyLine().getEndX());
        System.out.println("MyLine modified : "+actual.getShape());
        System.out.println("[EndX  expected: " +x +"]");

        System.out.println();

        x = -10;
        System.out.println("New EndX : " +x);
        actual.setEndX(x);
        assertEquals(0.0, actual.getMyLine().getEndX());
        System.out.println("MyLine modified : "+actual.getShape());
        System.out.println("[EndX  expected: " +0.0 +"]");

        System.out.println();

        x = 1000;
        System.out.println("New EndX : " +x);
        actual.setEndX(x);
        assertEquals(773, actual.getMyLine().getEndX());
        System.out.println("MyLine modified : "+actual.getShape());
        System.out.println("[EndX  expected: " +773.0 +"]");

    }


    @Test
    void testUpdateAttribute() {

        System.out.println("\n--------  TEST UpdateAttribute   --------\n");

        Line line = new Line();
        MyLine actual = new MyLine(line);
        System.out.println("MyLine created : "+actual.getShape());

        double x = 5.0, y = 7.0;
        System.out.println("Drag Point x : "+x + "  Drag Point y :" +y);
        actual.updateAttribute(x, y);

        assertEquals(x,actual.getMyLine().getEndX());
        assertEquals(y,actual.getMyLine().getEndY()); 
        System.out.println("Update EndX and EndY of MyLine: ");
        System.out.println("MyLine modified : "+actual.getShape());
        System.out.println("Expected :[EndX : "+x + "  EndY :" + y+"]");
    
        
    }

    @Test
    void testView() {

        System.out.println("\n--------  TEST View   --------\n");
        
        Line line = new Line();
        MyLine expect = new MyLine(line);
        System.out.println("MyLine created : "+expect.getShape());

        Rectangle actual = expect.view();
        System.out.println("View of MyRectangle created : "+actual);
        
        assertEquals(Math.min(expect.getMyLine().getStartX(), expect.getMyLine().getEndX())-3, actual.getX());
        assertEquals(Math.min(expect.getMyLine().getStartY(), expect.getMyLine().getEndY())-3, actual.getY());
        assertEquals(Math.abs(expect.getMyLine().getStartX()-expect.getMyLine().getEndX())+6, actual.getWidth());
        assertEquals(Math.abs(expect.getMyLine().getStartY()-expect.getMyLine().getEndY())+6, actual.getHeight());

    }

    @Test
    void testCloneShape(){

        System.out.println("\n--------  TEST CloneShape   --------\n");

        Line line = new Line();
        MyLine expect = new MyLine(line);
        System.out.println("MyLine created :\t\t"+expect.getShape());

        MyLine actual = expect.cloneShape();
        System.out.println("CloneShape of MyLine created :  "+actual.getShape());

        assertEquals(expect.getMyLine().getStartX(),actual.getMyLine().getStartX());
        assertEquals(expect.getMyLine().getStartY(),actual.getMyLine().getStartY());
        assertEquals(expect.getMyLine().getEndX(),actual.getMyLine().getEndX());
        assertEquals(expect.getMyLine().getEndY(),actual.getMyLine().getEndY());
        assertEquals(expect.getMyLine().getStroke(),actual.getMyLine().getStroke());
        assertEquals(expect.getMyLine().getStrokeWidth(),actual.getMyLine().getStrokeWidth());

    }
}
